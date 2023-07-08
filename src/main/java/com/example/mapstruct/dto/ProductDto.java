package com.example.mapstruct.dto;

import com.example.mapstruct.model.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ProductDto {
    @Id
    private int id;
    private String name;
    private int quantity;
    private String description;
    private long price;
    private String itemId;

@OneToMany
private List<Item> itemsList;
}
