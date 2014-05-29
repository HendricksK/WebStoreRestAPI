/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.presentation.rest;

import com.hendricks.musicstoreweb2.domain.Manager;
import com.hendricks.musicstoreweb2.services.AddManagerService;
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
@RequestMapping(value = "api/manager")
public class ManagerController {
    @Autowired
    private AddManagerService c;
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Manager dg){
        c.persists(dg);
        return "index";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Manager dg){
        c.merge(dg);
        return "index";
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Manager getCD(@PathVariable Long id){
        return c.find(id);
    }
    
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<Manager> getCDS(){
        return c.findAll();
    }
    
    @RequestMapping(value = "remove/id/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String remove(@RequestBody Manager dg){
        c.remove(dg);
        return "index";
}
}
