package repository.custom.impl;

import Util.HibernateUtil;
import entity.EmployeeEntity;
import entity.LoginEntity;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.custom.LoginDao;

import java.util.List;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean save(LoginEntity loginEntity) {

            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(loginEntity);
                transaction.commit();
                return true;
            } catch (Exception sqlException) {
                if (null != transaction) {
                    new Alert(Alert.AlertType.ERROR, "Failed to add Record->" + sqlException.getMessage()).show();
                    transaction.rollback();
                    sqlException.printStackTrace();
                }
            } finally {
                session.close();
            }
            return false;
        }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<LoginEntity> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery("from Login",LoginEntity.class).getResultList();
    }

    @Override
    public boolean update(LoginEntity loginEntity) {
        return false;
    }

    @Override
    public LoginEntity search(String id) {
        return null;
    }

    @Override
    public LoginEntity getLogin(String email) {
        Session session = HibernateUtil.getSession();
        return session.get(LoginEntity.class,email);
    }
}
