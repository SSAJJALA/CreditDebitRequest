package com.cdmr.persistence;

import com.cdmr.entity.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 12/3/16.
 */
public abstract class GenericDAO {

    abstract protected Session getSession() ;

    public List<?> getAll() throws HibernateException {

        return new ArrayList<Object>();
    }

    public Object getOne(int t) throws HibernateException {

        return null;
    }

    public int add(Object obj) throws HibernateException {

        return 0;
    }

    public void delete(int t) throws HibernateException {

    }

    public void update(Object obj) throws HibernateException {

    }

    public List<?> getWithFilters(String a, String b, String c) throws HibernateException {

        return new ArrayList<Object>();
    }

    public List<?> getWithFilterObjects(List<?> obj) throws HibernateException {

        return new ArrayList<Object>();
    }

    public int getMaxID() {
        return 0;
    }
}
