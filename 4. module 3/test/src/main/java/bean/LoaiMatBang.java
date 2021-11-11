package bean;

public class LoaiMatBang {
    private String id;
    private String ten;

    public LoaiMatBang() {
    }

    public LoaiMatBang(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
