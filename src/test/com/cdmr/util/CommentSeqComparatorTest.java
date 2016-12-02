package com.cdmr.util;

import com.cdmr.Data.CDMRComment;
import com.cdmr.entity.Comment;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by student on 12/1/16.
 */
public class CommentSeqComparatorTest {
    Comment cdmrComment1 = null;
    Comment cdmrComment2 = null;
    CommentSeqComparator comparator = null;

    @Before
    public void setUp() throws Exception {
        cdmrComment1 = new  Comment();
        cdmrComment2 = new  Comment();
        comparator = new CommentSeqComparator();
    }

    @Test
    public void compare() throws Exception {
        cdmrComment1 = new Comment();
        cdmrComment1.setItemNum(2345);
        cdmrComment1.setRequisitionID(123);
        cdmrComment1.setUserID("VYU6026");
        cdmrComment1.setComment("Test comment1");
        cdmrComment1.setCommentID(1);
        cdmrComment1.setCreatedDate(LocalDateTime.now());
        cdmrComment1.setSeqID(2);

        cdmrComment2 = new Comment();
        cdmrComment2.setItemNum(2345);
        cdmrComment2.setRequisitionID(124);
        cdmrComment2.setUserID("VYU6026");
        cdmrComment2.setComment("Test comment2");
        cdmrComment2.setCommentID(2);
        cdmrComment2.setCreatedDate(LocalDateTime.now());
        cdmrComment1.setSeqID(1);

        comparator = new CommentSeqComparator();

        int diff = comparator.compare(cdmrComment1, cdmrComment2);

        assertEquals("comparator failed", 1, diff);


    }

}