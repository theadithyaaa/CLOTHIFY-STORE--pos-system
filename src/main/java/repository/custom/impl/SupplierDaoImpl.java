package repository.custom.impl;

import Util.HibernateUtil;
import entity.EmployeeEntity;
import entity.SupplierEntity;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.custom.SupplierDao;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public boolean save(SupplierEntity supplierEntity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(supplierEntity);
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
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(SupplierEntity.class,id));
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public List<SupplierEntity> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery("from Supplier",SupplierEntity.class).getResultList();

    }

    @Override
    public boolean update(SupplierEntity supplierEntity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(supplierEntity);
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
    public SupplierEntity search(String id) {
        return null;
    }
}
