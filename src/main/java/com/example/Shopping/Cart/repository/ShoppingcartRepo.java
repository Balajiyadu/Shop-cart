package com.example.Shopping.Cart.repository;

import com.example.Shopping.Cart.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingcartRepo extends JpaRepository<ShoppingCart,Integer>
{

}
