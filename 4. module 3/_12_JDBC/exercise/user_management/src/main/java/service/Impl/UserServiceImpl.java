package service.Impl;

import bean.User;
import repository.IUserRepository;
import repository.Impl.UserRepositoryImpl;
import service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserRepository iUserRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
         return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(int id) {
        iUserRepository.remove(id);
    }

    @Override
    public User findById(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void update(User user) {
        iUserRepository.update(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return iUserRepository.findByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return iUserRepository.sortByName();
    }
}
