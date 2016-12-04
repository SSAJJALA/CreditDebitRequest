package com.cdmr.persistence;

import com.cdmr.entity.Requisition;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 12/4/16.
 */
public class RequisitionDAOnewTest {
    private final Logger log = Logger.getLogger(this.getClass());
    RequisitionDAOnew requisitionDAOnew = null;

    @Before
    public void setUp() throws Exception {
        requisitionDAOnew = new RequisitionDAOnew();
    }

    @Test
    public void getAll() throws Exception {
        List<Requisition> reqs = (List<Requisition>) requisitionDAOnew.getAll();
        assertNotNull("unable to get all requisitions", reqs);
    }

    @Test
    public void getOne() throws Exception {
        Requisition  req = (Requisition) requisitionDAOnew.getOne(67);
        assertNotNull("Unable to fetch requisition 67", req);
    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void getLastReqID() throws Exception {
        int reqID = requisitionDAOnew.getLastReqID();
        assertEquals("unable to get latest req id", reqID, 67);
    }

    @Test
    public void delete() throws Exception {
        requisitionDAOnew.delete(1);
        Requisition  req = (Requisition) requisitionDAOnew.getOne(1);
        assertNotNull("Unable to delete requisition", req);

    }

    @Test
    public void update() throws Exception {
        Requisition req = (Requisition) requisitionDAOnew.getOne(10);
        requisitionDAOnew.update(req);
        assertNotNull("Unable to update requisition", requisitionDAOnew.getOne(10));

    }

}