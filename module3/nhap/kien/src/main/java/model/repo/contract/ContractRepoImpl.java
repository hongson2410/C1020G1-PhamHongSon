package model.repo.contract;

import model.bean.Contract;
import model.repo.BaseRepo;
import model.repo.FuramaRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepoImpl implements FuramaRepository<Contract> {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call show_contract()");

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()){

                int id = resultSet.getInt("contract_id");
                String startDate = resultSet.getString("contract_start_date");
                String endDate = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double total = resultSet.getDouble("contract_total_money");
                String idEmployee = resultSet.getString("employee_id");
                String idCustomer = resultSet.getString("customer_id");
                String idService = resultSet.getString("service_id");

                Contract contract = new Contract(id,startDate,endDate,deposit,total,idEmployee,idCustomer,idService);

                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contractList;
    }

    @Override
    public Contract selectById(String id) {
        return null;
    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Contract> searchName(String name) {
        return null;
    }

    @Override
    public void add(Contract contract) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call create_contract(?,?,?,?,?,?,?)");
            callableStatement.setString(1,contract.getStartDateContract());
            callableStatement.setString(2,contract.getEndDateContract());
            callableStatement.setDouble(3,contract.getDeposit());
            callableStatement.setDouble(4,contract.getTotal());
            callableStatement.setString(5,contract.getEmployeeID());
            callableStatement.setString(6,contract.getCustomerID());
            callableStatement.setString(7,contract.getServiceID());
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
