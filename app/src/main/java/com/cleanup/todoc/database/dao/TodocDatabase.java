package com.cleanup.todoc.database.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

@Database(entities = {Task.class, Project.class}, version = 1, exportSchema = false)
public abstract class TodocDatabase extends RoomDatabase {

    //--------- SINGLETON --------------
    private static TodocDatabase instance;

    //--------- DAO --------------
    public abstract TaskDao taskDao();
    public abstract ProjectDao projectDao();

    //--------- INSTANCE --------------
    public static synchronized TodocDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TodocDatabase.class, "TodocDatabase.db")
                    .build();
        }
        return instance;
    }
}
