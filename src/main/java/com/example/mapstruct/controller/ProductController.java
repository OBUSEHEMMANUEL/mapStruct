package com.example.mapstruct.controller;

import com.example.mapstruct.dto.ProductDto;
import com.example.mapstruct.mapper.ProductMapper;
import com.example.mapstruct.model.Product;
import com.example.mapstruct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController


public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository repository;
@PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(repository.save(productMapper.dtoToModel(productDto)), HttpStatus.CREATED);
    }
@GetMapping("/products")
    public  ResponseEntity<List<ProductDto>> findAll(){
        return  new ResponseEntity<>(productMapper.modelToDtos(repository.findAll()),HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public  ResponseEntity<ProductDto> findById(@PathVariable(value = "id") int id){
        return  new ResponseEntity<>(productMapper.modelToDto(repository.findById(id).get()),HttpStatus.OK);
    }
}
