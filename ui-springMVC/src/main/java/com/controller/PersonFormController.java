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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author gelz
 */
@Controller
@RequestMapping("personform")
public class PersonFormController {
    private PersonServices personServices;
    

    @Autowired
    public void setPersonServices(final PersonServices personServices) {
        this.personServices = personServices;
    }
    
    @RequestMapping(method= RequestMethod.GET)
    public ModelMap displayForm(@RequestParam(value="person_id",required=false)Long id){
        Person person = personServices.getPersonById(id);
        if (person==null) person = new Person();        
        return new ModelMap(person);
    }
    
    @RequestMapping(method= RequestMethod.POST)
    public String processForm(@ModelAttribute("person") Person person,BindingResult result,SessionStatus status){
      new PersonValidator().validate(person, result);
      if(result.hasErrors()){
      return "personform";
      }
      else{
      personServices.save(person);
      status.setComplete();
      return "redirect:personlist";
      }
    }        
}
