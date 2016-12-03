package com.cdmr.approval;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.TaskResponse;
import com.cdmr.requisition.GetRequisition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Siva Sajjala on 12/2/16.
 */
public class RouteCDMRTest {
    RouteCDMR route = null;

    @Before
    public void setUp() throws Exception {
        GetRequisition getCDMR = new GetRequisition(66);
        CDMR cdmr = getCDMR.getRequisition();
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskName("DSM Approval");
        taskResponse.setTaskID(61);
        taskResponse.setApproverID("VYU6026");
        taskResponse.setApprovalDecesion("Approved");
        route = new RouteCDMR(cdmr, taskResponse);
    }

    @Test
    public void routeCDMR() throws Exception {
        String message = route.routeCDMR();
        assertNotNull("Route CDMR failed", message);

    }

}