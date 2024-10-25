package service.custom.impl;

import Util.DaoType;
import dto.Login;
import entity.LoginEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.LoginDao;
import service.custom.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = DaoFactory.getInstance().getServiceType(DaoType.LOGIN);
    @Override
    public boolean addLogin(Login login) {
        LoginEntity entity = new ModelMapper().map(login,LoginEntity.class);
        return loginDao.save(entity);
    }

    @Override
    public boolean updateLogin(Login login) {
        return false;
    }

    @Override
    public List<Login> getAll() {
        return List.of();
    }

    @Override
    public ObservableList<String> getLoginIds() {
        return null;
    }

    @Override
    public String generateId() {
        return "";
    }
}
