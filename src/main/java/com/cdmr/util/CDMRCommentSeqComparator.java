package com.cdmr.util;

import com.cdmr.Data.CDMRComment;

import java.util.Comparator;

/**
 * Created by student on 9/30/16.
 */
public class CDMRCommentSeqComparator implements Comparator<CDMRComment> {
    @Override
    public int compare(CDMRComment o1, CDMRComment o2) {
        return o1.getSeqID() - o2.getSeqID(); //Ascending
    }
}
