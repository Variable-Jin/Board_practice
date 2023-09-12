package com.agile.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto() {}

    public ProductResponseDto(Long number, String name, int price, int stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}