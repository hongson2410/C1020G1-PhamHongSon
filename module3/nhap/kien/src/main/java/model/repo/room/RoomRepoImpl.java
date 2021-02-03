package model.repo.room;

import model.bean.Room;
import model.bean.Villa;
import model.repo.BaseRepo;
import model.repo.FuramaRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRepoImpl implements FuramaRepository<Room> {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Room> findAll() {
        List<Room> roomList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call show_room()");

            ResultSet resultSet = callableStatement.executeQuery();

            Room room;
            while (resultSet.next()){
                room = new Room();
                room.setNameRoom(resultSet.getString("service_name"));
                room.setArea(resultSet.getDouble("service_area"));
                room.setMax_people(resultSet.getInt("service_max_people"));
                room.setCost(resultSet.getDouble("service_cost"));
                room.setFreeService(resultSet.getString("description_other_convenience"));
                roomList.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    @Override
    public Room selectById(String id) {
        Room room = new Room();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_service_id(?)");
            callableStatement.setString(1,id);

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            room.setNameRoom(resultSet.getString("service_name"));
            room.setArea(resultSet.getDouble("service_area"));
            room.setMax_people(resultSet.getInt("service_max_people"));
            room.setCost(resultSet.getDouble("service_cost"));
            room.setFreeService(resultSet.getString("description_other_convenience"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public void update(Room room) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call update_room(?,?,?,?,?,?)");
            callableStatement.setString(1,room.getIdService());
            callableStatement.setString(2,room.getNameRoom());
            callableStatement.setDouble(3,room.getArea());
            callableStatement.setInt(4,room.getMax_people());
            callableStatement.setDouble(5,room.getCost());
            callableStatement.setString(6,room.getFreeService());

            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Room> searchName(String name) {
        return null;
    }

    @Override
    public void add(Room room) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_room(?,?,?,?,?,?,?)");
            callableStatement.setInt(1,room.getIdRoom());
            callableStatement.setString(2,room.getNameRoom());
            callableStatement.setDouble(3,room.getArea());
            callableStatement.setInt(4,room.getMax_people());
            callableStatement.setDouble(5,room.getCost());
            callableStatement.setString(6,room.getFreeService());
            callableStatement.setString(7,room.getIdService());
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
