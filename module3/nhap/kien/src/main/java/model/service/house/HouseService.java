package model.service.house;

import model.bean.House;
import model.repo.house.HouseRepoImpl;
import model.service.FuramaService;
import model.validate.ValidateFurama;

import java.util.List;

public class HouseService implements FuramaService<House> {

    HouseRepoImpl houseRepo = new HouseRepoImpl();

    @Override
    public List<House> findAll() {
        return houseRepo.findAll();
    }

    @Override
    public House selectById(String id) {
        return houseRepo.selectById(id);
    }

    @Override
    public void update(House house) {
        houseRepo.update(house);
    }

    @Override
    public void delete(String id, String access) {

    }

    @Override
    public List<House> searchByName(String name) {
        return null;
    }

    @Override
    public String add(House house) {
        String name = house.getNameHouse();
        if(ValidateFurama.nameService(name)){
            houseRepo.add(house);
            return "OK";
        }else {
            return "Sai định dạng ID(DV-XXXX)";
        }
    }
}
