package com.example.japp.di;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.japp.models.response.User;
import com.example.japp.network.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
