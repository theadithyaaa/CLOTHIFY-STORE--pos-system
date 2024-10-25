package service.custom.impl;

import Util.DaoType;
import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierService;

import java.util.ArrayList;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    SupplierDao supplierDao = DaoFactory.getInstance().getServiceType(DaoType.SUPPLIER);
    @Override
    public boolean addSupplier(Supplier supplier) {
        SupplierEntity entity = new ModelMapper().map(supplier,SupplierEntity.class);
        return supplierDao.save(entity);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return supplierDao.update(new ModelMapper().map(supplier,SupplierEntity.class));

    }

    @Override
    public boolean deleteSupplier(String id) {
        supplierDao.delete(id);
        return false;
    }

    @Override
    public List<Supplier> getAll() {
        List<SupplierEntity> supplierEntityList = supplierDao.getAll();
        List<Supplier> supplierList = new ArrayList<>();
        if(supplierEntityList != null){
            for (SupplierEntity obj : supplierEntityList) {
                supplierList.add(new ModelMapper().map(obj,Supplier.class));
            }
        }
        return supplierList;
    }

    @Override
    public ObservableList<String> getSupplierIds() {
        return null;
    }

    @Override
    public String generateId() {
        return "";
    }

}
