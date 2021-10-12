package models;

public class SoTietKiemCoHan extends SoTietKiemVoThoiHan {
    private int kyHan;

    public SoTietKiemCoHan() {
    }

    public SoTietKiemCoHan(String maSo, String maKhachHang, String ngayMoSo, String ngayGui, double soTienGui, double laiSuat, int kyHan) {
        super(maSo, maKhachHang, ngayMoSo, ngayGui, soTienGui, laiSuat);
        this.kyHan = kyHan;
    }


    public String getKyHan() {
        switch (this.kyHan) {
            case 1:
                return "3 thang";
            case 2:
                return "6 thang";
            default:
                return "";
        }
    }

    public void setKyHan() {
        do {
            try {
                System.out.println("Chon Ky Han: 1. 3 thang\t2. 6 thang");
                this.kyHan = Integer.parseInt(sc.nextLine());
                if (this.kyHan < 1 || this.kyHan > 2) {
                    System.out.println("Chon Lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chon Lai!");
            }
        } while (this.kyHan < 1 || this.kyHan > 2);
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
                ", kyHan='" + this.getKyHan() +
                '}';
    }

    public String layThongTin() {
        return super.getMaSo() + "," + super.getMaKhachHang() + "," + super.getNgayMoSo() + "," + super.getNgayGui() + "," +
                super.getSoTienGui() + "," + super.getLaiSuat() + "," + this.getKyHan();
    }
}
