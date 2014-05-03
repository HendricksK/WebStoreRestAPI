/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.ProductPurchase;
import com.hendricks.musicstoreweb2.domain.PurchaseVinyl;
import com.hendricks.musicstoreweb2.repository.ProductPurchaseRepository;
import com.hendricks.musicstoreweb2.services.NumberOfVinylSpecialsService;
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
public class NumberOfVinylSpecialsServiceImpl implements NumberOfVinylSpecialsService {
@Autowired
    private ProductPurchaseRepository repo;
    private Long id;
    Date d = new Date();
    int count = 0;

    @Override
    public int numberOfSpecials(Double price) {

        PurchaseVinyl v = new PurchaseVinyl.Builder()
                .setName("Let The Good Times Role")
                .setPrice(3.99)
                .build();

        PurchaseVinyl v1 = new PurchaseVinyl.Builder()
                .setName("Thanks For The Meomories")
                .setPrice(10.23)
                .build();
        
         PurchaseVinyl v2 = new PurchaseVinyl.Builder()
                .setName("Illuminadio")
                .setPrice(6.39)
                .build();

        List<PurchaseVinyl> vinylList = new ArrayList();
        vinylList.add(v);
        vinylList.add(v1);
        vinylList.add(v2);

        ProductPurchase pc = new ProductPurchase.Builder(d)
                .setVinylPurchases(vinylList)
                .build();

        repo.save(pc);
        id = pc.getID();

        ProductPurchase pc2 = repo.findOne(id);

        for (int x = 0; pc2.getVinylPurchases().size() > x; x++) {
            if (pc2.getVinylPurchases().get(x).getPrice() <= price) {
                count++;
            }
        }
        return count;
    }
}
