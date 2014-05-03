/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.ProductPurchase;
import com.hendricks.musicstoreweb2.domain.PurchaseDevice;
import com.hendricks.musicstoreweb2.repository.ProductPurchaseRepository;
import com.hendricks.musicstoreweb2.services.NumberOfDeviceSpecialsService;
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
public class NumberOfDeviceSpecialsServiceImpl implements NumberOfDeviceSpecialsService{
    @Autowired
    private ProductPurchaseRepository repo;
    private Long id;
    Date d = new Date();
    int count = 0;

    @Override
    public int numberOfSpecials(Double price) {

        PurchaseDevice pd = new PurchaseDevice.Builder()
               .setName("MP3 Player")
               .setPrice(800.59)
               .build();
       
       PurchaseDevice pd1 = new PurchaseDevice.Builder()
               .setName("CD Player")
               .setPrice(400.59)
               .build();
       
       List<PurchaseDevice> deviceList = new ArrayList();
       deviceList.add(pd);
       deviceList.add(pd1);
       
               
       ProductPurchase pc = new ProductPurchase.Builder(d)
               .setDevicePurchases(deviceList)
               .build();
       
       repo.save(pc);
       id = pc.getID();
       
       ProductPurchase pc2 = repo.findOne(id);

        for (int x = 0; pc2.getDevicePurchases().size() > x; x++) {
            if (pc2.getDevicePurchases().get(x).getPrice() <= price) {
                count++;
            }
        }
        return count;
    }
}
