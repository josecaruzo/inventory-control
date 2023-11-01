package com.techchallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
        model.addAttribute("pageTitle", "Novo Produto");

        return "ProductTemplate";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product produto, RedirectAttributes ra){
        //Quantidade total defaul como 0 para novos produtos
        if(produto.getQuant_total().isNaN()) {
            produto.setQuant_total((float) 0);
        }
        service.save(produto);
        ra.addFlashAttribute("message", "O produto foi salvo com sucesso!");
        return "redirect:/products";
    }
    @GetMapping("/products/edit/{codigo}")
    public String showEditForm(@PathVariable("codigo") String codigo, Model model, RedirectAttributes ra){
        try{
            Product produto = service.get(codigo);
            model.addAttribute("product", produto);
            model.addAttribute("pageTitle", "Edição do Produto " + codigo);
            model.addAttribute("codeDisplay", "none");
            return "ProductTemplate";
        } catch (ProductNotFoundException e){
            ra.addFlashAttribute("message", "Erro ao tentar econtrar o produto!");
            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete/{codigo}")
    public String showEditForm(@PathVariable("codigo") String codigo, RedirectAttributes ra) {
        try {
            service.delete(codigo);
            ra.addFlashAttribute("message", "O produto foi deletado com sucesso!");
        } catch (ProductNotFoundException e) {
            ra.addFlashAttribute("message", "Erro ao tentar econtrar o produto!");
        }
        return "redirect:/products";
    }
}
