package dev.tobycook.demo.service.humanresources;

import dev.tobycook.demo.models.humanresources.Employee;
import dev.tobycook.demo.repository.humanresources.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }
}
