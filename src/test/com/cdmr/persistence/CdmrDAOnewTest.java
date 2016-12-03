package com.cdmr.persistence;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 12/3/16.
 */
public class CdmrDAOnewTest {
    CdmrDAOnew cdmrDaoNew = null;

    @Before
    public void setUp() throws Exception {
        cdmrDaoNew = new CdmrDAOnew();
    }

    @Test
    public void getAll() throws Exception {
        List<?> cdmrs = cdmrDaoNew.getAll();
        assertNotNull("CDMR get all failed", cdmrs);

    }

    @Test
    public void getOne() throws Exception {

    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void getWithFilters() throws Exception {

    }

}