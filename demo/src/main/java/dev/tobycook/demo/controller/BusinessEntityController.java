package dev.tobycook.demo.controller;

import dev.tobycook.demo.models.person.BusinessEntity;
import dev.tobycook.demo.service.businessentities.BusinessEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/business-entities")
public class BusinessEntityController {

    private BusinessEntityService businessEntityService;

    public BusinessEntityController(BusinessEntityService businessEntityService) {
        this.businessEntityService = businessEntityService;
    }

    @GetMapping("/{id}")
    public BusinessEntity findById(@PathVariable Integer id) {
        return businessEntityService.findById(id).orElse(null);
    }

}
