/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gelz
 */
@Entity
@Table(name="t_person")
public class Person {
    @Id
    @GeneratedValue
    @Column(name="idPerson",unique=true,nullable=false)
    private long id;
    @Column(nullable=false)
    private String email;
    private String nama;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
              
}
