package com.cleanup.todoc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.repositories.ProjectRepository;

import java.util.List;

public class ProjectViewmodel extends AndroidViewModel {

    private ProjectRepository mProjectRepository;
    private LiveData<List<Project>> mProjects;

    public ProjectViewmodel(@NonNull Application application) {
        super(application);
        mProjectRepository = new ProjectRepository(application);
        mProjects = mProjectRepository.getAllProjects();
    }

    public LiveData<List<Project>> getAllProjects(){
        return mProjects;
    }

    public void createProject(Project project){
        mProjectRepository.createProject(project);
    }

    public void updateProject(Project project){
        mProjectRepository.updateProject(project);
    }
}
