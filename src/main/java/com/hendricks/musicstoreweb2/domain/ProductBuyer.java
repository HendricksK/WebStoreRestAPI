/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.domain;

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
public class ProductBuyer {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String Name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "media_suppplier")
    private List<MediaSupplier> mediaSuppList = new ArrayList();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "device_suppplier")
    private List<DeviceSupplier> deviceSuppList = new ArrayList();
    
    private ProductBuyer(){};
    
    private ProductBuyer(ProductBuyer item){
        this.Name = item.Name;
        this.ID = item.ID;
    }
    
    private ProductBuyer(Builder item){
        this.Name = item.Name;
        this.ID = item.ID;
    }
    
    public static class Builder{
        private String Name;
        private Long ID;
        private List<MediaSupplier> mediaSuppList = new ArrayList();
        private List<DeviceSupplier> deviceSuppList = new ArrayList();
       
        
        public Builder(String value){
            this.Name = value;
        }
        
        public Builder ProductBuyer(ProductBuyer item){
            this.Name = item.Name;
            return this;
        }

        public Builder setMediaSuppList(List<MediaSupplier> mediaSuppList) {
            this.mediaSuppList = mediaSuppList;
            return this;
        }

        public Builder setDeviceSuppList(List<DeviceSupplier> deviceSuppList) {
            this.deviceSuppList = deviceSuppList;
            return this;
        }
        
        public Builder ProductBuyer(Builder pb){
            this.ID = pb.ID;
            this.Name = pb.Name;
            this.deviceSuppList = pb.deviceSuppList;
            this.mediaSuppList = pb.mediaSuppList;
            return this;
        }
        
        public ProductBuyer build(){
            return new ProductBuyer(this);
        }
    }

    public String getName() {
        return Name;
    }

    public Long getID() {
        return ID;
    }

    public List<MediaSupplier> getMediaSuppList() {
        return mediaSuppList;
    }

    public List<DeviceSupplier> getDeviceSuppList() {
        return deviceSuppList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ID);
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
        final ProductBuyer other = (ProductBuyer) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
