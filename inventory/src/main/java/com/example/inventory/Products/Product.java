package com.example.inventory.Products;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

//import com.example.inventory.Brands.Brand;
//import com.example.inventory.Categories.Category;

@Entity
@Table(name= "product")
public class Product {
    private Long id;
    private String name;
    private String madein;
    private float price;
    private Long model_year;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "brand_id")
    // private Brand brand;

    // @ManyToOne
    // @JoinColumn(name = "category_id")
    // private Category category;

    private Long brand_id;
    private Long category_id;

  
 


    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


 
    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getModel_year() {
        return model_year;
    }

    public void setModel_year(Long model_year) {
        this.model_year = model_year;
    }

    // public Category getCategory(){
    //     return category;
    // }

    // public void setCategory(Category category){
    //     this.category = category;
    // }

    // public Brand getBrand(){
    //     return brand;
    // }

    // public void setBrand(Brand brand){
    //     this.brand = brand;
    // }

    

    public Long getCategory_id() {
        return category_id;
    }


    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }


    public Long getBrand_id() {
        return brand_id;
    }


    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }
}
