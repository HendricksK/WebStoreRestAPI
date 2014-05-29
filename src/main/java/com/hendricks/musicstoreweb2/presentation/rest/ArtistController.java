/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.presentation.rest;

import com.hendricks.musicstoreweb2.domain.Artist;
import com.hendricks.musicstoreweb2.services.AddArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kurvin Hendricks
 */
@Controller
@RequestMapping(value = "api/artist")
public class ArtistController {
    @Autowired 
    private AddArtistService a;
    private Long id;
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Artist artist){
        //Artist art = new Artist.Builder("Celine Dion").build();
        //a.persists(art);
        a.persists(artist);
        id = artist.getId();
        return "index";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Artist artist){
        Artist old = a.find(id);
        Artist art = new Artist.Builder(old.getAlias()).build();
        a.merge(artist);
        return "index";
        
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Artist getArtist(@PathVariable Long id){
        return a.find(id);
    }
    
    @RequestMapping(value = "artists", method = RequestMethod.GET)
    @ResponseBody
    public List<Artist> getAllArtist(){
        return a.findAll();
    }
    
    @RequestMapping(value = "remove/id/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String remove(@RequestBody Artist artist){
        a.remove(null);
        return "index";
    }
}
