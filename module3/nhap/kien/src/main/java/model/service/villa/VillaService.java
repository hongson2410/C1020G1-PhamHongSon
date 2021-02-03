package model.service.villa;

import model.bean.Villa;
import model.repo.villa.VillaRepoImpl;
import model.service.FuramaService;
import model.validate.ValidateFurama;

import java.util.List;

public class VillaService implements FuramaService<Villa> {

    VillaRepoImpl villaRepo = new VillaRepoImpl();

    @Override
    public List<Villa> findAll() {
        return villaRepo.findAll();
    }

    @Override
    public Villa selectById(String id) {
        return villaRepo.selectById(id);
    }

    @Override
    public void update(Villa villa) {
        villaRepo.update(villa);
    }

    @Override
    public void delete(String id, String access) {

    }

    @Override
    public List<Villa> searchByName(String name) {
        return null;
    }

    @Override
    public String add(Villa villa) {
        String idService = villa.getIdService();
        String floor = String.valueOf(villa.getFloor());
        if (!ValidateFurama.nameService(idService)) {
            return "Định dạng ID(DV-XXXX)";
        } else {
            villaRepo.add(villa);
            return "OK";
        }
    }
}
