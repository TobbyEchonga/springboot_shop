package com.example.inventory.Brands;

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
public class BrandController {

    @Autowired
    private BrandService service;

    @RequestMapping("/brand/")
    public String viewHomePage(Model model) {
        List<Brand> listBrands = service.listAll();
        model.addAttribute("listBrands", listBrands);
        
        return "brand/index";
    }
    
    @RequestMapping("/brand/new")
    public String showNewBrandPage(Model model) {
        Brand brand = new Brand();
        model.addAttribute("brand", brand);
        
        return "brand/new_brand";
    }

    @RequestMapping(value = "/brand/save", method = RequestMethod.POST)
    public String saveBrand(@ModelAttribute("brand") Brand brand) {
        service.save(brand);
        
        return "redirect:/brand/";
    }

    @RequestMapping("/brand/edit/{id}")
    public ModelAndView showEditBrandPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("/brand/edit_brand");
        Brand brand = service.get(id);
        mav.addObject("brand", brand);
        
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/brand/";       
    }

}