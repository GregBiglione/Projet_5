package com.cleanup.todoc.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TodocDatabase;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectRepository {
    //----------------------------------
    //          Sans Executor
    //----------------------------------
    //private ProjectDao mProjectDao;
    //private LiveData<List<Project>> mAllProjects;
//
    //public ProjectRepository(Application application){
    //    TodocDatabase todocDatabase = TodocDatabase.getInstance(application);
    //    mProjectDao = todocDatabase.projectDao();
    //    mAllProjects = mProjectDao.getAllProjects();
    //}
//
    //public void createProject(Project project){
    //    new CreateProjectAsyncTask(mProjectDao).execute(project);
    //}
//
    //public void updateProject(Project project){
    //    new  UpdateProjectAsyncTask(mProjectDao).execute(project);
    //}
//
    //public LiveData<List<Project>> getAllProjects(){
    //    return mAllProjects;
    //}
//
    ////------------ Async create -------------------------------------------------------------------
    //private static class CreateProjectAsyncTask extends AsyncTask<Project, Void, Void>{
    //    private ProjectDao mProjectDao;
//
    //    private CreateProjectAsyncTask(ProjectDao mProjectDao){
    //       this.mProjectDao = mProjectDao;
    //    }
//
    //    @Override
    //    protected Void doInBackground(Project... projects) {
    //        mProjectDao.createProject(projects[0]);
    //        return null;
    //    }
    //}
//
    ////------------ Async update -------------------------------------------------------------------
    //private static class UpdateProjectAsyncTask extends AsyncTask<Project, Void, Void>{
    //    private ProjectDao mProjectDao;
//
    //    private UpdateProjectAsyncTask(ProjectDao mProjectDao){
    //        this.mProjectDao = mProjectDao;
    //    }
//
    //    @Override
    //    protected Void doInBackground(Project... projects) {
    //        mProjectDao.updateProject(projects[0]);
    //        return null;
    //    }
    //}
    //----------------------------------
    //          En vue d'ajouter l'Executor
    //----------------------------------
    private final ProjectDao mProjectDao;

    public ProjectRepository(ProjectDao mProjectDao) {
        this.mProjectDao = mProjectDao;
    }

    public LiveData<List<Project>> getAllProjects() { return this.mProjectDao.getAllProjects(); }

    public void createProject(Project project) { this.mProjectDao.createProject(project); }
}
