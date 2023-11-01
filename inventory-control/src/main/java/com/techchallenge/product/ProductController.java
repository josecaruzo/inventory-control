package com.techchallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired private ProductService service;

    @GetMapping("/products")
    public String showProductsList(Model model){
        List<Product> listaProdutos = service.listAll();
        model.addAttribute("productsList", listaProdutos);

        return "products";
    }

    @GetMapping("/products/new")
    public String showNewForm(Model model){
        model.addAttribute("product", new Product());
        return "newProduct";
    }
    /*@GetMapping("/products/edit")
    public String editProduct(Model model){

    }

    @GetMapping("/products/delete")
    public String deleteProduct(Model model){

    }*/
}
