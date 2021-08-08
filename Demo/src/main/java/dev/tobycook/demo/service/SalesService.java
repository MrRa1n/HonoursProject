package dev.tobycook.demo.service;

import dev.tobycook.demo.models.Currency;
import dev.tobycook.demo.repository.CurrencyRepository;
import org.springframework.stereotype.Service;


@Service
public class SalesService {

    private final CurrencyRepository currencyRepository;

    public SalesService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency findByCurrencyCode(String currencyCode) {
        return currencyRepository.findByCurrencyCode(currencyCode);
    }
}
