/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.presentation.rest;

import com.hendricks.musicstoreweb2.domain.ProductBuyer;
import com.hendricks.musicstoreweb2.services.AddProductBuyerService;
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
@RequestMapping(value = "api/product")
public class ProductBuyerController {
    @Autowired 
    private AddProductBuyerService a;
    private Long id;
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody ProductBuyer product){
        a.persists(product);
        return "index";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody ProductBuyer product){
        a.merge(product);
        return "index";
        
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProductBuyer getArtist(@PathVariable Long id){
        return a.find(id);
    }
    
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductBuyer> getAllArtist(){
        return a.findAll();
    }
}
