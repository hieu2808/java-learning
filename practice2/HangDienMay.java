public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia,
                       int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);

        if(thoiGianBaoHanh >= 0) this.thoiGianBaoHanh = thoiGianBaoHanh;
        else this.thoiGianBaoHanh = 0;

        if(congSuat >= 0) this.congSuat = congSuat;
        else this.congSuat = 0;
    }

    @Override
    public double getVAT() {
        return donGia * 0.10;
    }

    @Override
    public String danhGiaMucDoBuonBan() {
        if (soLuongTon < 3) {
            return "Bán được";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-15d %-30fKW", thoiGianBaoHanh, congSuat);
    }
}
