package com.kh.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyMapper companyMapper;


    @PostMapping("")
    public int post(@RequestBody Company company) {
        return companyMapper.insert(company);
    }

    @GetMapping("")
    public Company getById(@PathVariable("id") int id) {
        return companyMapper.getById(id);
    }
}
