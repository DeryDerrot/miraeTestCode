package com.mirae.util;

import com.mirae.entity.CustomerEntity;
import com.mirae.entity.EmployeeEntity;
import com.mirae.entity.ProductEntity;
import com.mirae.entity.ShippingEntity;
import com.mirae.model.Customer;
import com.mirae.model.Employee;
import com.mirae.model.Product;
import com.mirae.model.Shipping;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Common {

    public Customer mappingCustomer(CustomerEntity entity) {
        Customer model = new Customer();
        BeanUtils.copyProperties(entity, model);

        return model;
    }

    public Employee mappingEmployee(EmployeeEntity entity) {
        Employee model = new Employee();
        BeanUtils.copyProperties(entity, model);

        return model;
    }

    public Shipping mappingShipping(ShippingEntity entity) {
        Shipping model = new Shipping();
        BeanUtils.copyProperties(entity, model);

        return model;
    }

    public Product mappingProduct(ProductEntity entity) {
        Product model = new Product();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public int sumProductPrice(int qty, int unitPrice, int discount) {
        if (discount != 0) {
            return (qty * unitPrice) - discount;
        }

        return qty * unitPrice;
    }

    public int sumTotalCost(int taxes, int freightCharge, int subtotalOrders) {
        int taxesAmount = 0;

        if (taxes != 0) {
            taxesAmount = (subtotalOrders * taxes) / 100;
        }

        return (subtotalOrders + taxesAmount) + freightCharge;
    }
}
