package com.cdmr.ui;

import com.cdmr.entity.SearchCDMR;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 9/23/16.
 */
public class SearchTest {

    Search search = null;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        search = new Search("requisitionID", "=", "10");
    }
    @Test
    public void search() throws Exception {
        List<SearchCDMR> results = null;
        results = search.search();
        log.info("Search results:" + results);
        //assertTrue("search failed", results.size() == 0);
        assertNotNull("search failed for requisition id 10", results);

    }

}