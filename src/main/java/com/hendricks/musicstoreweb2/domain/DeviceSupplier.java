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
public class DeviceSupplier implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String supplier;
    private String product;
    private Double price;
    
    private DeviceSupplier(){};
    
    private DeviceSupplier(DeviceSupplier item){
        this.ID = item.ID;
        this.product = item.product;
        this.supplier = item.supplier;
        this.price = item.price;
    }
    
    private DeviceSupplier(Builder item){
        this.ID = item.ID;
        this.product = item.product;
        this.supplier = item.supplier;
        this.price = item.price;
    }
    
    public static class Builder{
        private String supplier;
        private Long ID;
        private String product;
        private Double price;
        
        public Builder(String supplier){
            this.supplier = supplier;
        }

        public Builder setSupplier(String supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder setProduct(String product) {
            this.product = product;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }
        
        public Builder DeviceSupplier(DeviceSupplier item){
            this.product = item.product;
            this.supplier = item.supplier;
            this.price = item.price;
            return this;
        }
        
        public DeviceSupplier build(){
            return new DeviceSupplier(this);
        }
        
    }

    public String getSupplier() {
        return supplier;
    }

    public Long getID() {
        return ID;
    }

    public String getProduct() {
        return product;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.ID);
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
        final DeviceSupplier other = (DeviceSupplier) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
    
}
