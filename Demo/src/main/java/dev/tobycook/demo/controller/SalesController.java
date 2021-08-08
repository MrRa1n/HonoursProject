package dev.tobycook.demo.controller;

import dev.tobycook.demo.models.Currency;
import dev.tobycook.demo.service.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping(path = "/currencies/{currencyCode}")
    public ResponseEntity<Currency> findByCurrencyCode(@PathVariable String currencyCode) {
        Currency currencies = salesService.findByCurrencyCode(currencyCode);
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }
}
