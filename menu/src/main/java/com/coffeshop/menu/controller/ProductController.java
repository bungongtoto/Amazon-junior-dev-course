package com.coffeshop.menu.controller;

import com.coffeshop.menu.model.Product;
import com.coffeshop.menu.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        model.addAttribute("listProducts", productService.getAllProducts());
        return "menu";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        // create model attribute to bind form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {

        // save product to database
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/";
    }

    @GetMapping("/ShowFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {

        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update-product";
    }

}
