package service.custom;

import dto.Login;
import javafx.collections.ObservableList;
import service.SuperService;

import java.util.List;

public interface LoginService extends SuperService {
    boolean addLogin(Login login);
    boolean updateLogin(Login login);
    List<Login> getAll();
    ObservableList<String> getLoginIds();
    String generateId ();
    Login getLogin(String email);

}
