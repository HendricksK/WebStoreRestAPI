/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services;

import com.hendricks.musicstoreweb2.domain.ListeningStation;

/**
 *
 * @author kurvin
 */
public interface AddMusicListeningStationService extends Services <ListeningStation, Long>{
    boolean addMusic(String album);
}
