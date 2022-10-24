package ru.samd82.mymarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.samd82.mymarket.dto.Product;
import ru.samd82.mymarket.repo.ProductRepository;
import ru.samd82.mymarket.services.ProductService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MainController {


    private final ProductService service;
    private final ProductRepository repository;
    // http://localhost:8189/app

    // http://localhost:8189/app/hello
   @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "<h1>Hello autumn market!</h1>";
    }

   /*  //http://localhost:8189/app/buy
    @GetMapping("/buy")
    @ResponseBody
    public String buy(){
        return "buy";
    }

    //http://localhost:8189/app/calculate?first=5&second=4
    @GetMapping("/calculate")
    @ResponseBody
    public int culculate(@RequestParam(name = "first") int a,
                         @RequestParam(required = false, defaultValue = "0", name = "second") int b){
        return a+b;
    }

    //http://localhost:8189/app/products/12/info
    @GetMapping("/products/{anyName}/info")
    @ResponseBody
    public String info(@PathVariable(name = "anyName") String id){
        return "product with id = " + id;
    }*/

    // 1) Приходит запрос на /page
    // 2) Создаём модель, которую отдадим в нашу страницу
    // 3) До того, как мы отдаём страницу, в наш ответ мы вшиваем объект, который создали
//    @GetMapping("/product")
//    public String product (Model model, @RequestParam Long id){
//        model.addAttribute("productFront", service.getProduct(id));
//        return "index.html";
//    }

    @GetMapping("/product")
    public String product (Model model, @RequestParam Long id){
        model.addAttribute("productFront", service.getProduct(id) );
        return "index.html";
    }

    @GetMapping("/allproducts")
    public String getAllProducts(Model model){
        model.addAttribute("productsList", service.getAllProducts());
        return "product.html";
    }
    @GetMapping("/products/all")
    public List<Product> getTest(){
        return service.getAllProducts();
    }

    @GetMapping("/products/change_score")
    public void changeScore(@RequestParam Long productId, @RequestParam Float delta){
        service.changeCost(productId, delta);
    }

    @PostMapping("/products/add")
    public void addClientPost(@RequestBody Product product){
        repository.addProduct(product);
    }
}
