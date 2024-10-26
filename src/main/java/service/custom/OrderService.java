package service.custom;


import dto.Orders;
import dto.Supplier;
import javafx.collections.ObservableList;
import service.SuperService;

import java.util.List;

public interface OrderService extends SuperService {
    boolean addOrders(Orders orders);
    boolean updateOrders(Orders orders);
    boolean deleteOrders(String id);
    List<Orders> getAll();
    ObservableList<String> getSupplierIds();
    String generateId ();

}