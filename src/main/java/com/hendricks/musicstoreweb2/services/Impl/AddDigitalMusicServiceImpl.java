/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.DigitalMusic;
import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.repository.DigitalMusicRepository;
import com.hendricks.musicstoreweb2.services.AddDigitalMusicService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class AddDigitalMusicServiceImpl implements AddDigitalMusicService{
@Autowired

    private DigitalMusicRepository repo;
    private Long id;

    @Override
    public boolean addMusic(List<Song> songs, Double price, String artist) {
        
        DigitalMusic dm = new DigitalMusic.Builder(artist)
                .setSongList(songs)
                .setPrice(price)
                .build();
        
        repo.save(dm);
        id = dm.getId();
        
         DigitalMusic dm1 = repo.findOne(id);
         
         if(dm1.equals(dm))
            return true;
        else
            return false;
    }

    @Override
    public DigitalMusic find(Long id) {
        return repo.findOne(id);
    }

    @Override
    public DigitalMusic persists(DigitalMusic entity) {
        return repo.save(entity);
    }

    @Override
    public DigitalMusic merge(DigitalMusic entity) {
        if(entity.getId()!=null){
            return repo.save(entity);
        }else return null;
    }

    @Override
    public void remove(DigitalMusic entity) {
       repo.delete(entity);
    }

    @Override
    public List<DigitalMusic> findAll() {
        return repo.findAll();
    }
    
}
