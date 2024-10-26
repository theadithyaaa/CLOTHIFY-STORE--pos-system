package service.custom.impl;

import Util.DaoType;
import dto.Orders;
import dto.Supplier;
import entity.OrderEntity;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.OrdersDao;
import repository.custom.SupplierDao;
import service.custom.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrdersDao ordersDao = DaoFactory.getInstance().getServiceType(DaoType.ORDER);


    public boolean addOrders(Orders orders) {
        OrderEntity entity = new ModelMapper().map(orders,OrderEntity.class);
        return ordersDao.save(entity);
    }


    public boolean updateOrders(Orders orders) {
        return false;
    }

    @Override
    public boolean deleteOrders(String id) {
        return false;
    }

    @Override
    public List<Orders> getAll() {

        List<OrderEntity> orderEntityList = ordersDao.getAll();
        List<Orders> ordersList = new ArrayList<>();
        if(orderEntityList != null){
            for (OrderEntity obj : orderEntityList) {
                ordersList.add(new ModelMapper().map(obj,Orders.class));
            }
        }
        return ordersList;
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
