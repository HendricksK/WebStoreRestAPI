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
import javax.persistence.OneToOne;

/**
 *
 * @author kurvin
 */
@Entity
public class Vinyl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String artist;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vinyl")
    List<Song> songList;

    private Vinyl() {
    };
    
    public Vinyl(Vinyl item) {
        this.artist = item.artist;
        this.id = item.id;
        this.songList = item.songList;
    }

    public Vinyl(Builder item) {
        this.artist = item.artist;
        this.id = item.id;
        this.songList = item.songList;
    }

    public static class Builder {

        private Long id;
        private String artist;
        List<Song> songList;

        public Builder(String artist) {
            this.artist = artist;
        }

        public Builder setSongList(List<Song> songList) {
            this.songList = songList;
            return this;
        }

        public Builder Vinyl(Vinyl item) {
            this.artist = item.artist;
            this.songList = item.songList;
            this.id = item.id;
            return this;
        }

        public Vinyl build() {
            return new Vinyl(this);
        }
    }

    public String getArtist() {
        return artist;
    }

    public long getID() {
        return id;
    }

    public List<Song> getSongList() {
        return songList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Vinyl other = (Vinyl) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vinyl{" + "id=" + id + '}';
    }

}
