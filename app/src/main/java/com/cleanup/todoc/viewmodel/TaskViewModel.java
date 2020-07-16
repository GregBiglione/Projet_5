package com.cleanup.todoc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mTaskRepository;
    private LiveData<List<Task>> mTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        mTaskRepository = new TaskRepository(application);
        mTasks = mTaskRepository.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks(){
        return mTasks;
    }

    public void updateTask(Task task){
        mTaskRepository.updateTask(task);
    }

    public void insertTask(Task task){
        mTaskRepository.insertTask(task);
    }

    public void deleteTask(Task task){
        mTaskRepository.deleteTask(task);
    }
}
