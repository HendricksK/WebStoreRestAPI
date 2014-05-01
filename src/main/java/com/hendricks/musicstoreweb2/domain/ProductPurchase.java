/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author kurvin
 */
@Entity
public class ProductPurchase {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_purchases")
    List<PurchaseCD> cdPurchases;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "device_purchases")
    List<PurchaseDevice> devicePurchases;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dg_purchases")
    List<PurchaseDigitalMedia> dgPurchases;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "v_purchases")
    List<PurchaseVinyl> vinylPurchases;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_purchases")
    Card cardPurchases;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cash_purchases")
    Cash cashPurchases;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cheque_purchases")
    Cheque chequePurchases;
    
    
    private ProductPurchase(){};
    
    private ProductPurchase(ProductPurchase item){
        this.ID = item.ID;
        this.cardPurchases = item.cardPurchases;
        this.cashPurchases = item.cashPurchases;
        this.cdPurchases = item.cdPurchases;
        this.chequePurchases = item.chequePurchases;
        this.date = item.date;
        this.devicePurchases = item.devicePurchases;
        this.dgPurchases = item.dgPurchases;
        this.vinylPurchases = item.vinylPurchases;
    }
    
    private ProductPurchase(Builder p){
        this.ID = p.ID;
         this.cardPurchases = p.cardPurchases;
        this.cashPurchases = p.cashPurchases;
        this.cdPurchases = p.cdPurchases;
        this.chequePurchases = p.chequePurchases;
        this.date = p.date;
        this.devicePurchases = p.devicePurchases;
        this.dgPurchases = p.dgPurchases;
        this.vinylPurchases = p.vinylPurchases;
    }

    public Long getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public List<PurchaseCD> getCdPurchases() {
        return cdPurchases;
    }

    public List<PurchaseDevice> getDevicePurchases() {
        return devicePurchases;
    }

    public List<PurchaseDigitalMedia> getDgPurchases() {
        return dgPurchases;
    }

    public List<PurchaseVinyl> getVinylPurchases() {
        return vinylPurchases;
    }
    
    public static class Builder{
        private Long ID;
        private Date date;
        private List<PurchaseCD> cdPurchases;
        private List<PurchaseDevice> devicePurchases;
        private List<PurchaseDigitalMedia> dgPurchases;
        private List<PurchaseVinyl> vinylPurchases;
        private Card cardPurchases;
        private Cash cashPurchases;
        private Cheque chequePurchases;
        
        public Builder(Date d){
            this.date = d;
        }

        public Builder setCdPurchases(List<PurchaseCD> cdPurchases) {
            this.cdPurchases = cdPurchases;
            return this;
        }

        public Builder setDevicePurchases(List<PurchaseDevice> devicePurchases) {
            this.devicePurchases = devicePurchases;
            return this;
        }

        public Builder setDvdPurchases(List<PurchaseDigitalMedia> dvdPurchases) {
            this.dgPurchases = dvdPurchases;
            return this;
        }

        public Builder setVinylPurchases(List<PurchaseVinyl> vinylPurchases) {
            this.vinylPurchases = vinylPurchases;
            return this;
        }

        public Builder setCardPurchases(Card cardPurchases) {
            this.cardPurchases = cardPurchases;
            return this;
        }

        public Builder setCashPurchases(Cash cashPurchases) {
            this.cashPurchases = cashPurchases;
            return this;
        }

        public Builder setChequePurchases(Cheque chequePurchases) {
            this.chequePurchases = chequePurchases;
            return this;
        }

        public Builder ProductPurchase(ProductPurchase pp){
            this.ID = pp.ID;
            this.cdPurchases = pp.cdPurchases;
            this.date = pp.date;
            this.devicePurchases = pp.devicePurchases;
            this.dgPurchases = pp.dgPurchases;
            this.vinylPurchases = pp.vinylPurchases;
            this.cardPurchases = pp.cardPurchases;
            this.cashPurchases = pp.cashPurchases;
            this.chequePurchases = pp.chequePurchases;
            return this;
        }
        
        public ProductPurchase build(){
            return new ProductPurchase(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ID);
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
        final ProductPurchase other = (ProductPurchase) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
