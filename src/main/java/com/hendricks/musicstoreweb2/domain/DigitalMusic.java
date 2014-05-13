/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class DigitalMusic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String artist;
    private Double price;
    private 
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // this is to ensure the database initializes the lists
    @JoinColumn(name = "digital")
    List<Song> songList;
    
    private DigitalMusic(){};
    
    public DigitalMusic(Builder dm){
        this.artist = dm.artist;
        this.id = dm.id;
        this.songList = dm.songList;
        this.price = dm.price;
    }
    
    public DigitalMusic(DigitalMusic dm){
        this.artist = dm.artist;
        this.id = dm.id;
        this.songList = dm.songList;
        this.price = dm.price;
    }

    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public Double getPrice() {
        return price;
    }
    
    public static class Builder{
        private Long id;
        private String artist;
        List<Song> songList;
        private Double price;
        
        public Builder(String artist){
            this.artist = artist;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setSongList(List<Song> songList) {
            this.songList = songList;
            return this;
        }
        
        public Builder setPrice(Double Price){
            this.price = Price;
            return this;
        }
        
        public Builder DigitalMusic(DigitalMusic dm){
            this.artist = dm.getArtist();
            this.id = dm.getId();
            this.songList = dm.getSongList();
            return this;
        }
        
        public DigitalMusic build(){
            return new DigitalMusic(this);
        }
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DigitalMusic)) {
            return false;
        }
        DigitalMusic other = (DigitalMusic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hendricks.musicstoreweb.domain.DigitalMusic[ id=" + id + " ]";
    }
    
}
