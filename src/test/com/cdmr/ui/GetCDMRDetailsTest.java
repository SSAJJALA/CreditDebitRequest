package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.entity.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 11/4/16.
 */
public class GetCDMRDetailsTest {

    GetCDMRDetails getCDMR = null;

    @Before
    public void setUp() {
        getCDMR = new GetCDMRDetails(0,47,"VYU6026");
    }


    @Test
    public void getCDMRTest() throws Exception {
        CDMR cdmr = getCDMR.getCDMR();
        assertNotNull("get cdmr details failed", cdmr);

    }

    @Test
    public void getTaskDetailsTest() throws Exception {
        Task task = getCDMR.getTaskDetails();
        assertNotNull("get cdmr details failed", task);

    }


}