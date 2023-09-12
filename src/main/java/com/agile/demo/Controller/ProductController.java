package com.agile.demo.Controller;

import com.agile.demo.Service.ProductService;
import com.agile.demo.dto.ChangeProductNameDto;
import com.agile.demo.dto.ProductDto;
import com.agile.demo.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    private ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping("/{number}")
    public ResponseEntity<ProductResponseDto> changeProductName(
            @PathVariable Long number,
            @RequestBody ChangeProductNameDto changeProductnameDto) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(
                changeProductnameDto.getNumber(),
                changeProductnameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
