/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.ProductPurchase;
import com.hendricks.musicstoreweb2.domain.PurchaseCD;
import com.hendricks.musicstoreweb2.repository.ProductPurchaseRepository;
import com.hendricks.musicstoreweb2.services.NumberOfCDSpecials;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class NumberOfCDSpecialsImpl implements NumberOfCDSpecials{
@Autowired
    
    private ProductPurchaseRepository repo;
    private Long id;
    Date d = new Date();
    int count = 0;
    
    @Override
    public int numberOfSpecials(Double price) {
        PurchaseCD cd1 = new PurchaseCD.Builder(90.00)
               .setName("Chiodos: Bone Palace Ballet")
               .build();
       
       PurchaseCD cd2 = new PurchaseCD.Builder(90.00)
               .setName("Black Sabbath greatest hits")
               .build();
       
       PurchaseCD cd3 = new PurchaseCD.Builder(120.00)
               .setName("Alice Cooper greatest hits")
               .build();
       
       List<PurchaseCD> cdList = new ArrayList();
       cdList.add(cd1);
       cdList.add(cd2);
       cdList.add(cd3);
       
               
       ProductPurchase pc = new ProductPurchase.Builder(d)
               .setCdPurchases(cdList)
               .build();
       
       repo.save(pc);
       id = pc.getID();
       
       ProductPurchase pc2 = repo.findOne(id);
       
            for(int x = 0; pc2.getCdPurchases().size() > x; x++){
                if(pc2.getCdPurchases().get(x).getPrice() <= price){
                    count++;
                }
            }
          return count;  
    }
    
}
