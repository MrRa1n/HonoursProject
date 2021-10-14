package dev.tobycook.demo.repository.humanresources;

import dev.tobycook.demo.models.humanresources.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
