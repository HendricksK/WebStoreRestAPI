/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.ListeningStation;
import com.hendricks.musicstoreweb2.repository.ListeningStationRepository;
import com.hendricks.musicstoreweb2.services.AddMusicListeningStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class AddMusicListeningStationServiceImpl implements AddMusicListeningStationService{
@Autowired

    private ListeningStationRepository repo;
    private Long id;
    
    @Override
    public boolean addMusic(String album) {
        
        ListeningStation ls = new ListeningStation.Builder(album)
                .build();
        
        repo.save(ls);
        id = ls.getID();
        
        ListeningStation ls1 = repo.findOne(id);
          
        if(ls1.equals(ls))
            return true;
        else
            return false;
    }
    
}
