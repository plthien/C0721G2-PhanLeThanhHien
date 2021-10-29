package service;

import bean.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
    void remove(int id);
    User findById(int id);
    void update(User user);
    List<User> findByCountry(String country);
    List<User> sortByName();
}
