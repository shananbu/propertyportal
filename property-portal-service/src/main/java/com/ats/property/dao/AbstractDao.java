package com.ats.property.dao;

import com.google.common.base.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The AbstractDao.
 *
 * @author anbarasan.s
 */
public class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

/*    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }*/

    protected Session getSession(){
        if(Optional.fromNullable(sessionFactory.getCurrentSession()).isPresent()) {
            return getCurrentSession();
        } else {
            return sessionFactory.openSession();
        }
      }

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    public Object persist(Object entity) {
        getSession().saveOrUpdate(entity);
       // getSession().flush();
        getSession().refresh(entity);
        return entity;
    }

    public Object get(Object entity) {
        getSession().refresh(entity);
        return entity;
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
