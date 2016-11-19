package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.TaskResponse;
import com.cdmr.approval.RouteCDMR;
import org.apache.log4j.Logger;

/**
 * CompleteTask class to complete the task after the user approval or rejection of a cdmr
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-23
 */
public class CompleteTask {

    public TaskResponse taskResponse;
    public CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * arg constructor
     * @param taskResponse
     * @param cdmr
     */
    public CompleteTask(TaskResponse taskResponse, CDMR cdmr) {
        this.taskResponse = taskResponse;
        this.cdmr = cdmr;
    }

    /**
     * get task response
     * @return taskResponse
     */
    public TaskResponse getTaskResponse() {
        return taskResponse;
    }

    /**
     * sets the task response
     * @param taskResponse
     */
    public void setTaskResponse(TaskResponse taskResponse) {
        this.taskResponse = taskResponse;
    }

    /**
     * get CDMR
     * @return CDMR
     */
    public CDMR getCdmr() {
        return cdmr;
    }

    /**
     * set CDMR
     * @param cdmr
     */
    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    /**
     * main method to complete the task
     * @return
     */
    public String completeTaskAndRouteCDMR() {
        RouteCDMR routeCDMR = new RouteCDMR(cdmr, taskResponse);
        String message = routeCDMR.routeCDMR();
        return message;
    }
}
