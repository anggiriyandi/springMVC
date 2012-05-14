/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Person;
import com.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gelz
 */
@Controller
public class PersonController {
    private PersonServices personServices;

    @Autowired
    public void setPersonServices(PersonServices personServices) {
        this.personServices = personServices;
    }
    
    @RequestMapping("/personlist")
    public ModelMap list(){
    return new ModelMap(personServices.getAllPerson());
    }
    
    @RequestMapping("/persondetail")
    public ModelMap detail(@RequestParam("person_id") Long personId ){
        return new ModelMap(personServices.getPersonById(personId));
    }
    
    @RequestMapping(value="/delete",method= RequestMethod.GET)
    public String deletePerson(@RequestParam("person_id") Long personId){
        Person p = personServices.getPersonById(personId);
        personServices.delete(p);
        return "redirect:personlist";
    }
    
    
}