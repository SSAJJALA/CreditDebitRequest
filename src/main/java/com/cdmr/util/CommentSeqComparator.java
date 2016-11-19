package com.cdmr.util;

import com.cdmr.entity.Comment;

import java.util.Comparator;

/**
 * CommentSeqComparator comparator class to sort based on comment seq.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-30
 */
public class CommentSeqComparator implements Comparator<Comment>{

    /**
     * compare method to compare two comments basedon seq
     * @param o1
     * @param o2
     * @return int difference between seq1 and seq2
     */
    @Override
    public int compare(Comment o1, Comment o2) {
        return o1.getSeqID() - o2.getSeqID();
    } //Ascending
}
