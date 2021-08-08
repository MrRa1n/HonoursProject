package dev.tobycook.demo.repository;

import dev.tobycook.demo.models.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {
    Currency findByCurrencyCode(String currencyCode);
}
