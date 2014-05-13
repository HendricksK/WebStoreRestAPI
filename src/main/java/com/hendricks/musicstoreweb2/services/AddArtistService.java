/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services;

import com.hendricks.musicstoreweb2.domain.Artist;

/**
 *
 * @author kurvin
 */
public interface AddArtistService extends Services<Artist, Long>{
    boolean addMusic(String Band, String albumName, String genre, String artistNames);
}
