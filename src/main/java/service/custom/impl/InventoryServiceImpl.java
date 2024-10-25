package service.custom.impl;

import Util.DaoType;
import dto.Inventory;
import entity.InventoryEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.InventoryDao;
import service.custom.InventoryService;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    InventoryDao inventoryDao = DaoFactory.getInstance().getServiceType(DaoType.INVENTORY);
    @Override
    public boolean addInventory(Inventory inventory) {
        InventoryEntity entity = new ModelMapper().map(inventory, InventoryEntity.class);
        return inventoryDao.save(entity);
    }

    @Override
    public boolean updateInventory(Inventory inventory) {
        inventoryDao.update(new ModelMapper().map(inventory,InventoryEntity.class));
        return false;
    }

    @Override
    public boolean deleteInventory(String id) {
        inventoryDao.delete(id);
        return false;
    }

    @Override
    public List<Inventory> getAll() {
        List<InventoryEntity> inventoryentitylist = inventoryDao.getAll();
        List<Inventory> inventoryList = new ArrayList<>();
        if(inventoryentitylist != null){
            for (InventoryEntity obj : inventoryentitylist) {
                inventoryList.add(new ModelMapper().map(obj,Inventory.class));
            }
        }
        return inventoryList;
    }

    @Override
    public ObservableList<String> getInventoryIds() {
        return null;
    }

    @Override
    public String generateId() {
        return "";
    }
}
