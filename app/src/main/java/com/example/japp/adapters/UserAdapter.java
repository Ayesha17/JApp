package com.example.japp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.japp.R;
import com.example.japp.models.response.User;

import java.util.ArrayList;
import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.userViewHolder> {
    List<User> list = new ArrayList<>();

    Context context;

    public UserAdapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public userViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {

        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.item_user, parent, false);

        userViewHolder viewHolder = new userViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final userViewHolder viewHolder,
                                 final int position) {
        final int index = viewHolder.getAdapterPosition();
        viewHolder.examName.setText(list.get(position).firstName +" "+list.get(position).lastName);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateList(  List<User> mlist ){
        list=mlist;
        notifyDataSetChanged();
    }
    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class userViewHolder
            extends RecyclerView.ViewHolder {
        TextView examName;


        userViewHolder(View itemView) {
            super(itemView);
            examName = (TextView) itemView.findViewById(R.id.textView);

        }
    }

}