package repository.custom.impl;

import Util.HibernateUtil;
import entity.EmployeeEntity;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.custom.EmployeeDao;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(EmployeeEntity employeeEntity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(employeeEntity);
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
        session.remove(session.get(EmployeeEntity.class,id));
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery("from Employee",EmployeeEntity.class).getResultList();
    }

    @Override
    public boolean update(EmployeeEntity employeeEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(employeeEntity.getId(),employeeEntity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public EmployeeEntity search(String id) {
        return null;
    }


}
