/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author kurvin
 */
@Entity
public class Manager implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Buyers")
    private List<ProductBuyer> buyerList = new ArrayList();
    
    private Manager(){};
    
    private Manager(Manager item){
        this.name = item.name;
        this.ID = item.ID;
    }
    
    private Manager(Builder item){
        this.name = item.name;
        this.ID = item.ID;
    }
    
    public static class Builder{
        private String name;
        private Long ID;
        private List<ProductBuyer> buyerList = new ArrayList();
        
        public Builder(String name){
        this.name = name;
        }

        public Builder setBuyerList(List<ProductBuyer> buyerList) {
            this.buyerList = buyerList;
            return this;
        }
        
        public Builder Manager(Manager item){
            this.name = item.name;
            return this;
        }
        
        public Manager build(){
            return new Manager(this);
        }
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return ID;
    }

    public List<ProductBuyer> getBuyerList() {
        return buyerList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.ID);
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
        final Manager other = (Manager) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
