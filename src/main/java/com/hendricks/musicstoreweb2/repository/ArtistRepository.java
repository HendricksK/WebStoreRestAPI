/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.repository;

import com.hendricks.musicstoreweb2.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kurvin
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{
    
}
