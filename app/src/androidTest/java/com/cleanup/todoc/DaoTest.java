package com.cleanup.todoc;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cleanup.todoc.database.dao.TodocDatabase;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DaoTest {

    // ------------------------- For Data ----------------------------------------------------------
    private TodocDatabase database;

    // ------------------------- Data set for test -------------------------------------------------
    private static Task TASK_DEMO = new Task(3L, "Photocopier du sable", 1608218497);
    private static Project PROJECT_DEMO = new Project(3L, "Projet test", 0xFFA3CED2);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {
        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                TodocDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void insertTaskAndGetAllTasks() throws InterruptedException{
        // ------------------------- Before: Adding Project & task ---------------------------------
        this.database.projectDao().createProject(PROJECT_DEMO);
        this.database.taskDao().insertTask(TASK_DEMO);
        // ------------------------- Test ----------------------------------------------------------
        List<Task> tasks = LiveDataTestUtil.getValue(this.database.taskDao().getAllTasks());
        assertTrue(tasks.size() == 1);
    }

    @Test
    public void getTasksWhenNoTaskInserted() throws InterruptedException{
        List<Task> tasks = LiveDataTestUtil.getValue(this.database.taskDao().getAllTasks());
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void insertTaskAndDeleteTask() throws InterruptedException{
        // ------------------------- Before: Adding Project & task ---------------------------------
        this.database.projectDao().createProject(PROJECT_DEMO);
        this.database.taskDao().insertTask(TASK_DEMO);
        Task taskAdded = LiveDataTestUtil.getValue(this.database.taskDao().getAllTasks()).get(0);
        this.database.taskDao().deleteTask(taskAdded);
        // ------------------------- Test ----------------------------------------------------------
        List<Task> tasks = LiveDataTestUtil.getValue(this.database.taskDao().getAllTasks());
        assertTrue(tasks.size() == 0);
    }

    @Test
    public void insertProjectAndGetAllProjects() throws InterruptedException{
        // ------------------------- Before: Adding Project ----------------------------------------
        this.database.projectDao().createProject(PROJECT_DEMO);
        // ------------------------- Test ----------------------------------------------------------
        List<Project> projects = LiveDataTestUtil.getValue(this.database.projectDao().getAllProjects());
        assertTrue(projects.size() == 1);
    }
}
