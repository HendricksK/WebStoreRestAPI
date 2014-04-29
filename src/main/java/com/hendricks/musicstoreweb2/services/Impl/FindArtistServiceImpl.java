/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Artist;
import com.hendricks.musicstoreweb2.repository.ArtistRepository;
import com.hendricks.musicstoreweb2.services.FindArtistService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class FindArtistServiceImpl implements FindArtistService{
@Autowired
private ArtistRepository repo;
private Long id;

    @Override
    public String findArtist(String alias) {
       Artist a = new Artist.Builder("Dance Gavin Dance")
                .setName("Will Swan, Tilian")
                .build();
       
       Artist a1 = new Artist.Builder("The Amity Affliction")
                .setName("John, Matt, Jake")
                .build();
       
       Artist a2 = new Artist.Builder("Foto Na Dans")
               .setName("Gerard, Divan, Andre")
               .build();
       
       List<Artist> artistList = new ArrayList<>();
       
       repo.save(a);
       id = a.getId();
       artistList.add(repo.findOne(id));
       repo.save(a1);
       id = a1.getId();
       artistList.add(repo.findOne(id));
       repo.save(a2);
       id = a2.getId();
       artistList.add(repo.findOne(id));
       
       for(int x = 0; x < artistList.size(); x++){
           if(artistList.get(x).getAlias().equals(alias))
               return artistList.get(x).getAlias();
       }
       return null;
    }
    
}
