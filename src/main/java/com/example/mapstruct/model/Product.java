package com.example.mapstruct.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Table
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String desc;
    private int quantity;
    private long price;
    private String  itemId;

@OneToMany
    private List<Item> items;
}
