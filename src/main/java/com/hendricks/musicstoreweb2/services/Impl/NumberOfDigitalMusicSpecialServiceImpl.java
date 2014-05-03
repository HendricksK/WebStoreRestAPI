/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.ProductPurchase;
import com.hendricks.musicstoreweb2.domain.PurchaseDigitalMedia;
import com.hendricks.musicstoreweb2.domain.PurchaseVinyl;
import com.hendricks.musicstoreweb2.repository.ProductPurchaseRepository;
import com.hendricks.musicstoreweb2.services.NumberOfDigitalMusicSpecialService;
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
public class NumberOfDigitalMusicSpecialServiceImpl implements NumberOfDigitalMusicSpecialService{
@Autowired

     private ProductPurchaseRepository repo;
    private Long id;
    Date d = new Date();
    int count = 0;

    @Override
    public int numberOfSpecials(Double price) {

        PurchaseDigitalMedia m = new PurchaseDigitalMedia.Builder()
               .setName("Let The Good Times Role")
               .setPrice(3.99)
               .build();
       
       PurchaseDigitalMedia m1 = new PurchaseDigitalMedia.Builder()
               .setName("Thanks For The Meomories")
               .setPrice(1.99)
               .build();
       
       List<PurchaseDigitalMedia> dgmList = new ArrayList();
       dgmList.add(m);
       dgmList.add(m1);
       
               
       ProductPurchase pc = new ProductPurchase.Builder(d)
               .setDvdPurchases(dgmList)
               .build();
       
       repo.save(pc);
       id = pc.getID();
       
       ProductPurchase pc2 = repo.findOne(id);

        for (int x = 0; pc2.getDgPurchases().size() > x; x++) {
            if (pc2.getDgPurchases().get(x).getPrice() <= price) {
                count++;
            }
        }
        return count;
    }
}
