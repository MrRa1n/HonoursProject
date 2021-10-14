package dev.tobycook.demo.repository.businessentities;

import dev.tobycook.demo.models.person.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessEntityRepository extends JpaRepository<BusinessEntity, Integer> {
}
