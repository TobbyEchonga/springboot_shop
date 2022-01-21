package com.example.inventory.Brands;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BrandService {

    @Autowired
    private BrandRepository repo;
     
    public List<Brand> listAll() {
        return repo.findAll();
    }
     
    public void save(Brand brand) {
        repo.save(brand);
    }
     
    public Brand get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}