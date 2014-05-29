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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kurvin
 */
@Entity
public class ListeningStation implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String album;


    private ListeningStation() {
    };
    
    private ListeningStation(ListeningStation item) {
        this.album = item.album;
        this.ID = item.ID;
    }

    private ListeningStation(Builder item) {
        this.album = item.album;
        this.ID = item.ID;
    }

    public static class Builder {

        private String album;
        private Long ID;


        public Builder(String album) {
            this.album = album;
        }

        public Builder ListeningStation(ListeningStation item) {
            this.album = item.album;
            this.ID = item.ID;
            return this;
        }

        public ListeningStation build() {
            return new ListeningStation(this);
        }
    }

    public String getAlbum() {
        return album;
    }

    public Long getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.ID);
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
        final ListeningStation other = (ListeningStation) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

}
