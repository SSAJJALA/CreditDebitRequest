package com.cdmr.persistence;

import com.cdmr.entity.Requisition;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 9/16/16.
 */
public class RequisitionDaoTest {
    RequisitionDao requisitionDao = null;


    @Before
    public void setUp() throws Exception {
        requisitionDao = new RequisitionDao();
    }
    @Test
    public void getAllRequisitions() throws Exception {
        List<Requisition> reqs = requisitionDao.getAllRequisitions();
        assertNotNull("unable to get all reqs", reqs);
    }

    @Test
    public void getRequisition() throws Exception {

    }

    @Test
    public void addRequisition() throws Exception {

    }

    @Test
    public void getLastReqID() throws Exception {

    }

    @Test
    public void deleteRequisition() throws Exception {

    }

    @Test
    public void updateReq() throws Exception {

    }

}