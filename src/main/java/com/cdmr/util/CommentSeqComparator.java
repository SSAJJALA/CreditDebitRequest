package com.cdmr.util;

import com.cdmr.entity.Comment;

import java.util.Comparator;

/**
 * Created by student on 9/30/16.
 */
public class CommentSeqComparator implements Comparator<Comment>{

    @Override
    public int compare(Comment o1, Comment o2) {
        return o1.getSeqID() - o2.getSeqID();
    } //Ascending
}
