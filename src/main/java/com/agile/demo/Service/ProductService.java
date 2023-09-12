package com.agile.demo.Service;

import com.agile.demo.dto.ProductDto;
import com.agile.demo.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

//    ProductResponseDto changeProduct(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
