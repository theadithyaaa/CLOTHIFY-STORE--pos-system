package service.custom.impl;

import Util.DaoType;
import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import service.custom.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao = DaoFactory.getInstance().getServiceType(DaoType.EMPLOYEE);
    @Override
    public boolean addEmployee(Employee employee) {
        EmployeeEntity entity = new ModelMapper().map(employee,EmployeeEntity.class);
        return employeeDao.save(entity);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        employeeDao.update(new ModelMapper().map(employee,EmployeeEntity.class));
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {
        employeeDao.delete(id);
        return false;
    }

    @Override
    public List<Employee> getAll() {
        List<EmployeeEntity> employeeentitylist = employeeDao.getAll();
        List<Employee> employeelist = new ArrayList<>();
        if(employeeentitylist != null){
            for (EmployeeEntity obj : employeeentitylist) {
                employeelist.add(new ModelMapper().map(obj,Employee.class));
            }
        }
        return employeelist;
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
