package com.cleanup.todoc.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectRepository;
import com.cleanup.todoc.repositories.TaskRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class MainViewModel extends ViewModel {

    // -------------- Repository -------------------------------------------------------------------
    private final ProjectRepository mProjectRepository;
    private final TaskRepository mTaskRepository;
    private final Executor executor;

    public MainViewModel(ProjectRepository mProjectRepository, TaskRepository mTaskRepository, Executor executor) {
        this.mProjectRepository = mProjectRepository;
        this.mTaskRepository = mTaskRepository;
        this.executor = executor;
    }

    // -------------- Projects Actions -------------------------------------------------------------
    public LiveData<List<Project>> getAllProjects() { return mProjectRepository.getAllProjects(); }

    public void createProject(Project project) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mProjectRepository.createProject(project);
            }
        });
    }

    // -------------- Tasks Actions ----------------------------------------------------------------
    public LiveData<List<Task>> getAllTasks() { return mTaskRepository.getAllTasks(); }

    public void insertTask(Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mTaskRepository.insertTask(task);
            }
        });
    }

    public void deleteTask(Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mTaskRepository.deleteTask(task);
            }
        });
    }
}
