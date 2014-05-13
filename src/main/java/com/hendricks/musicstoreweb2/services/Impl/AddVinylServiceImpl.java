/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.domain.Vinyl;
import com.hendricks.musicstoreweb2.repository.VinylRepository;
import com.hendricks.musicstoreweb2.services.AddVinylService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class AddVinylServiceImpl implements AddVinylService {
@Autowired
private VinylRepository repo;
private Long id;

    @Override
    public boolean addMusic(List<Song> songs, Double price, String artist) {
        
        
        Vinyl v1 = new Vinyl.Builder(artist)
                .setSongList(songs)
                .build();
        
        repo.save(v1);
        id = v1.getID();
        
        Vinyl v2 = repo.findOne(id);
        
            if(v2.equals(v1))
                return true;
            else return false;
    }

    @Override
    public Vinyl find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public Vinyl persists(Vinyl entity) {
        return repo.save(entity);
    }

    @Override
    public Vinyl merge(Vinyl entity) {
            return repo.save(entity);
            /*if(entity.getID()!=null){return repo.save(entity);}
            else return null
            */
    }
    

    @Override
    public void remove(Vinyl entity) {
       repo.delete(entity);
    }

    @Override
    public List<Vinyl> findAll() {
        return repo.findAll();
    }
    
}
