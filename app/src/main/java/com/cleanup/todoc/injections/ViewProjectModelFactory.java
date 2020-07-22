package com.cleanup.todoc.injections;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.cleanup.todoc.repositories.ProjectRepository;
import com.cleanup.todoc.viewmodel.ProjectViewModel;

import java.util.concurrent.Executor;

public class ViewProjectModelFactory implements ViewModelProvider.Factory {

    private final ProjectRepository mProjectRepository;
    private final Executor executor;

    public ViewProjectModelFactory(ProjectRepository mProjectRepository, Executor executor) {
        this.mProjectRepository = mProjectRepository;
        this.executor = executor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ProjectViewModel.class)){
            return (T) new ProjectViewModel(mProjectRepository, executor);
        }
        throw new IllegalArgumentException("Unknown  ViewModel class");
    }
}
