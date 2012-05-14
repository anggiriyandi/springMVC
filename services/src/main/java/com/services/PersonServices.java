/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import java.util.List;
import com.model.Person;

/**
 *
 * @author gelz
 */
public interface PersonServices {
    public void save(Person p);
    public void delete(Person p);
    public Person getPersonById(Long id);
    public List<Person> getAllPerson();
}
