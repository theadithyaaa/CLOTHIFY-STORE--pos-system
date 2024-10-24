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
        }finally{//oya widihata session ekai transacction ekai hadala delete update search(remove, merge, get) tikath karanna thiyenne
            //hari neda ? uba ko ?innawa pahadilida?o sudu
            session.close();
        }
        return false;    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return List.of();
    }

    @Override
    public boolean update(EmployeeEntity employeeEntity) {
        return false;
    }

    @Override
    public EmployeeEntity search(String id) {
        return null;
    }
}
