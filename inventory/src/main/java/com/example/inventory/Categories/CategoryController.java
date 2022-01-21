package com.example.inventory.Categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService service;

    @RequestMapping("/category/")
    public String viewHomePage(Model model) {
        List<Category> listCategories = service.listAll();
        model.addAttribute("listCategories", listCategories);
        
        return "category/index";
    }

    @RequestMapping("/category/new")
    public String showNewCategoryPage(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        
        return "category/new_category";
    }

    @RequestMapping(value = "/category/save", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category) {
        service.save(category);
        
        return "redirect:/category/";
    }

    @RequestMapping("/category/edit/{id}")
    public ModelAndView showEditCategoryPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("category/edit_category");
        Category category = service.get(id);
        mav.addObject("category", category);
        
        return mav;
    }

    @RequestMapping("/category/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/category/";       
    }
}