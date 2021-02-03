package model.bean;

public class AttachService {

    int idAttachService;
    String nameAttachService;
    double costAttachService;
    int unitAttachService;
    int idContract;

    public AttachService(){

    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public AttachService(int idAttachService, String nameAttachService, double costAttachService, int unitAttachService, int idContract) {
        this.idAttachService = idAttachService;
        this.nameAttachService = nameAttachService;
        this.costAttachService = costAttachService;
        this.unitAttachService = unitAttachService;
        this.idContract = idContract;
    }

    public int getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(int idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }

    public double getCostAttachService() {
        return costAttachService;
    }

    public void setCostAttachService(double costAttachService) {
        this.costAttachService = costAttachService;
    }

    public int getUnitAttachService() {
        return unitAttachService;
    }

    public void setUnitAttachService(int unitAttachService) {
        this.unitAttachService = unitAttachService;
    }
}
