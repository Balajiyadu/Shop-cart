package com.example.Shopping.Cart.service;

import com.example.Shopping.Cart.Exception.ItemNotFoundException;
import com.example.Shopping.Cart.model.ShoppingCart;
import com.example.Shopping.Cart.repository.ShoppingcartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class ShoppingcartServiceImpl implements ShoppingcartService
{
    @Autowired
    ShoppingcartRepo shoppingcartRepo;

    @Override
    public ShoppingCart additems(ShoppingCart item)
    {
        return shoppingcartRepo.save(item);
    }


    @Override
    public ShoppingCart getitembyid(Integer id) throws ItemNotFoundException
    {
        return shoppingcartRepo.findById(id).orElseThrow(
                () -> new ItemNotFoundException("No such item ("+id+") found in cart!!!")
        );
    }

    @Override
    public List<ShoppingCart> getallitems()
    {
        return shoppingcartRepo.findAll();
    }

    @Override
    public ShoppingCart updateitems(Integer itemid, ShoppingCart item) throws ItemNotFoundException
    {
        ShoppingCart item1 = shoppingcartRepo.findById(itemid).orElseThrow(
                () -> new ItemNotFoundException("No such item (\"+id+\") found in cart!!!")
        );
        item1.setId(Objects.isNull((item.getId()))?item1.getId():item.getId());
        item1.setItem_Name(Objects.isNull((item.getItem_Name()))?item1.getItem_Name():item.getItem_Name());
        item1.setOrder_No(Objects.isNull((item.getOrder_No()))?item1.getOrder_No():item.getOrder_No());
        item1.setItems_In_stock(Objects.isNull((item.getItems_In_stock()))?item1.getItems_In_stock():item.getItems_In_stock());
        return shoppingcartRepo.save(item1);
    }

    @Override
    public void delete(Integer itemid) throws ItemNotFoundException
    {
       ShoppingCart abc = shoppingcartRepo.findById(itemid).orElseThrow(
                () -> new ItemNotFoundException("No such item (\"+id+\") found in cart!!!")
        );
        shoppingcartRepo.delete(abc);
    }
}
