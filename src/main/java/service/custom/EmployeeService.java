package service.custom;

import dto.Employee;
import javafx.collections.ObservableList;
import service.SuperService;

public interface EmployeeService extends SuperService {
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(String id);
    ObservableList<Employee> getAll();
    ObservableList<String> getEmployeeIds();
    String generateId ();

}
