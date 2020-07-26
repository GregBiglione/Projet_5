package com.cleanup.todoc.injections;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.cleanup.todoc.repositories.ProjectRepository;
import com.cleanup.todoc.repositories.TaskRepository;
import com.cleanup.todoc.viewmodel.MainViewModel;

import java.util.concurrent.Executor;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final TaskRepository mTaskRepository;
    private final ProjectRepository mProjectRepository;
    private final Executor executor;

    public ViewModelFactory(TaskRepository mTaskRepository, ProjectRepository mProjectRepository, Executor executor) {
        this.mTaskRepository = mTaskRepository;
        this.mProjectRepository = mProjectRepository;
        this.executor = executor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            return (T) new MainViewModel(mProjectRepository, mTaskRepository, executor);
        }
        throw new IllegalArgumentException("Unknown  ViewModel class");
    }
}
