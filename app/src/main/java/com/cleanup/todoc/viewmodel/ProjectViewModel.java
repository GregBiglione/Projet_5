package com.cleanup.todoc.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.repositories.ProjectRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class ProjectViewModel extends ViewModel {

    // -------------- Repository -------------------------------------------------------------------
    private final ProjectRepository mProjectRepository;
    private final Executor executor;

    public ProjectViewModel(ProjectRepository mProjectRepository, Executor executor) {
        this.mProjectRepository = mProjectRepository;
        this.executor = executor;
    }

    // -------------- Actions possible -------------------------------------------------------------
    public LiveData<List<Project>> getAllProjects() { return mProjectRepository.getAllProjects(); }

    public void createProject(Project project) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mProjectRepository.createProject(project);
            }
        });
    }
}
