package com.kramomar.shoppingBootCoin.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopping {
    
    private String id;

    private double amount;
    private String paymode;
    private String numberPhone; 
    private String document; 
    private String email; 
    
}