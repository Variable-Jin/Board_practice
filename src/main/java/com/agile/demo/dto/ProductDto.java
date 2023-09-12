package com.agile.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.PreUpdate;

@Getter
@Setter
@Builder
public class ProductDto {

    private String name;
    private int price;
    private int stock;

    public ProductDto(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

}
