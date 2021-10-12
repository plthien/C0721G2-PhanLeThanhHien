package models;

public class SoTietKiemDaiHan extends SoTietKiemVoThoiHan {
    private int kyHan;
    private String uuDai;

    public SoTietKiemDaiHan() {
    }

    public SoTietKiemDaiHan(String maSo, String maKhachHang, String ngayMoSo, String ngayGui, double soTienGui, double laiSuat, int kyHan, String uuDai) {
        super(maSo, maKhachHang, ngayMoSo, ngayGui, soTienGui, laiSuat);
        this.kyHan = kyHan;
        this.uuDai = uuDai;
    }

    public void setKyHan() {
        do {
            try {
                System.out.println("Chon Ky Han: 1. 1 nam\t2. 3 nam\t3. 5 nam\t4. 10 nam ");
                this.kyHan = Integer.parseInt(sc.nextLine());
                if (this.kyHan < 1 || this.kyHan > 4) {
                    System.out.println("Chon Lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chon Lai!");
            }
        } while (this.kyHan < 1 || this.kyHan > 4);
    }

    public String getKyHan() {
        switch (this.kyHan) {
            case 1:
                return "1 nam";
            case 2:
                return "3 nam";
            case 3:
                return "5 nam";
            case 4:
                return "10 nam";
            default:
                return "";
        }
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai() {
        System.out.println("Nhap uu dai: ");
        this.uuDai = sc.nextLine();
    }

    @Override
    public String toString() {
        return "SoTietKiemDaiHan{" +
                "maSo='" + super.getMaSo() +
                ", maKhachHang='" + super.getMaKhachHang() +
                ", ngayMoSo='" + super.getNgayMoSo() +
                ", ngayGui='" + super.getNgayGui() +
                ", soTienGui=" + super.getSoTienGui() +
                ", laiSuat=" + super.getLaiSuat() +
                "kyHan='" + this.getKyHan() +
                ", uuDai='" + uuDai +
                '}';
    }

    public String layThongTin() {
        return super.getMaSo() + "," + super.getMaKhachHang() + "," + super.getNgayMoSo() + "," + super.getNgayGui() + "," +
                super.getSoTienGui() + "," + super.getLaiSuat() + "," + this.getKyHan() + "," + this.uuDai;
    }
}
