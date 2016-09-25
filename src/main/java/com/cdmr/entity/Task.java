package com.cdmr.entity;

import com.cdmr.util.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by student on 9/24/16.
 */

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @Column(name = "TASK_ID")
    private int taskID;

    @Column(name="CREATED_DATE")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate createdDate;

    public Task() {
    }

    public Task(int taskID, LocalDate createdDate) {
        this.taskID = taskID;
        this.createdDate = createdDate;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", createdDate=" + createdDate +
                '}';
    }
}
