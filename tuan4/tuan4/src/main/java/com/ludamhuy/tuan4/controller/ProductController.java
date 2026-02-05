package com.ludamhuy.tuan4.controller;

import com.ludamhuy.tuan4.entity.Product;
import com.ludamhuy.tuan4.repository.CategoryRepository;
import com.ludamhuy.tuan4.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "products/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepo.findAll());
        return "products/create";
    }

    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute("product") Product product,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryRepo.findAll());
            return "products/create";
        }
        productRepo.save(product);
        return "redirect:/products";
    }
}
