package repository.custom.impl;

import entity.InventoryEntity;
import repository.custom.InventoryDao;

import java.util.List;

public class InventoryDaoImpl implements InventoryDao {
    @Override
    public boolean save(InventoryEntity inventoryEntity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<InventoryEntity> getAll() {
        return List.of();
    }

    @Override
    public boolean update(InventoryEntity inventoryEntity) {
        return false;
    }

    @Override
    public InventoryEntity search(String id) {
        return null;
    }
}
