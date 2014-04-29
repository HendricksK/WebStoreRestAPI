/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendricks.musicstoreweb2.domain;

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
public class PurchaseDevice {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Double price;

    private PurchaseDevice() {
    }

    ;
    
    private PurchaseDevice(PurchaseDevice item) {
        this.ID = item.ID;
        this.price = item.price;
    }

    private PurchaseDevice(Builder item) {
        this.ID = item.ID;
        this.price = item.price;
    }

    public static class Builder {

        private Long ID;
        private Double price;


        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder PurchaseDevice(PurchaseDevice item) {
            this.ID = item.ID;
            this.price = item.price;
            return this;
        }

        public PurchaseDevice build() {
            return new PurchaseDevice(this);
        }

    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final PurchaseDevice other = (PurchaseDevice) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

}
