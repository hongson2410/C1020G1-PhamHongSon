package model.service.room;

import model.bean.Room;
import model.repo.room.RoomRepoImpl;
import model.service.FuramaService;
import model.validate.ValidateFurama;

import java.util.List;

public class RoomService implements FuramaService<Room> {

    RoomRepoImpl roomRepo = new RoomRepoImpl();

    @Override
    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    @Override
    public Room selectById(String id) {
        return roomRepo.selectById(id);
    }

    @Override
    public void update(Room room) {
        roomRepo.update(room);
    }

    @Override
    public void delete(String id, String access) {

    }

    @Override
    public List<Room> searchByName(String name) {
        return null;
    }

    @Override
    public String add(Room room) {
        String name = room.getNameRoom();
        if(ValidateFurama.nameService(name)){
            roomRepo.add(room);
            return "OK";
        }else {
            return "Sai định dạng ID(DV-XXXX)";
        }
    }
}
