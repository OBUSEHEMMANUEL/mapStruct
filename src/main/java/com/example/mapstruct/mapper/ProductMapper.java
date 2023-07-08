package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.ProductDto;
import com.example.mapstruct.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface ProductMapper {
    ProductMapper INSTANCE= Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.desc", target="description")
//    @Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
//    @Mapping(source = "product.items", target = "itemsList")
    ProductDto modelToDto(Product product);
//@Mapping(source = "productDto.description", target="desc")


    List<ProductDto> modelToDtos(List<Product> products);


    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productDto);


}
