/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.presentation.rest;

import com.hendricks.musicstoreweb2.domain.ListeningStation;
import com.hendricks.musicstoreweb2.services.AddMusicListeningStationService;
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
@RequestMapping(value = "api/listening")
public class MusicStationController {
    @Autowired
    private AddMusicListeningStationService c;
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody ListeningStation dg){
        c.persists(dg);
        return "index";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody ListeningStation dg){
        c.merge(dg);
        return "index";
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ListeningStation getCD(@PathVariable Long id){
        return c.find(id);
    }
    
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<ListeningStation> getCDS(){
        return c.findAll();
    }
    
    @RequestMapping(value = "remove/id/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String remove(@RequestBody ListeningStation dg){
        c.remove(dg);
        return "index";
}
}
