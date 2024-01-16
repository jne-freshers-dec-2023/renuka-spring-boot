package com.completerestapi.day7.services;

import com.completerestapi.day7.models.Product;
import com.completerestapi.day7.productexception.NoProductFoundException;
import com.completerestapi.day7.productexception.NoResourceFoundException;
import com.completerestapi.day7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class ProductServices {
    private  List<Product> products= new ArrayList<>();

    @Autowired
    ProductRepository productRepository;
    //Creating Product 
    public void createProduct(Product product){
        productRepository.save(product);
    }

    //Fetching  all product
    public  List<Product> retriveProduct(){
        List<Product> listProduct;
        listProduct=productRepository.findAll();
        return listProduct;
    }
    
    //Fetching product based on ID
    public Product findProdById(int id){
        Optional<Product> prod= productRepository.findById(id);
        if(prod.isPresent()){
          return prod.get();
        }
        else {
            throw new NoProductFoundException("No product found Exception with id:"+id);
        }
    }

    //Deleting product based on ID
    public void deleteProdById(int id){
        Optional<Product> prod =productRepository.findById(id);
        if(prod.isPresent()){
            productRepository.deleteById(id);
        }
        else {
            throw new NoResourceFoundException("No product found Exception with id:"+id);
        }
    }

    //Updating Product based on product ID
    public Product updateProductPrice(int id,Product prod){
        Optional<Product> updateproduct = productRepository.findById(id);//productRepository.findById(id);
        if(updateproduct.isPresent()){
            Product updateprod= updateproduct.get();
            updateprod.setName(prod.getName());
            updateprod.setPrice(prod.getPrice());
            return ResponseEntity.ok(productRepository.save(updateprod)).getBody();
        }
        else {
            throw new NoResourceFoundException("No Resource found Exception with id:"+id);
        }

    }
}
