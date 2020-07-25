package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskRepository {

    private final TaskDao mTaskDao;

    public TaskRepository(TaskDao mTaskDao) {
        this.mTaskDao = mTaskDao;
    }

    public LiveData<List<Task>> getAllTasks() { return this.mTaskDao.getAllTasks(); }

    public void insertTask(Task task) { this.mTaskDao.insertTask(task); }

    public void deleteTask(Task task) { this.mTaskDao.deleteTask(task); }
}
