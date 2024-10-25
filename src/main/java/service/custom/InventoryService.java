package service.custom;

import dto.Employee;
import dto.Inventory;
import javafx.collections.ObservableList;
import service.SuperService;

import java.util.List;

public interface InventoryService extends SuperService {
    boolean addInventory(Inventory inventory);
    boolean updateInventory(Inventory inventory);
    boolean deleteInventory(String id);
    List<Inventory> getAll();
    ObservableList<String> getInventoryIds();
    String generateId ();

}
