/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.DigitalMusic;
import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.repository.DigitalMusicRepository;
import com.hendricks.musicstoreweb2.services.FindDigitalMusicService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class FindDigitalMusicServiceImpl implements FindDigitalMusicService{
@Autowired
private DigitalMusicRepository repo;
private Long id;


    @Override
    public String searchDigitalMusic(String song) {
        List<Song> songs = new ArrayList<>();
        
        Song s  = new Song.Builder(1)
                .setTitle("New Moon Rising")
                .build();
        
        Song s1 = new Song.Builder(2)
                .setTitle("R.I.P Bon")
                .build();
        
        Song s2= new Song.Builder(3)
                .setTitle("Greens Avenue")
                .build();
        
        songs.add(s);
        songs.add(s1);
        songs.add(s2);
        
        DigitalMusic dm = new DigitalMusic.Builder("Wolfmother")
                .setSongList(songs)
                .build();
        
        repo.save(dm);
        id = dm.getId();
        DigitalMusic dm2 = repo.findOne(id);
        List<Song> search = dm2.getSongList();
        

        for(int x = 0; x <= search.size(); x++){
            if(search.get(x).getTitle().equals(song))
                return search.get(x).getTitle();
        }
        return null;
    }
}
