package dev.tobycook.demo.controller;

import dev.tobycook.demo.models.production.Product;
import dev.tobycook.demo.service.ProductionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductionController {

    private final ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping(path = "/products")
    public List<Product> getAllProducts() {
        return productionService.getProducts();
    }
}
