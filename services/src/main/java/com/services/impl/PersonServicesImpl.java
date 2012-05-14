/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.impl;

import com.services.PersonServices;
import java.util.List;
import com.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gelz
 */
@Repository("personServices")
@Transactional(readOnly=true)
public class PersonServicesImpl implements PersonServices{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional(readOnly=false)
    @Override
    public void save(Person p) {
        sessionFactory.getCurrentSession().saveOrUpdate(p);
    }

    @Transactional(readOnly=false)
    @Override
    public void delete(Person p) {
        sessionFactory.getCurrentSession().delete(p);
    }

    @Transactional
    @Override
    public Person getPersonById(Long id) {
        return (Person) sessionFactory.getCurrentSession()
                .createQuery("from Person where id =:id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional
    @Override
    public List<Person> getAllPerson() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }
    
}
