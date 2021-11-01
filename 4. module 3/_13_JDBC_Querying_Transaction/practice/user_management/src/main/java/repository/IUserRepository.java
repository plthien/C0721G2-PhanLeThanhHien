package repository;

import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {

    List<User> findAll();
    void save(User user);
    void remove(int id);
    User findById(int id);
    void update(User user);
    List<User> findByCountry(String country);
    List<User> sortByName();

    User getUserById(int id);

    void insertUserStore(User user);

    void addUserTransaction(User user, int[] permision);

    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();



}
