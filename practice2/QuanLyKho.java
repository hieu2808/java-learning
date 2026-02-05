public class QuanLyKho {
    private HangHoa[] danhSachHangHoa;
    private int soLuongHienTai;

    public QuanLyKho(int kichThuocToiDa) {
        danhSachHangHoa = new HangHoa[kichThuocToiDa];
        soLuongHienTai = 0;
    }

    public boolean kiemTraTrungMa(String maHang) {
        for (int i = 0; i < soLuongHienTai; i++) {
            if (danhSachHangHoa[i].getMaHang().equalsIgnoreCase(maHang)) {
                return true; // Đã tồn tại
            }
        }
        return false;
    }

    public boolean themHangHoa(HangHoa h) {
        if (soLuongHienTai >= danhSachHangHoa.length) {
            System.out.println("Kho đã đầy, không thể thêm!");
            return false;
        }
        if (kiemTraTrungMa(h.getMaHang())) {
            System.out.println("Mã hàng " + h.getMaHang() + " đã tồn tại!");
            return false;
        }
        danhSachHangHoa[soLuongHienTai] = h;
        soLuongHienTai++;
        return true;
    }

    public void inDanhSach() {
        System.out.println("-".repeat(150));
        System.out.printf("%-10s %-20s %-10s %-15s %-10s %-50s %-15s\n",
                "Mã", "Tên", "SL Tồn", "Đơn giá", "VAT", "Thông tin khác", "Đánh giá");
        System.out.println("-".repeat(150));
        for (int i = 0; i < soLuongHienTai; i++) {
            System.out.print(danhSachHangHoa[i].toString());
            System.out.println("   --> " + danhSachHangHoa[i].danhGiaMucDoBuonBan());
        }
        System.out.println("-".repeat(150));
    }
}
