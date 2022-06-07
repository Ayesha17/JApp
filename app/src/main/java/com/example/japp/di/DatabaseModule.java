package com.example.japp.di;

import android.content.Context;

import androidx.room.Room;

import com.example.japp.network.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DatabaseModule {
    @Provides
    public UserDao provideUserDao(AppDatabase appDatabase) {
        return appDatabase.userDao();
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(@ApplicationContext Context appContext) {
        return Room.databaseBuilder(
                appContext,
                AppDatabase.class,
                "RssReader"
        ) .build();
    }
}
