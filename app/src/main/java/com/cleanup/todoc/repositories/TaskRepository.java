package com.cleanup.todoc.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.database.dao.TodocDatabase;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskRepository {
    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;
    private LiveData<List<Task>> mTasksAtoZ;

    public TaskRepository(Application application){
        TodocDatabase todocDatabase = TodocDatabase.getInstance(application);
        mTaskDao = todocDatabase.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
        mTasksAtoZ = mTaskDao.getTasksAToZ();
    }

    public void insertTask(Task task){new InsertTaskAsyncTask(mTaskDao).execute(task); }

    public void updateTask(Task task){
        new UpdateTaskAsyncTask(mTaskDao).execute(task);
    }

    public void deleteTask(Task task){
        new DeleteTaskAsyncTask(mTaskDao).execute(task);
    }

    public LiveData<List<Task>> getAllTasks(){
        return mAllTasks;
    }

    public LiveData<List<Task>> getTasksAtoZ()  { return mTasksAtoZ; }

    //------------ Async insert -------------------------------------------------------------------
    private static class InsertTaskAsyncTask extends AsyncTask<Task, Void, Void>{
        private TaskDao mTaskDao;

        private InsertTaskAsyncTask(TaskDao mTaskDao){
            this.mTaskDao = mTaskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mTaskDao.insertTask(tasks[0]);
            return null;
        }
    }

    //------------ Async update-------------------------------------------------------------------
    private static class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void>{
        private TaskDao mTaskDao;

        private UpdateTaskAsyncTask(TaskDao mTaskDao){
            this.mTaskDao = mTaskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mTaskDao.updateTask(tasks[0]);
            return null;
        }
    }

    //------------ Async delete -------------------------------------------------------------------
    private static class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void>{
        private TaskDao mTaskDao;

        private DeleteTaskAsyncTask(TaskDao mTaskDao){
            this.mTaskDao = mTaskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mTaskDao.deleteTask(tasks[0]);
            return null;
        }
    }
}
