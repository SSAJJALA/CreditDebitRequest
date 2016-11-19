package com.cdmr.util;

import com.cdmr.Data.CDMRComment;

import java.util.Comparator;

/**
 * CDMRCommentSeqComparator comparator class to sort based on comment seq.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-30
 */
public class CDMRCommentSeqComparator implements Comparator<CDMRComment> {

    /**
     * compare method to compare two comments basedon seq
     * @param o1
     * @param o2
     * @return int difference between seq1 and seq2
     */
    @Override
    public int compare(CDMRComment o1, CDMRComment o2) {
        return o1.getSeqID() - o2.getSeqID(); //Ascending
    }
}
