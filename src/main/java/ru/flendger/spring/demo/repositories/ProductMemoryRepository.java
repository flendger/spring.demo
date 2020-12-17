package ru.flendger.spring.demo.repositories;

import org.springframework.stereotype.Component;
import ru.flendger.spring.demo.models.Product;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
public class ProductMemoryRepository {

    private SortedMap<Long, Product> products;

    @PostConstruct
    private void init() {
        products = Collections.synchronizedSortedMap(new TreeMap<>());
        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.setId(getNewId());
            p.setTitle("Товар " + i);
            p.setPrice((float) (Math.random()*10));
            add(p);
        }
    }

    public List<Product> findAll() {
        return List.copyOf(products.values());
    }

    public Product find(Long id) {
        return products.get(id);
    }

    public Product add(Product product) {
        if (product == null) return null;

        if (product.getId() == null) {
            product.setId(getNewId());
        }
        products.put(product.getId(), product);
        return product;
    }

    public Product remove(Long id) {
        if (! products.containsKey(id)) return null;
        Product p = products.get(id);
        products.remove(id);
        return p;
    }

    public Product remove(Product product) {
        if (product == null) return null;
        return remove(product.getId());
    }

    private Long getNewId() {
        return products.keySet().stream().mapToLong(key -> key).max().orElse(0L) + 1L;
    }
}
