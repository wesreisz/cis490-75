package com.example.wesleyreisz.todolist.model;

/**
 * Created by wesleyreisz on 11/8/15.
 */
public class Task {
    public String taskId;
    public String name;

    public Task(){}

    public Task(String taskId, String name) {
        this.taskId = taskId;
        this.name = name;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
