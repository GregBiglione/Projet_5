package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectRepository {

    private final ProjectDao mProjectDao;

    public ProjectRepository(ProjectDao mProjectDao) {
        this.mProjectDao = mProjectDao;
    }

    public LiveData<List<Project>> getAllProjects() { return this.mProjectDao.getAllProjects(); }

    public void createProject(Project project) { this.mProjectDao.createProject(project); }
}
