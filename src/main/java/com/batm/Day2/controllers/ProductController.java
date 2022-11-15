package com.batm.Day2.controllers;

import com.batm.Day2.entities.Category;
import com.batm.Day2.entities.Product;
import com.batm.Day2.services.CategoryService;
import com.batm.Day2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    // instance object dari Service
    @Autowired
    private ProductService productService;

    // get all
    @GetMapping
    public String productIndex(Model model) {
        model.addAttribute("product", productService.findAllProduct());
        return "product/product-index";
    }

    // form save
    @GetMapping(value = {"form", "form/{id}"})
    public String productForm(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("product", productService.findProductById(id));
        } else {
            model.addAttribute("product", new Product());
        }
        return "product/product-form";
    }

    // save
    @PostMapping("save")
    public String productSave(Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }

    // delete
    @PostMapping("delete/{id}")
    public String productDelete(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/product";
    }
}
