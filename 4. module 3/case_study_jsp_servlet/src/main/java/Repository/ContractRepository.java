package Repository;

import bean.*;

import java.util.List;

public interface ContractRepository {
    List<Contract> findAllContract();

    List<ContractDetail> findAllContractDetail();

    void saveContract(Contract contract);

    void saveContractDetail(ContractDetail contractDetail);

    void updateContract(Contract contract);

    void updateContractDetail(ContractDetail contractDetail);

    void remove(String id);

    List<Contract> findById(String id);

    List<Employee> getEmployee();

    List<Customer> getCustomer();

    List<Facility> getFacility();
}
