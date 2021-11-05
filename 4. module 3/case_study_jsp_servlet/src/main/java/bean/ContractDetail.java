package bean;

public class ContractDetail {
    private int id;
    private Contract contract;
    private ExtraService extraService;
    private  int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, Contract contract, ExtraService extraService, int quantity) {
        this.id = id;
        this.contract = contract;
        this.extraService = extraService;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
