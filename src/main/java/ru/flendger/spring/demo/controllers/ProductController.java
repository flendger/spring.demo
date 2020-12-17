package ru.flendger.spring.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.flendger.spring.demo.models.Product;
import ru.flendger.spring.demo.services.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String showStart() {
        return "index";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product-add")
    public String showAdd() {
        return "product-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product) {
        productService.add(product);
        return "redirect:/products/all";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/products/all";
    }
}
