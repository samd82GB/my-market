package ru.samd82.mymarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.samd82.mymarket.dto.Product;
import ru.samd82.mymarket.repo.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository repository;

    public Product getProduct(Long id){
        return repository.findById(id);
    }

    public List<Product> getAllProducts(){
        return repository.getProducts();
    }

    public void changeCost(Long id, Integer cost){
        Product product = repository.findById(id);
        product.setCost(product.getCost() + cost);
        // repostitory.save(client);
    }
}
