package model.service.contract;

import model.bean.Contract;
import model.repo.contract.ContractRepoImpl;
import model.service.FuramaService;

import java.util.List;

public class ContractService implements FuramaService<Contract> {

    ContractRepoImpl contractRepo = new ContractRepoImpl();

    @Override
    public List<Contract> findAll() {
        return contractRepo.findAll();
    }

    @Override
    public Contract selectById(String id) {
        return null;
    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public void delete(String id, String access) {

    }

    @Override
    public List<Contract> searchByName(String name) {
        return null;
    }

    @Override
    public String add(Contract contract) {
        contractRepo.add(contract);
        return "";
    }
}
