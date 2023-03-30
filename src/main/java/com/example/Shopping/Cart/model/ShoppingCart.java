package com.example.Shopping.Cart.model;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;


@Entity

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "Shopping_Cart")

public class ShoppingCart
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String Item_Name;
    public Integer Order_No;
    public Integer Items_In_stock;

}
