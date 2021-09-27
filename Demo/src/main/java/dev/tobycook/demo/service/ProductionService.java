package dev.tobycook.demo.service;

import dev.tobycook.demo.models.production.Product;
import dev.tobycook.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService {

    private final ProductRepository productRepository;

    public ProductionService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
