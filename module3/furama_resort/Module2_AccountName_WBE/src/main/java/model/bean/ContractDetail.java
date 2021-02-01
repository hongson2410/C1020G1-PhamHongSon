package model.bean;

public class ContractDetail {
    private Integer contract_detail_id;
    private Integer contract_id;
    private Integer attach_service_id;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(Integer contract_id, Integer attach_service_id, int quantity) {
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public ContractDetail(Integer contract_detail_id, Integer contract_id, Integer attach_service_id, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public Integer getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(Integer contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public Integer getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(Integer attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
