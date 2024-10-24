package repository.custom.impl;

import entity.LoginEntity;
import repository.custom.LoginDao;

import java.util.List;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean save(LoginEntity loginEntity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<LoginEntity> getAll() {
        return List.of();
    }

    @Override
    public boolean update(LoginEntity loginEntity) {
        return false;
    }

    @Override
    public LoginEntity search(String id) {
        return null;
    }
}
