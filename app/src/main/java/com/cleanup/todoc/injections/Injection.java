package com.cleanup.todoc.injections;

import android.content.Context;

import com.cleanup.todoc.database.dao.TodocDatabase;
import com.cleanup.todoc.repositories.ProjectRepository;
import com.cleanup.todoc.repositories.TaskRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Injection {

    public static TaskRepository provideTaskRepository(Context context){
        TodocDatabase todocDatabase = TodocDatabase.getInstance(context);
        return new TaskRepository(todocDatabase.taskDao());
    }

    public static ProjectRepository provideProjectRepository(Context context){
        TodocDatabase todocDatabase = TodocDatabase.getInstance(context);
        return new ProjectRepository(todocDatabase.projectDao());
    }

    public static Executor provideExecutor(){ return Executors.newSingleThreadExecutor(); }

    public static ViewModelFactory provideViewModelFactory(Context context){
        TaskRepository mTaskRepository = provideTaskRepository(context);
        ProjectRepository mProjectRepository = provideProjectRepository(context);
        Executor executor = provideExecutor();
        return new ViewModelFactory(mTaskRepository, mProjectRepository, executor);
    }
}
