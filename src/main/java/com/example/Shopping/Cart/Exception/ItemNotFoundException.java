package com.example.Shopping.Cart.Exception;

public class ItemNotFoundException extends RuntimeException
{
    public ItemNotFoundException(String message)
    {
        super(message);
    }
}
