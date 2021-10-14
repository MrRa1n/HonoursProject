package dev.tobycook.demo.service.products;

import dev.tobycook.demo.models.production.Product;
import dev.tobycook.demo.repository.products.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
}
