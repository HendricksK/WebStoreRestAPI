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
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kurvin
 */
@Embeddable
public class Genre implements Serializable{
    private String name;
    
    private Genre(){};
    
    private Genre(Builder item){
        name = item.name;
    }
    
    private Genre(Genre item){
        this.name = item.name;
    }
    
        public static class Builder{
            private String name;
            
            public Builder(String name){
                name = name;
            }
                
            public Builder Genre(Genre item){
                name = item.name;
                return this;
            }
            
            public Builder Genre(Builder g){
                this.name = g.name;
                return this;
            }

            public Genre build(){
                return new Genre(this);
            }

        }

    public String getName() {
        return name;
    }
    
}
