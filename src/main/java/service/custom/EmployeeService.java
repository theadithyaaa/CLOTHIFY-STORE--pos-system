package service.custom;

import dto.Employee;
import javafx.collections.ObservableList;
import service.SuperService;

import java.util.List;

public interface EmployeeService extends SuperService {
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(String id);
    List<Employee> getAll();
    ObservableList<String> getEmployeeIds();
    String generateId ();

}
