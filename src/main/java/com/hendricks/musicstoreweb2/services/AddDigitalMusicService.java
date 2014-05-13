/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services;

import com.hendricks.musicstoreweb2.domain.DigitalMusic;
import com.hendricks.musicstoreweb2.domain.Song;
import java.util.List;

/**
 *
 * @author kurvin
 */
public interface AddDigitalMusicService extends Services<DigitalMusic, Long>{
    boolean addMusic(List<Song> songs, Double price, String artist);
}
