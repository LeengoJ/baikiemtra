package com.example.demo.controller;

import com.example.demo.models.Product;
import com.example.demo.sercives.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String Index (Model model)
    {

        model.addAttribute("listproduct",productService.GetALl());
        return "products/index";
    }
    @GetMapping("/create")
    public String Create (Model model)
    {
        model.addAttribute("product",new Product());
        return "products/create";
    }
    @PostMapping("/create")
    public String create (@Valid Product newProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("product",newProduct);
            return "products/create";
        }
        if (imageProduct !=null && imageProduct.getSize()>0)
        {
            try
            {
                File saveFile =  new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID()+ ".png";
                Path path = Paths.get(saveFile.getAbsolutePath()+File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
                newProduct.setImage(newImageFile);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        productService.add(newProduct);
        return "redirect:/products";
    }
    @GetMapping("delete/{id}")
    public String delete (@PathVariable("id")Long id)
    {
        productService.delete(id);
        return "redirect:/products";
    }



}
