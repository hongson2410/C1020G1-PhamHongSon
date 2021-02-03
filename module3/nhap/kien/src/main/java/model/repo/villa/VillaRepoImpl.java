package model.repo.villa;

import model.bean.Employee;
import model.bean.Villa;
import model.repo.BaseRepo;
import model.repo.FuramaRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VillaRepoImpl implements FuramaRepository<Villa> {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Villa> findAll() {
        List<Villa> villaList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call show_villa()");

            ResultSet resultSet = callableStatement.executeQuery();

            Villa villa;
            while (resultSet.next()){
                villa = new Villa();
                villa.setNameVilla(resultSet.getString("service_name"));
                villa.setArea(resultSet.getDouble("service_area"));
                villa.setPool_area(resultSet.getDouble("pool_area"));
                villa.setFloor(resultSet.getInt("number_of_floors"));
                villa.setMax_people(resultSet.getInt("service_max_people"));
                villa.setStandard_room(resultSet.getString("standard_room"));
                villa.setCost(resultSet.getDouble("service_cost"));

                villaList.add(villa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return villaList;
    }

    @Override
    public Villa selectById(String id) {
        Villa villa = new Villa();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_service_id(?)");
            callableStatement.setString(1,id);

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            villa.setNameVilla(resultSet.getString("service_name"));
            villa.setArea(resultSet.getDouble("service_area"));
            villa.setPool_area(resultSet.getDouble("pool_area"));
            villa.setStandard_room(resultSet.getString("standard_room"));
            villa.setFloor(resultSet.getInt("number_of_floors"));
            villa.setMax_people(resultSet.getInt("service_max_people"));
            villa.setCost(resultSet.getDouble("service_cost"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return villa;
    }

    @Override
    public void update(Villa villa) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call update_villa(?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,villa.getIdService());
            callableStatement.setString(2,villa.getNameVilla());
            callableStatement.setString(3,villa.getStandard_room());
            callableStatement.setDouble(4,villa.getArea());
            callableStatement.setDouble(5,villa.getPool_area());
            callableStatement.setInt(6,villa.getFloor());
            callableStatement.setInt(7,villa.getMax_people());
            callableStatement.setDouble(8,villa.getCost());

            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Villa> searchName(String name) {
        return null;
    }

    @Override
    public void add(Villa villa) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_villa(?,?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1,villa.getIdVilla());
            callableStatement.setString(2,villa.getNameVilla());
            callableStatement.setString(3,villa.getStandard_room());
            callableStatement.setDouble(4,villa.getArea());
            callableStatement.setDouble(5,villa.getPool_area());
            callableStatement.setInt(6,villa.getFloor());
            callableStatement.setInt(7,villa.getMax_people());
            callableStatement.setDouble(8,villa.getCost());
            callableStatement.setString(9,villa.getIdService());
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
