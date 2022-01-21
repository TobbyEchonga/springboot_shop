package com.example.inventory.Brands;

//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;


//import com.example.inventory.Products.Product;


@Entity
@Table(name= "brand")
public class Brand {
    private Long brand_id;
    private String brand_name;


    // @OneToMany(mappedBy="brand", fetch = FetchType.LAZY,
    //     cascade = CascadeType.ALL)
    // public Set<Product> products;

    
    
    public Brand() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getBrand_id() {
        return brand_id;
    }
    public String getBrand_name() {
        return brand_name;
    }
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }
}