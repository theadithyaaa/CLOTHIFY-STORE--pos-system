package service.custom;


import dto.Supplier;
import javafx.collections.ObservableList;
import service.SuperService;

import java.util.List;

public interface SupplierService extends SuperService {
    boolean addSupplier(Supplier supplier);
    boolean updateSupplier(Supplier supplier);
    boolean deleteSupplier(String id);
    List<Supplier> getAll();
    ObservableList<String> getSupplierIds();
    String generateId ();

}
