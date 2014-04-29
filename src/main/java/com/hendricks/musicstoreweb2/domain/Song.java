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
public class Song implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int trackNum;
    
    private Song(){};
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Song other = (Song) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Song{" + "id=" + id + '}';
    }
    
    public Song(Builder item){
        this.id = item.id;
        this.title = item.title;
        this.trackNum = item.trackNum;
    }
    
    private Song(Song s){
        this.id = s.id;
        this.title = s.title;
        this.trackNum = s.trackNum;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public Long getId() {
        return id;
    }
    
    public static class Builder{
        private Long id;
        private String title;
        private int trackNum;
        
        public Builder(int trackNum){
            this.trackNum = trackNum;
        }

        public Builder setTrackNum(int trackNum) {
            this.trackNum = trackNum;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public Builder Song(Song s){
            this.id = s.id;
            this.title = s.title;
            this.trackNum = s.trackNum;
            return this;
        }
        
        public Song build(){
            return new Song(this);
        }
        
        
        
    }
    
    
    
    /*private Song(Song item){
        name = item.name;
        id = item.id;
        album = item.album;
        trackNum = item.trackNum;
    }
    
    private Song(Builder item){
        name = item.name;
        id = item.id;
        album = item.album;
        trackNum = item.trackNum;
    }
    
    
    
          public static class Builder{
            
            private String name;
            private int ID;
            private String album;
            private int trackNum;
            
            public Builder(int value){
                ID = value;
            }
            
            public Builder setName(String value){
                this.name = value;
                return this;
            }
            
            public Builder setAlbum(String value){
                this.album = value;
                return this;
            }
            
            public Builder setTrack(int value){
                this.trackNum = value;
                return this;
            }
            
            public Builder Song(Song item){
                this.name = item.name;
                this.album = item.album;
                this.trackNum = item.trackNum;
                return this;
            }
            
            public Song build(){
                return new Song(this);
            }
        }*/



    }
    
