package repository.custom.impl;

import Util.HibernateUtil;
import entity.OrderEntity;
import entity.SupplierEntity;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.custom.OrdersDao;

import java.util.List;

public class OrderDaoImpl implements OrdersDao {
    @Override
    public boolean save(OrderEntity orderEntity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(orderEntity);
            transaction.commit();
            return true;
        } catch (Exception sqlException) {
            if (null != transaction) {
                new Alert(Alert.AlertType.ERROR, "Failed to add Record->" + sqlException.getMessage()).show();
                transaction.rollback();
                sqlException.printStackTrace();
            }
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(OrderEntity.class,id));
        session.getTransaction().commit();
        session.close();
        return false;    }

    @Override
    public List<OrderEntity> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery("from Orders",OrderEntity.class).getResultList();
    }

    @Override
    public boolean update(OrderEntity orderEntity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(orderEntity);
            transaction.commit();
            return true;
        } catch (Exception sqlException) {
            if (null != transaction) {
                new Alert(Alert.AlertType.ERROR, "Failed to add Record->" + sqlException.getMessage()).show();
                transaction.rollback();
                sqlException.printStackTrace();
            }
        }finally{
            session.close();
        }
        return false;    }

    @Override
    public OrderEntity search(String id) {
        return null;
    }
}
