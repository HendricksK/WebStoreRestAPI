/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.CD;
import com.hendricks.musicstoreweb2.repository.CDRepository;
import com.hendricks.musicstoreweb2.services.FindCDMusicService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class FindCDMusicServiceImpl implements FindCDMusicService{
@Autowired
private CDRepository repo;
private Long id;

    @Override
    public String searchCD(String Artist) {
        CD c = new CD.Builder("Asking Alexandria")
                .build();
      CD c1 = new CD.Builder("Foo Fighters")
              .build();
      CD c2 = new CD.Builder("Dance Gavin Dance")
              .build();
      
      List<CD> CDList = new ArrayList<>();
      
      repo.save(c);
      id = c.getID();
      CDList.add(repo.findOne(id));
      repo.save(c1);
      id = c1.getID();
      CDList.add(repo.findOne(id));
      repo.save(c2);
      id = c2.getID();
      CDList.add(repo.findOne(id));
      
      for(int x = 0; x < CDList.size(); x++){
          if(CDList.get(x).getArtist().equals(Artist)){
              return CDList.get(x).getArtist();
          }
      }
      return null;
    }
}
    