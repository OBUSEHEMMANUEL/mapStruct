package com.example.mapstruct.controller;


import com.example.mapstruct.dto.ProductDto;
import com.example.mapstruct.mapper.ProductMapper;
import com.example.mapstruct.model.Product;
import com.example.mapstruct.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository repository;

    public static final Logger LOGGER= LoggerFactory.getLogger(ProductController.class);
@PostMapping("/product")
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) {
    LOGGER.info("DATA FROM getDATA()");
        return new ResponseEntity<>(repository.save(productMapper.dtoToModel(productDto)), HttpStatus.CREATED);
    }
@GetMapping("/products")
    public  ResponseEntity<?> findAll(){
        return  new ResponseEntity<>(productMapper.modelToDtos(repository.findAll()),HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public  ResponseEntity<?> findById(@PathVariable(value = "id") int id){
        return  new ResponseEntity<>(productMapper.modelToDto(repository.findById(id).get()),HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable(value = "id") int id){
      var foundProduct =  productMapper.modelToDto(repository.findById(id).get());
        repository.deleteById(foundProduct.getId());
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
