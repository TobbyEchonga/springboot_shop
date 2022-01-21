package com.example.inventory.Categories;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.inventory.Products.Product;

@Entity
@Table(name= "category")
public class Category {
    
    private Long category_id;
    private String category_name;
    
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();
    
    public Category() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCategory_id() {
        return category_id;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}