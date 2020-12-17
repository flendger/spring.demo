package ru.flendger.spring.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.spring.demo.models.Product;
import ru.flendger.spring.demo.repositories.ProductMemoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMemoryRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product find(Long id) {
        return productRepository.find(id);
    }

    public Product add(Product product) {
        return productRepository.add(product);
    }

    public Product remove(Product product) {
        return productRepository.remove(product);
    }

    public Product remove(Long id) {
        return productRepository.remove(id);
    }
}
