package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employees",
                service.getAllEmployees());
        return "index";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee",
                new Employee());
        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute Employee employee) {

        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(
            @PathVariable Long id,
            Model model) {

        model.addAttribute("employee",
                service.getEmployeeById(id));

        return "edit-employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(
            @PathVariable Long id) {

        service.deleteEmployee(id);
        return "redirect:/";
    }
}