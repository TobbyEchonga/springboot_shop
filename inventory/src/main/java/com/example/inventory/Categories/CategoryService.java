package com.example.inventory.Categories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepository repo;
     
    public List<Category> listAll() {
        return repo.findAll();
    }
     
    public void save(Category brand) {
        repo.save(brand);
    }
     
    public Category get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}