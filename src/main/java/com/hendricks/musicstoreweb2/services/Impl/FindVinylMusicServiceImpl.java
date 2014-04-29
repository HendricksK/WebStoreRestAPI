/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Vinyl;
import com.hendricks.musicstoreweb2.repository.VinylRepository;
import com.hendricks.musicstoreweb2.services.FindVinylMusicService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service 
public class FindVinylMusicServiceImpl implements FindVinylMusicService{
    @Autowired
    private VinylRepository repo;
    private Long id;

    @Override
    public String searchVinyl(String Artist) {
      Vinyl v = new Vinyl.Builder("Asking Alexandria")
                .build();
      Vinyl v1 = new Vinyl.Builder("Macklemore")
              .build();
      Vinyl v2 = new Vinyl.Builder("Fall Out Boy")
              .build();
      
      List<Vinyl> vinylList = new ArrayList<>();
      
      repo.save(v);
      id = v.getID();
      vinylList.add(repo.findOne(id));
      repo.save(v1);
      id = v1.getID();
      vinylList.add(repo.findOne(id));
      repo.save(v2);
      id = v2.getID();
      vinylList.add(repo.findOne(id));
      
      for(int x = 0; x < vinylList.size(); x++){
          if(vinylList.get(x).getArtist().equals(Artist)){
              return vinylList.get(x).getArtist();
          }
      }
      return null;
    }
    
}
