package com.cleanup.todoc.injections;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.cleanup.todoc.repositories.TaskRepository;
import com.cleanup.todoc.viewmodel.TaskViewModel;

import java.util.concurrent.Executor;

public class ViewTaskModelFactory implements ViewModelProvider.Factory {

    private final TaskRepository mTaskRepository;
    private final Executor executor;

    public ViewTaskModelFactory(TaskRepository mTaskRepository, Executor executor) {
        this.mTaskRepository = mTaskRepository;
        this.executor = executor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(TaskViewModel.class)){
            return (T) new TaskViewModel(mTaskRepository, executor);
        }
        throw new IllegalArgumentException("Unknown  ViewModel class");
    }
}
