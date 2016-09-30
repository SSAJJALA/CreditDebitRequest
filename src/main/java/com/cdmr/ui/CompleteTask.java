package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.TaskResponse;
import com.cdmr.approval.RouteCDMR;
import org.apache.log4j.Logger;

/**
 * Created by student on 9/30/16.
 */
public class CompleteTask {

    public TaskResponse taskResponse;
    public CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    public CompleteTask(TaskResponse taskResponse, CDMR cdmr) {
        this.taskResponse = taskResponse;
        this.cdmr = cdmr;
    }

    public TaskResponse getTaskResponse() {
        return taskResponse;
    }

    public void setTaskResponse(TaskResponse taskResponse) {
        this.taskResponse = taskResponse;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public String completeTaskAndRouteCDMR() {
        RouteCDMR routeCDMR = new RouteCDMR(cdmr, taskResponse);
        String message = routeCDMR.routeCDMR();
        return message;
    }
}
