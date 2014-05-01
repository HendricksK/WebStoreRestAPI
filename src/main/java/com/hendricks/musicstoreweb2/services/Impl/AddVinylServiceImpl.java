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
import java.util.ArrayList;
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
    public boolean addMusic(String album) {
       List<Song> songs = new ArrayList<>();
        
        Song s = new Song.Builder(6)
                .setTitle("Don't Pray For me")
                .build();
        
        songs.add(s);
        
        Vinyl v1 = new Vinyl.Builder(album)
                .setSongList(songs)
                .build();
        
        repo.save(v1);
        id = v1.getID();
        
        Vinyl v2 = repo.findOne(id);
        
            if(v2.equals(v1))
                return true;
            else return false;
    }
    
}
