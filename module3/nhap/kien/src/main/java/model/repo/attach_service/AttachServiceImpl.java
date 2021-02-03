package model.repo.attach_service;

import model.bean.AttachService;
import model.repo.BaseRepo;
import model.service.FuramaService;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

public class AttachServiceImpl implements FuramaService<AttachService> {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<AttachService> findAll() {
        return null;
    }

    @Override
    public AttachService selectById(String id) {
        return null;
    }

    @Override
    public void update(AttachService attachService) {

    }

    @Override
    public void delete(String id, String access) {

    }

    @Override
    public List<AttachService> searchByName(String name) {
        return null;
    }

    @Override
    public String add(AttachService attachService) {

        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call create_attach_service(?,?,?,?)");
            callableStatement.setInt(1,attachService.getIdAttachService());
            callableStatement.setString(2,attachService.getNameAttachService());
            callableStatement.setDouble(3,attachService.getCostAttachService());
            callableStatement.setInt(4,attachService.getUnitAttachService());

            callableStatement.executeQuery();

            CallableStatement callableStatement2 =
                    baseRepo.getConnection().prepareCall("call create_contract_detail(?,?,?)");
            callableStatement2.setInt(1,attachService.getIdAttachService());
            callableStatement2.setInt(2,attachService.getIdContract());
            callableStatement2.setInt(3,attachService.getIdAttachService());


            callableStatement2.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
