package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
    
    @GetMapping("/companyInfo")
    public String showCompanyInfo() {
        return "companyInfo"; // companyInfo.html을 반환
    }
}
