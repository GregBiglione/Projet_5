package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getAllTasks();

    @Insert
    void insertTask(Task task);

    //@Update
    //void updateTask(Task task);

    @Delete
    void deleteTask(Task task);

    //@Query("SELECT * FROM Task ORDER BY name ASC")
    //LiveData<List<Task>> getTasksAToZ();

    //@Query("SELECT * FROM Task ORDER BY name DESC")
    //LiveData<List<Task>> getTasksZToA();
}
