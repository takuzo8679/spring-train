package com.example.shopping.controller;

import com.example.shopping.entity.Product;
import com.example.shopping.service.ProductMaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductMaintenanceService productMaintenanceService;
    public ProductController(ProductMaintenanceService productMaintenanceService) {
        this.productMaintenanceService = productMaintenanceService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productMaintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProducts(@PathVariable String id) {
        return productMaintenanceService.findById(id);
    }

//    @GetMapping("/products")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<Product>> getProducts() {
//        return ResponseEntity.ok()
//                .body(productMaintenanceService.findAll());
//    }
}
