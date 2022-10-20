package ru.samd82.mymarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.samd82.mymarket.dto.Product;
import ru.samd82.mymarket.repo.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product getProduct(Long id){
        return repository.findById(id);
    }

    public List<Product> getAllProducts(){
        return repository.getProducts();
    }
}
