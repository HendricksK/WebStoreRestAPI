/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services;

import com.hendricks.musicstoreweb2.domain.DeviceSupplier;
import com.hendricks.musicstoreweb2.domain.MediaSupplier;
import com.hendricks.musicstoreweb2.domain.ProductBuyer;
import java.util.List;

/**
 *
 * @author kurvin
 */
public interface AddProductBuyerService extends Services<ProductBuyer, Long>{
    boolean addManager(String name, List<DeviceSupplier> dList, List<MediaSupplier> mList);
}
