/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Person;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 *
 * @author gelz
 */
public class PersonValidator {
    private static final String EMAIL_FORMAT = ".*@.*\\.com"; 
    	private static final String FIELD_EMAIL = "email";
	private static final String FIELD_NAME = "name";
	private static final String PERSON_EMAIL_MALFORMED_KEY = "person.email.malformed";
	private static final String DEFAULT_ERROR_MESSAGE = "DEFAULT ERROR MESSAGE, PLEASE OVERRIDE";
	private static final String PERSON_NAME_REQUIRED_KEY = "person.name.required";
    
    public void validate(Person person , Errors errors ){
    //field nama harus diisi
        if(!StringUtils.hasText(person.getNama())){
            errors.rejectValue("nama","required","nama harus diisi");
        }
    //field email harus diisi,formatnya harus benar
     if(StringUtils.hasLength(person.getEmail()) && !person.getEmail().matches(EMAIL_FORMAT)){
         errors.rejectValue("email", "email.format","format email salah");
     }   
    }
    
}
