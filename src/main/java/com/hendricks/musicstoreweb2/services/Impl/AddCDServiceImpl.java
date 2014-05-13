/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.CD;
import com.hendricks.musicstoreweb2.domain.DigitalMusic;
import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.repository.CDRepository;
import com.hendricks.musicstoreweb2.services.AddCDService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class AddCDServiceImpl implements AddCDService{
    @Autowired

    private CDRepository repo;
    private Long id;

    @Override
    public boolean addMusic(List<Song> songs, Double price, String artist) {
        
        CD cd = new CD.Builder(artist)
                .setPrice(price)
                .setSongList(songs)
                .build();
        
        repo.save(cd);
        id = cd.getId();
        
        CD cd1 = repo.findOne(id);
        
        if(cd1.equals(cd)){
            return true;
        }else return false;
    }

    @Override
    public CD find(Long id) {
        return repo.findOne(id);
    }

    @Override
    public CD persists(CD entity) {
       return repo.save(entity);
    }

    @Override
    public CD merge(CD entity) {
       if(entity.getID()!=null){
           return repo.save(entity);
       }
       else return null;
    }

    @Override
    public void remove(CD entity) {
      repo.delete(entity);
    }

    @Override
    public List<CD> findAll() {
        return repo.findAll();
    }
}
