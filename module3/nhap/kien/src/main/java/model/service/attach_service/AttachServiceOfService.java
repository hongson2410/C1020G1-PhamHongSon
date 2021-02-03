package model.service.attach_service;

import model.bean.AttachService;
import model.repo.attach_service.AttachServiceImpl;
import model.service.FuramaService;

import java.util.List;

public class AttachServiceOfService implements FuramaService<AttachService> {

    AttachServiceImpl attachServiceImpl = new AttachServiceImpl();


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

        attachServiceImpl.add(attachService);
        return "";
    }
}
