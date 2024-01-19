package com.completerestapi.day7.controllers;

import com.completerestapi.day7.models.Product;
import com.completerestapi.day7.productexception.NoProductFoundException;
import com.completerestapi.day7.productexception.NoResourceFoundException;
import com.completerestapi.day7.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
public class ProductController {
    @Autowired
    public  ProductServices productServices;

    //creating a product using POST Method
    @PostMapping("/product")
    public  void saveProduct(@RequestBody Product product){
        productServices.createProduct(product);
    }

    //Fetching all Products
    @GetMapping("/product")
    public List<Product> fetchproduct(){
        List<Product> prod= productServices.retriveProduct();
        return ResponseEntity.ok().body(prod).getBody();
    }

    //Fetching product based on product ID
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable  int id){
        Product prod=productServices.findProdById(id);
        return ResponseEntity.ok().body(prod).getBody();
    }

    //Deleting product based on Product ID
    @DeleteMapping("/product/{id}")
    public  void removeProductById(@PathVariable int id){
        productServices.deleteProdById(id);
    }

    //Updating Product based on product ID
    @PutMapping("/product/{id}")
    public Product updateProductPrice(@PathVariable int id,@RequestBody Product product){
       return productServices.updateProductPrice(id, product);
    }

}
