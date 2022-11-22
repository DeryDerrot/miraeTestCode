package com.mirae.service;

import com.mirae.entity.ProductEntity;
import com.mirae.model.Product;
import com.mirae.repository.ProductRepository;
import com.mirae.util.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Common common;

    public Product findProductById (int productId) {
        log.info("============ find Product by Id : {}", productId);

        ProductEntity prd = productRepository.findById(productId).get();

        return common.mappingProduct(prd);
    }

}
