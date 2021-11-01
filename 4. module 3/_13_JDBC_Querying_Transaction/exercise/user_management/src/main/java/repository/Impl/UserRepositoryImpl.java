package repository.Impl;

import bean.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    //Bai 1
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
//            Statement statement = BaseRepository.connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from users");
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call get_all_user()}");
            ResultSet resultSet = callableStatement.executeQuery();

            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("insert into users (`name`,email,country)" +
                            "values(?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    //Bai 1
    @Override
    public void remove(int id) {
        try {
//            PreparedStatement preparedStatement =
//                    BaseRepository.connection.prepareStatement("delete from users " +
//                            "where id=?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call remove_user(?)}");
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("select * from users " +
                            "where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    //Bai 1
    @Override
    public void update(User user) {
        try {
//            PreparedStatement preparedStatement =
//                    BaseRepository.connection.prepareStatement("update users set `name`=?,email=?,country=? where id=?");
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getCountry());
//            preparedStatement.setInt(4, user.getId());
//            preparedStatement.executeUpdate();
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call update_user(?,?,?,?)}");
            callableStatement.setString(1,user.getName());
            callableStatement.setString(2,user.getEmail());
            callableStatement.setString(3,user.getCountry());
            callableStatement.setInt(4,user.getId());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("select * from users " +
                    "where country=?");
            preparedStatement.setString(1,country);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    @Override
    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("select * from users order by `name` ");
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
    //Bai 2
    @Override
    public void addUserTransaction(User user) {
        Connection connection = BaseRepository.connection;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into users (`name`,email,country)" +
                            "values(?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(2, user.getCountry());//dòng gây lỗi
            int rowAffect = preparedStatement.executeUpdate();

            if (rowAffect == 1) {
                connection.commit();
                connection.setAutoCommit(true);
            } else {
                connection.rollback();
            }
        } catch (SQLException throwables) {
            try {
                connection.rollback();
                System.out.println(throwables.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
