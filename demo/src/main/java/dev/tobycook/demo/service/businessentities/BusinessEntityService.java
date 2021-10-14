package dev.tobycook.demo.service.businessentities;

import dev.tobycook.demo.models.person.BusinessEntity;
import dev.tobycook.demo.repository.businessentities.BusinessEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessEntityService {

    private BusinessEntityRepository businessEntityRepository;

    public BusinessEntityService(BusinessEntityRepository businessEntityRepository) {
        this.businessEntityRepository = businessEntityRepository;
    }

    public Optional<BusinessEntity> findById(Integer id) {
        return businessEntityRepository.findById(id);
    }

}
