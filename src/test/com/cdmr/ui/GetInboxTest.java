package com.cdmr.ui;

import com.cdmr.entity.SearchInbox;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 9/24/16.
 */
public class GetInboxTest {

    GetInbox inbox = null;

    @Before
    public void setUp() {
        inbox = new GetInbox("SSAJJALA");
    }

    @Test
    public void getTasks() throws Exception {
        List<SearchInbox> myInbox =  inbox.getTasks();
        assertNull("get inbox failed", myInbox);

    }

}