package Repository.Impl;

import Repository.ContractRepository;
import bean.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {

    @Override
    public List<Contract> findAllContract() {
        List<Contract> contractList = new ArrayList<>();

        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call get_all_contract()}");
            ResultSet resultSet = callableStatement.executeQuery();

            Contract contract = null;
            Employee employee = null;
            Customer customer = null;
            Facility facility = null;
            while (resultSet.next()) {
                contract = new Contract();
                employee = new Employee();
                customer = new Customer();
                facility = new Facility();
                contract.setId(resultSet.getString("id"));
                contract.setCheckInDate(resultSet.getString("check_in_date"));
                contract.setCheckOutDate(resultSet.getString("check_out_date"));
                contract.setDeposit(resultSet.getDouble("deposit"));
                contract.setPayment(resultSet.getDouble("payment"));

                employee.setId(resultSet.getString("employee_id"));
                employee.setName(resultSet.getString("employee_name"));

                customer.setId(resultSet.getString("customer_id"));
                customer.setName(resultSet.getString("customer_name"));

                facility.setId(resultSet.getString("facility_id"));
                facility.setName(resultSet.getString("facility_name"));

                contract.setEmployee(employee);
                contract.setCustomer(customer);
                contract.setFacility(facility);

                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return contractList;
    }

    @Override
    public List<ContractDetail> findAllContractDetail() {
        List<ContractDetail> contractDetailList = new ArrayList<>();

        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call get_all_contract_detail()}");
            ResultSet resultSet = callableStatement.executeQuery();

            ContractDetail contractDetail = null;
            Contract contract = null;
            ExtraService extraService = null;
            while (resultSet.next()){
                contractDetail = new ContractDetail();
                contract = new Contract();
                extraService = new ExtraService();

                contractDetail.setId(resultSet.getInt("id"));
                contractDetail.setQuantity(resultSet.getInt("quantity"));
                contract.setId(resultSet.getString("contract_id"));
                extraService.setId(resultSet.getInt("extra_service_id"));
                extraService.setName(resultSet.getString("extra_service_name"));
                extraService.setUnit(resultSet.getString("unit"));
                extraService.setPrice(resultSet.getDouble("price"));

                contractDetail.setContract(contract);
                contractDetail.setExtraService(extraService);

                contractDetailList.add(contractDetail)  ;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetailList;
    }

    @Override
    public void saveContract(Contract contract) {
        Connection connection = BaseRepository.connection;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment) " +
                    " values(?,?,?,?,?,?,?)");
            preparedStatement.setString(1,contract.getCustomer().getId());
            preparedStatement.setString(2,contract.getEmployee().getId());
            preparedStatement.setString(3,contract.getFacility().getId());
            preparedStatement.setString(4,contract.getCheckInDate());
            preparedStatement.setString(5,contract.getCheckOutDate());
            preparedStatement.setDouble(6,contract.getDeposit());
            preparedStatement.setDouble(7,contract.getPayment());

            int rowAffect = preparedStatement.executeUpdate();

            if (rowAffect == 1) {
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.setAutoCommit(true);

        } catch (SQLException throwables) {
            try {
                connection.rollback();
                System.out.println(throwables.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {

    }

    @Override
    public void updateContract(Contract contract) {
        Connection connection = BaseRepository.connection;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("update contract set " +
                    " customer_id=?,employee_id=?,facility_id=?,check_in_date=?,check_out_date=?,deposit=?,payment=? " +
                    " where id=? ");
            preparedStatement.setString(1,contract.getCustomer().getId());
            preparedStatement.setString(2,contract.getEmployee().getId());
            preparedStatement.setString(3,contract.getFacility().getId());
            preparedStatement.setString(4,contract.getCheckInDate());
            preparedStatement.setString(5,contract.getCheckOutDate());
            preparedStatement.setDouble(6,contract.getDeposit());
            preparedStatement.setDouble(7,contract.getPayment());
            preparedStatement.setString(8,contract.getId());

            int rowAffect = preparedStatement.executeUpdate();

            if (rowAffect == 1) {
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.setAutoCommit(true);

        } catch (SQLException throwables) {
            try {
                connection.rollback();
                System.out.println(throwables.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateContractDetail(ContractDetail contractDetail) {

    }

    @Override
    public void remove(String id) {
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call delete_contract(?)}");
            callableStatement.setString(1,id);
            callableStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Contract> findById(String id) {
        List<Contract> contractList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("{call get_contract_by_id(?)}");
            preparedStatement.setString(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Contract contract = null;
            Customer customer = null;
            Employee employee = null;
            Facility facility = null;
            while (resultSet.next()){
                customer = new Customer();
                contract = new Contract();
                employee = new Employee();
                facility = new Facility();

                contract.setId(resultSet.getString("id"));
                contract.setCheckInDate(resultSet.getString("check_in_date"));
                contract.setCheckOutDate(resultSet.getString("check_out_date"));
                contract.setDeposit(resultSet.getDouble("deposit"));
                contract.setPayment(resultSet.getDouble("payment"));

                employee.setId(resultSet.getString("employee_id"));
                employee.setName(resultSet.getString("employee_name"));

                customer.setId(resultSet.getString("customer_id"));
                customer.setName(resultSet.getString("customer_name"));

                facility.setId(resultSet.getString("facility_id"));
                facility.setName(resultSet.getString("facility_name"));

                contract.setEmployee(employee);
                contract.setCustomer(customer);
                contract.setFacility(facility);

                contractList.add(contract);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public List<Employee> getEmployee() {
        return null;
    }

    @Override
    public List<Customer> getCustomer() {
        return null;
    }

    @Override
    public List<Facility> getFacility() {
        return null;
    }
}
