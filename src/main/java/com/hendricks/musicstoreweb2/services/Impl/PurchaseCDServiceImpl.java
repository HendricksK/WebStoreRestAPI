/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Card;
import com.hendricks.musicstoreweb2.domain.Cash;
import com.hendricks.musicstoreweb2.domain.Cheque;
import com.hendricks.musicstoreweb2.domain.ProductPurchase;
import com.hendricks.musicstoreweb2.domain.PurchaseCD;
import com.hendricks.musicstoreweb2.repository.ProductPurchaseRepository;
import com.hendricks.musicstoreweb2.services.PurchaseCDService;
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
public class PurchaseCDServiceImpl implements PurchaseCDService{
    @Autowired
    
    private ProductPurchaseRepository repo;
    private Long id;
    // if type = 1 cash, if 2 = cheque, if card 3. 
    @Override
    public Double buyDevice(String name, String type) {
       Cash c = null;
       Cheque ch = null;
       Card cr = null;
       
       Date d = new Date();
       
    switch (type) {
        case "c1":
            c = new Cash.Builder(d.toString())
                    .build();
            break;
        case "c2":
            ch = new Cheque.Builder(d.toString())
                    .build();
            break;
        case "c3":
            cr = new Card.Builder(d.toString())
                    .build();
            break;
    }
       
       
       PurchaseCD cd1 = new PurchaseCD.Builder(10.00)
               .setName("blank")
               .build();
       
       PurchaseCD cd2 = new PurchaseCD.Builder(189.00)
               .setName("Black Sabbath greatest hits")
               .build();
       
       List<PurchaseCD> cdList = new ArrayList();
       cdList.add(cd1);
       cdList.add(cd2);
       
               
       ProductPurchase pc = new ProductPurchase.Builder(d)
               .setCdPurchases(cdList)
               .setCardPurchases(cr)
               .setCashPurchases(c)
               .setChequePurchases(ch)
               .build();
       
       repo.save(pc);
       id = pc.getID();
       
       ProductPurchase pc2 = repo.findOne(id);
            for(int x = 0; pc2.getCdPurchases().size() > x; x++){
                if(pc2.getCdPurchases().get(x).getName().equals(name)){
                    return pc2.getCdPurchases().get(x).getPrice();
                }
            }
       return null;    
    }
}
