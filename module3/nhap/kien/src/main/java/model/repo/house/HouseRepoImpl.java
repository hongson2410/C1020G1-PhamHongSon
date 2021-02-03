package model.repo.house;

import model.bean.House;
import model.bean.Villa;
import model.repo.BaseRepo;
import model.repo.FuramaRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseRepoImpl implements FuramaRepository<House> {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<House> findAll() {
        List<House> houseList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call show_house()");

            ResultSet resultSet = callableStatement.executeQuery();

            House house;
            while (resultSet.next()){
                house = new House();
                house.setNameHouse(resultSet.getString("service_name"));
                house.setArea(resultSet.getDouble("service_area"));
                house.setFloor(resultSet.getInt("number_of_floors"));
                house.setMax_people(resultSet.getInt("service_max_people"));
                house.setStandard_room(resultSet.getString("standard_room"));
                house.setCost(resultSet.getDouble("service_cost"));

                houseList.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return houseList;
    }

    @Override
    public House selectById(String id) {
        House house = new House();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_service_id(?)");
            callableStatement.setString(1,id);

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            house.setNameHouse(resultSet.getString("service_name"));
            house.setArea(resultSet.getDouble("service_area"));
            house.setStandard_room(resultSet.getString("standard_room"));
            house.setFloor(resultSet.getInt("number_of_floors"));
            house.setMax_people(resultSet.getInt("service_max_people"));
            house.setCost(resultSet.getDouble("service_cost"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return house;
    }

    @Override
    public void update(House house) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call update_house(?,?,?,?,?,?,?)");
            callableStatement.setString(1,house.getIdService());
            callableStatement.setString(2,house.getNameHouse());
            callableStatement.setString(3,house.getStandard_room());
            callableStatement.setDouble(4,house.getArea());
            callableStatement.setInt(5,house.getFloor());
            callableStatement.setInt(6,house.getMax_people());
            callableStatement.setDouble(7,house.getFloor());

            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<House> searchName(String name) {
        return null;
    }

    @Override
    public void add(House house) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_villa(?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1,house.getIdHouse());
            callableStatement.setString(2,house.getNameHouse());
            callableStatement.setString(3,house.getStandard_room());
            callableStatement.setDouble(4,house.getArea());
            callableStatement.setInt(6,house.getFloor());
            callableStatement.setInt(7,house.getMax_people());
            callableStatement.setDouble(8,house.getCost());
            callableStatement.setString(9,house.getIdService());
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
