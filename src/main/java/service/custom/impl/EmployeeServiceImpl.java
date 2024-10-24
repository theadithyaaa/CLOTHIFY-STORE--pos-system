package service.custom.impl;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import service.custom.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public boolean addEmployee(Employee employee) {
        EmployeeEntity entity = new ModelMapper().map(employee,EmployeeEntity.class);
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {
        return false;
    }

    @Override
    public ObservableList<Employee> getAll() {
        return null;
    }

    @Override
    public ObservableList<String> getEmployeeIds() {
        return null;
    }

    @Override
    public String generateId() {
        return "";
    }
}
