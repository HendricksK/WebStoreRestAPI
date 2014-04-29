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
public class Artist implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String alias;
    private String names;
    private Genre genre;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="artist_id")
    List<Album> albums;

    private Artist() {
    }

    ;
    
    private Artist(Builder item) {
        names = item.names;
        alias = item.alias;
    }

    private Artist(Artist item) {
        this.names = item.names;
        this.alias = item.alias;
    }

    public String getAlias() {
        return alias;
    }

    public String getNames() {
        return names;
    }

    public Long getId() {
        return id;
    }

    public List<Album> getAlbums() {
        return albums;
    }
    
    public static class Builder {
        private Long id;
        private String alias;
        private String names;
        private Genre genre;
        List<Album> albums;

        public Builder(String name){
            this.alias = name;
        }
        
        public Builder setGenre(Genre g){
            genre = g;
            return this;
        }

        public Builder setName(String value) {
            this.names = value;
            return this;
        }
        
        public Builder setAlbums(List<Album> albums){
            this.albums = albums;
            return this;
        }

        public Builder Artist(Artist item) {
            this.names = item.names;
            this.alias = item.alias;
            this.albums = item.albums;
            this.id = item.id;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Artist other = (Artist) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artist{" + "id=" + id + '}';
    }
    
    

}
