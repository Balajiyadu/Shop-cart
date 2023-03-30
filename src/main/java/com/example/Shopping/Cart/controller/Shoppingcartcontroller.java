package com.example.Shopping.Cart.controller;

import com.example.Shopping.Cart.model.ShoppingCart;
import com.example.Shopping.Cart.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Shoppingcartcontroller
{
    @Autowired
    ShoppingcartService shoppingcartService;

    @PostMapping("/item")
    public ResponseEntity<Object> createitems(@RequestBody ShoppingCart item)
    {
       return new ResponseEntity<>(shoppingcartService.additems(item), HttpStatus.CREATED);
    }
    @GetMapping("/item/id")
    public ResponseEntity<Object> getitem(@PathVariable("id") Integer itemid)
    {
        return ResponseEntity.ok().body(shoppingcartService.getitembyid(itemid));
    }
    @GetMapping("/item")
    public List<ShoppingCart> getitems()
    {
        return shoppingcartService.getallitems();
    }
    @PutMapping("/item/id")
    public ResponseEntity<Object> updateitem(@PathVariable("id") Integer itemid ,@RequestBody ShoppingCart item)
    {
        return ResponseEntity.ok((shoppingcartService.updateitems(itemid,item)));
    }
    @DeleteMapping("/item/id")
    public ResponseEntity<Object> deleteitem(@PathVariable("id")int itemid)
    {
        shoppingcartService.delete(itemid);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }


}








