package com.mirae.service;

import com.mirae.entity.ShippingEntity;
import com.mirae.model.Shipping;
import com.mirae.repository.ShippingRepository;
import com.mirae.util.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    @Autowired
    Common common;

    public Shipping findShippingById(int shippingMethodId) {
        log.info("============ find Shipping by Id : {}", shippingMethodId);
        ShippingEntity shp = shippingRepository.findById(shippingMethodId).get();

        return common.mappingShipping(shp);
    }
}
