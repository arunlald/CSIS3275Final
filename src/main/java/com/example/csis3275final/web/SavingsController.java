// GitHub link: https://github.com/arunlald/CSIS3275Final.git

package com.example.csis3275final.web;


import com.example.csis3275final.entities.Savings;
import com.example.csis3275final.repositories.SavingsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;


@SessionAttributes({"a", "e"})
@Controller
@AllArgsConstructor

public class SavingsController {
    private SavingsRepository savingsRepository;

    @GetMapping(path = "/index")
    public String savings(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Savings> savings;
        if (keyword.isEmpty()) {
            savings = savingsRepository.findAll();
        } else {
            long key = Long.parseLong(keyword);
            savings = savingsRepository.findCustomerbyID(key);
        }
        model.addAttribute("listSavings", new Savings());
        return "index";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        savingsRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping(path = "/")
    public String savings2(Model model, ModelMap mm, @RequestParam(name = "keyword", defaultValue = "") String keyword, HttpSession session) {
        List<Savings> savings;
        if (keyword.isEmpty()) {
            savings = savingsRepository.findAll();
        } else {
            mm.put("e", 0);
            mm.put("a", 0);
            long key = Long.parseLong(keyword);
            savings = savingsRepository.findCustomerbyID(key);
        }
        model.addAttribute("listSavings", savings);
        return "savings";
    }

    @GetMapping("/edit")
    public String editCustomer(Model model, Long id, HttpSession session) {
        session.setAttribute("info", 0);
        Savings savings = savingsRepository.findById(id).orElse(null);
        if (savings == null) throw new RuntimeException("Patient does not exist");
        model.addAttribute("savings", savings);
        return "edit";
    }

    @GetMapping("/add")
    public String addCustomer(Model model, Long id, HttpSession session) {
        session.setAttribute("info", 0);
        Savings savings = savingsRepository.findById(id).orElse(null);
        if (savings == null) throw new RuntimeException("Patient does not exist");
        model.addAttribute("saving", savings);
        return "add";
    }

//    @PostMapping(path = "/add")
//    public String submit(Model model, Savings savings, @RequestParam(name = "type", defaultValue = "")
//    String type,BindingResult bindingResult, ModelMap mm, HttpSession session) {
//
//        savings = new Savings(type);
//        savingsRepository.save();
//        return "redirect:index";
//    }
//
//    @PostMapping(path = "/edit")
//    public String submit(Model model, Savings savings, @RequestParam(name = "type", defaultValue = "")
//    String type,BindingResult bindingResult, ModelMap mm, HttpSession session) {
//
//        savings = new Savings(type);
//        savingsRepository.save();
//        return "redirect:index";
//    }

//}

}
