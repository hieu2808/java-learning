import java.text.DecimalFormat;

public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        setSoLuongTon(soLuongTon);
        this.donGia = donGia;
    }

    public HangHoa() {
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon >= 0) {
            this.soLuongTon = soLuongTon;
        } else {
            System.out.println("Số lượng tồn phải >= 0. Mặc định là 0.");
            this.soLuongTon = 0;
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            System.out.println("Đơn giá phải > 0.");
        }
    }

    public abstract double getVAT();
    public abstract String danhGiaMucDoBuonBan();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%-10s %-20s %-10d %-15s %-10s",
                maHang, tenHang, soLuongTon, df.format(donGia), df.format(getVAT()));
    }
}
