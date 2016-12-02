package com.cdmr.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 9/24/16.
 */

@Entity
@Table(name="TASK_ASSIGNMENT")
public class TaskAssignment {

    @EmbeddedId
    private TaskAssignmentPK taskuser;

    @Column(name="REQUISITION_ID")
    private int requisitionID;

    public TaskAssignment() {
    }

    public TaskAssignment(TaskAssignmentPK taskuser, int requisitionID) {
        this();
        this.taskuser = taskuser;
        this.requisitionID = requisitionID;
    }

    public TaskAssignmentPK getTaskuser() {
        return taskuser;
    }

    public void setTaskuser(TaskAssignmentPK taskuser) {
        this.taskuser = taskuser;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    @Override
    public String toString() {
        return "TaskAssignment{" +
                "taskuser=" + taskuser +
                ", requisitionID=" + requisitionID +
                '}';
    }
}
