package com.cdmr.persistence;

import com.cdmr.entity.Cdmr;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 12/3/16.
 */
public class CdmrDAOnewTest {
    CdmrDAOnew cdmrDaoNew = null;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception {
        cdmrDaoNew = new CdmrDAOnew();
    }

    @Test
    public void getAll() throws Exception {
        List<Cdmr> cdmrs = (List<Cdmr>) cdmrDaoNew.getAll();
        for (Cdmr tempcdmr : cdmrs) {
            log.info(tempcdmr.getRequisitionID());
        }
        assertNotNull("CDMR get all failed", cdmrs);

    }

    @Test
    public void getOne() throws Exception {
        Cdmr cdmr = (Cdmr) cdmrDaoNew.getOne(66);
        assertNotNull("CDMR getOne() failed", cdmr);

    }

    @Test
    public void delete() throws Exception {
        cdmrDaoNew.delete(53);
        Cdmr cdmr = (Cdmr) cdmrDaoNew.getOne(55);
        assertNull("Delete failed", cdmr);
    }

    @Test
    public void update() throws Exception {
        Cdmr cdmr = (Cdmr) cdmrDaoNew.getOne(66);
        cdmrDaoNew.update(cdmr);

    }

    @Test
    public void getWithFilters() throws Exception {
        List<Cdmr> cdmrs = (List<Cdmr>)cdmrDaoNew.getWithFilters("requisitionID","=","61");
        for (Cdmr tempcdmr : cdmrs) {
            log.info(tempcdmr.getRequisitionID());
        }
        assertNotNull("CDMR get all failed", cdmrs);

    }

}