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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author kurvin
 */
@Entity
public class CD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String artist;
    private Double price;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd")
    List<Song> songList;

    private CD() {
    };
    
    private CD(CD item) {
        this.artist = item.artist;
        this.id = item.id;
        this.songList = item.songList;
        this.price = item.price;
    }

    private CD(Builder item) {
        this.artist = item.artist;
        this.id = item.id;
        this.songList = item.songList;
        this.price = item.price;
    }

    public static class Builder {

        private Long id;
        private String artist;
        private Double price;
        List<Song> songList;

        public Builder(String artist) {
            this.artist = artist;
        }

        public Builder setArtist(String artist) {
            this.artist = artist;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder setSongList(List<Song> songList) {
            this.songList = songList;
            return this;
        }

        public Builder CD(CD item) {
            this.artist = item.artist;
            this.songList = item.songList;
            this.id = item.id;
            return this;
        }

        public CD build() {
            return new CD(this);
        }
    }

    public String getArtist() {
        return artist;
    }

    public Long getID() {
        return id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final CD other = (CD) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CD{" + "id=" + id + '}';
    }

}
