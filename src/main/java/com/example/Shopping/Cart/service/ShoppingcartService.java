package com.example.Shopping.Cart.service;

import com.example.Shopping.Cart.Exception.ItemNotFoundException;
import com.example.Shopping.Cart.model.ShoppingCart;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ShoppingcartService {
    ShoppingCart additems(ShoppingCart item);

    ShoppingCart getitembyid(Integer id) throws ItemNotFoundException;
    List<ShoppingCart> getallitems();
    ShoppingCart updateitems(Integer itemid, ShoppingCart item) throws  ItemNotFoundException;
    void delete (Integer itemid) throws  ItemNotFoundException;
}