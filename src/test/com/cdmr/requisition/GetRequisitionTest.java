package com.cdmr.requisition;

import com.cdmr.Data.CDMR;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 12/4/16.
 */
public class GetRequisitionTest {
    GetRequisition getRequisition = null;

    @Before
    public void setUp() throws Exception {
        getRequisition = new GetRequisition();
    }
    @Test
    public void getRequisitionID() throws Exception {
        getRequisition.setRequisitionID(68);
        CDMR cdmr = getRequisition.getRequisition();
        assertEquals("Unable to get Requisition 68", 68, cdmr.getRequisitionID());


    }

}