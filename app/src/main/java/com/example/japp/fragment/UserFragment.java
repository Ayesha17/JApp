package com.example.japp.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japp.R;
import com.example.japp.adapters.UserAdapter;
import com.example.japp.models.response.User;
import com.example.japp.models.response.UserData;
import com.example.japp.network.UserDao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserFragment extends Fragment {
    @Inject
    UserDao userDao;
    List<UserData> list = new ArrayList<>();
    UserAdapter adapter;
    UserData rmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main, container, false);
        adapter = new UserAdapter((UserAdapter.DiffCallbackUpcomingList) UserAdapter.DiffCallbackUpcomingList, (UserAdapter.UserClickListener) (model, view1) -> {
            rmodel = model;
        });

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserData> lists = list;
                int pos = lists.indexOf(rmodel);
                if(pos!=-1){
                    UserData userData=new UserData(rmodel.getUid(),"Ayeshaaaa","Shahid dd",
                            "-1","-1");

                    lists.add(pos,userData);
                }
//                for (User resultData : result)
//                    list.add(new UserData(resultData.uid, resultData.firstName, resultData.lastName, resultData.tCount, resultData.AgeCount));
//            adapter.updateList(list);
                List<UserAdapter.DataItemUpcomingListing> f = new ArrayList<>();
                for (UserData sb : lists)
                    f.add(new UserAdapter.DataItemUpcomingListing(sb));
                adapter.submitList(f);

            }
        });
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    while(true) {
//                        sleep(1000);
//        new MyTask().execute();
        userDao.getAll().observe(getViewLifecycleOwner(), result -> {
            Log.e(UserFragment.class.getSimpleName(), "result " + result.size());
            for (User resultData : result)
                list.add(new UserData(resultData.uid, resultData.firstName, resultData.lastName, resultData.tCount, resultData.AgeCount));
//            adapter.updateList(list);
            List<UserAdapter.DataItemUpcomingListing> f = new ArrayList<>();
            for (UserData sb : list)
                f.add(new UserAdapter.DataItemUpcomingListing(sb));
            adapter.submitList(f);

        });
//                handler.postDelayed(this, 1000);

//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        thread.start();

        Log.e("size", "size " + list.size());


        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        // Inflate the layout for this fragment
        return view;
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
//            list = userDao.getAll();

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
//            adapter.updateList(list);
        }
    }
}