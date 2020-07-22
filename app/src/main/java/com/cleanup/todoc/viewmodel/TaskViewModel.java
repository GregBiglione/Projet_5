package com.cleanup.todoc.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.TaskRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    // -------------- Repository -------------------------------------------------------------------
    private final TaskRepository mTaskRepository;
    private final Executor executor;

    public TaskViewModel(TaskRepository mTaskRepository, Executor executor) {
        this.mTaskRepository = mTaskRepository;
        this.executor = executor;
    }

    // -------------- Actions possible -------------------------------------------------------------
    public LiveData<List<Task>> getAllTasks() { return mTaskRepository.getAllTasks(); }

    public void insertTask(Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mTaskRepository.insertTask(task);
            }
        });
    }

    public void deleteTask(Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mTaskRepository.deleteTask(task);
            }
        });
    }
}
