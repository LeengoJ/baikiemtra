package com.example.demo.controller;

import com.example.demo.models.NhanVien;
import com.example.demo.models.Product;
import com.example.demo.sercives.NhanvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("nhanvien")
public class NhanvienController {
    @Autowired
    private NhanvienService nhanvienService;

    @GetMapping("/index")
    public String index (Model model)
    {
        model.addAttribute("listnhanvien",nhanvienService.GetAll());
        return "nhanvien/index";
    }
    @RequestMapping("/create")
    public String showNewNhanVienPage(Model model) {
        NhanVien nhanvien = new NhanVien();
        model.addAttribute("nhanvien", nhanvien);

        return "nhanvien/new_nhanvien";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("nhanvien") NhanVien nhanVien) {
        nhanvienService.save(nhanVien);
        return "redirect:/nhanvien/index";
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") String id) {
        nhanvienService.delete(id);
        return "redirect:/index";
    }
    @RequestMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") String id,Model model) {
        NhanVien nhanVien = nhanvienService.get(id);
        model.addAttribute("nhanvien",nhanVien);
        return "nhanvien/edit_nhanvien";
    }
}