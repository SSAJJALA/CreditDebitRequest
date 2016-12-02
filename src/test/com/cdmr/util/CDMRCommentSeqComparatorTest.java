package com.cdmr.util;

import com.cdmr.Data.CDMRComment;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by student on 12/1/16.
 */
public class CDMRCommentSeqComparatorTest {
    CDMRComment cdmrComment1 = null;
    CDMRComment cdmrComment2 = null;
    CDMRCommentSeqComparator comparator = null;

    @Before
    public void setUp() throws Exception {
        cdmrComment1 = new  CDMRComment();
        cdmrComment2 = new  CDMRComment();
        comparator = new CDMRCommentSeqComparator();
    }

    @Test
    public void compare() throws Exception {
        cdmrComment1.setCreatedDate(LocalDateTime.now());
        cdmrComment1.setSeqID(2);
        cdmrComment1.setComment("Test comment 1");
        cdmrComment1.setUserID("VYU6026");
        cdmrComment1.setItemNum(2345);
        cdmrComment1.setRequisitionID(123);

        cdmrComment2.setCreatedDate(LocalDateTime.now());
        cdmrComment2.setSeqID(1);
        cdmrComment2.setComment("Test comment 2");
        cdmrComment2.setUserID("VYU6026");
        cdmrComment2.setItemNum(2346);
        cdmrComment2.setRequisitionID(124);

        int diff = comparator.compare(cdmrComment1, cdmrComment2);

        assertEquals("comparator failed", 1, diff);


    }

}