package ru.samd82.mymarket.repo;

import org.springframework.stereotype.Repository;
import ru.samd82.mymarket.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Smartphone", 15000),
                new Product(2L, "Fax", 25000),
                new Product(3L, "PC", 35000)
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Продукт не найден"));
    }

    public List<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
