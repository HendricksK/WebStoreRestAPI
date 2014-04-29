/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kurvin
 */
@Entity
public class Cheque implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String info;
    
    private Cheque(){};
    
    private Cheque(Cheque item){
        this.info = item.info;
        this.ID = item.ID;
    }
    
    private Cheque(Builder item){
        this.ID = item.ID;
        this.info = item.info;
    }
    
    public static class Builder{
        private String info;
        private Long ID;
        
        public Builder(String item){
            this.info = item;
        }
        
        public Builder Cheque(Cheque item){
            this.ID = item.ID;
            return this;
        }
        
        public Cheque build(){
            return new Cheque(this);
        }  
    }

    public String getTransaction() {
        return info;
    }

    public Long getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cheque other = (Cheque) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
