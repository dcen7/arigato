package com.binarycod.arigato.controllers;

import com.binarycod.arigato.domain.Product;
import com.binarycod.arigato.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products") 
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping
    public String getProducts(Model model){
       model.addAttribute("products", productService.getAllProducts());

        return "product_list";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @PostMapping
    public String createProduct(@RequestParam Long id, @RequestParam String name, @RequestParam Double price, @RequestParam Integer size){

//        productList.add(product);
        Product p = new Product(id, name, price, size);
        productService.createProduct(p);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id){
//        productList = productList
//                .stream()
//                .filter(p -> !p.getId().equals(id))
//                .collect(Collectors.toList());
        return "redirect:/products";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam Long id, Model model){
//        Optional<Product> optionalProduct = productList
//                .stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst();
//        if(!optionalProduct.isPresent())
//            return "redirect:/products";
//
//        model.addAttribute("product", optionalProduct.get());

        return "edit_product";
    }

    @PostMapping("/edit")
    public String saveProduct(Product product){
//        Optional<Product> productOld = productList
//                .stream()
//                .filter(p -> p.getId().equals(product.getId()))
//                .findFirst();
//
//        if(productOld.isPresent()){
//            productList.remove(productOld.get());
//            productList.add(product);
//        }
        return "redirect:/products";
    }


}
