package com.example.japp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japp.R;
import com.example.japp.adapters.UserAdapter.DataItemUpcomingListing;
import com.example.japp.databinding.ItemUserBinding;
import com.example.japp.models.response.UserData;

import java.util.Objects;


public class UserAdapter extends ListAdapter<DataItemUpcomingListing, RecyclerView.ViewHolder> {
    public static Object DiffCallbackUpcomingList;
    DiffCallbackUpcomingList mdiffCallback;
    UserClickListener mUserClickListener;

    public UserAdapter(@NonNull DiffCallbackUpcomingList diffCallback, UserClickListener userClickListener) {
        super(diffCallback);
        mdiffCallback = diffCallback;
        mUserClickListener = userClickListener;
    }

//    public UserAdapter(UserClickListener userClickListener) {
//        super(this);
//
//        mUserClickListener=userClickListener;
//
//    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.item_user, parent, false);
        ItemUserBinding binding =
                ItemUserBinding.inflate(
                        inflater,
                        parent,
                        false
                ); // add binding accordingly
        userViewHolder viewHolder = new userViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final int index = viewHolder.getAdapterPosition();
        ((userViewHolder) viewHolder).bind((UserData) getItem(position).user,mUserClickListener);
//        viewHolder.examName.setText(list.get(position).firstName +" "+list.get(position).lastName);

    }

    public class userViewHolder
            extends RecyclerView.ViewHolder {
        TextView examName;
        ItemUserBinding mBinding;

        userViewHolder(ItemUserBinding itemView) {
            super(itemView.getRoot());
            mBinding = itemView;
        }

        public void bind(UserData modelItem,UserClickListener clickListener) {
            if ((Integer.parseInt(modelItem.gettCount())/2) < 10) {
                modelItem.settCount("0");
            }
            mBinding.setClickListener(clickListener);
            mBinding.setUserData(modelItem);
            mBinding.executePendingBindings();

//            examName.setText(modelItem.getFirstName() + " " + modelItem.getLastName() + " " +
//                    modelItem.gettCount() + " age " + modelItem.getAgeCount());

        }
    }

    public static class DataItemUpcomingListing {
        UserData user;
        private int id;


        public DataItemUpcomingListing(UserData data) {
            id = data.getUid();
            user = data;
        }

        public DataItemUpcomingListing(int loaderId) {
            id = loaderId;
        }


    }

    public class DiffCallbackUpcomingList extends DiffUtil.ItemCallback<DataItemUpcomingListing> {
        @Override
        public boolean areItemsTheSame(@NonNull DataItemUpcomingListing oldItem, @NonNull DataItemUpcomingListing newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DataItemUpcomingListing oldItem, @NonNull DataItemUpcomingListing newItem) {
            return Objects.equals(oldItem, newItem);
        }
    }

    public interface UserClickListener {
        public void onDetailClicked(UserData model, View view);

    }

}


//        RecyclerView.Adapter<UserAdapter.userViewHolder> {
//    List<User> list = new ArrayList<>();
//
//    Context context;
//
//    public UserAdapter(List<User> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @Override
//    public userViewHolder onCreateViewHolder(ViewGroup parent,
//                                             int viewType) {
//
//        Context context
//                = parent.getContext();
//        LayoutInflater inflater
//                = LayoutInflater.from(context);
//
//        // Inflate the layout
//
//        View photoView = inflater.inflate(R.layout.item_user, parent, false);
//
//        userViewHolder viewHolder = new userViewHolder(photoView);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(final userViewHolder viewHolder,
//                                 final int position) {
//        final int index = viewHolder.getAdapterPosition();
//        viewHolder.examName.setText(list.get(position).firstName +" "+list.get(position).lastName);

//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public void updateList(  List<User> mlist ){
//        list=mlist;
//        notifyDataSetChanged();
//    }
//    @Override
//    public void onAttachedToRecyclerView(
//            RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }
//
//    public class userViewHolder
//            extends RecyclerView.ViewHolder {
//        TextView examName;
//
//
//        userViewHolder(View itemView) {
//            super(itemView);
//            examName = (TextView) itemView.findViewById(R.id.textView);
//
//        }
//    }
//
//}