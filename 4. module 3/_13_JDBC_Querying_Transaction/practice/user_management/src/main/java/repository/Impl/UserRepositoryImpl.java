package repository.Impl;

import bean.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {

    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

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

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("delete from users " +
                            "where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
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

    @Override
    public void update(User user) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("update users set `name`=?,email=?,country=? where id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
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
    //Bai thuc hanh 1
    @Override
    public User getUserById(int id) {
        User user = null;
        try {
            CallableStatement callableStatement =
                    BaseRepository.connection.prepareCall("{call get_user_by_id(?)}");
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }
    //Bai thuc hanh 1
    @Override
    public void insertUserStore(User user){
        CallableStatement callableStatement =
                null;
        try {
            callableStatement = BaseRepository.connection.prepareCall("{call insert_user(?,?,?)}");
            callableStatement.setString(1,user.getName());
            callableStatement.setString(2,user.getEmail());
            callableStatement.setString(3,user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    //Bai thuc hanh 2
    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection connection = BaseRepository.connection;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement =
                    connection.prepareStatement("insert into users (`name`,email,country)" +
                            "values(?,?,?)",Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            int rowAffected = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int userId = 0;

            if (resultSet.next()){
                userId = resultSet.getInt(1);
            }

            if (rowAffected == 1){
                preparedStatement1 = connection.prepareStatement("insert into user_permision (user_id,permision_id) " +
                                "values(?,?) ");
                for (int permisionId: permision) {

                    preparedStatement1.setInt(1,userId);
                    preparedStatement1.setInt(2,permisionId);
                    preparedStatement1.executeUpdate();

                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        finally {
            try {
                if (resultSet !=null) resultSet.close();
                if (preparedStatement !=null) preparedStatement.close();
                if (preparedStatement1 != null) preparedStatement1.close();
                if (connection != null) connection.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    //Bai thuc hanh 3
    @Override
    public void insertUpdateWithoutTransaction() {
        Connection connection = BaseRepository.connection;
        try {
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE);

            preparedStatementInsert.setString(1,"Quynh");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

            preparedStatementInsert.setString(1,"Ngan");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

            preparedStatementUpdate.setBigDecimal(2, new BigDecimal(999.99));
            preparedStatementUpdate.setString(2,"Quynh");
            preparedStatementUpdate.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    //Bai thuc hanh 4
    @Override
    public void insertUpdateUseTransaction() {
        Connection connection = BaseRepository.connection;
        try {
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE);

            connection.setAutoCommit(false);

            preparedStatementInsert.setString(1,"Quynh");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

            preparedStatementInsert.setString(1,"Ngan");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

            preparedStatementUpdate.setBigDecimal(2, new BigDecimal(999.99));
            preparedStatementUpdate.setString(2,"Quynh");
            preparedStatementUpdate.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
