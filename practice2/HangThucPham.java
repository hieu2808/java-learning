import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia,
                        LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.nhaCungCap = nhaCungCap;
        setNgayHetHan(ngayHetHan);
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan.isAfter(ngaySanXuat) || ngayHetHan.isEqual(ngaySanXuat)) {
            this.ngayHetHan = ngayHetHan;
        } else {
            System.out.println("Ngày hết hạn phải sau hoặc bằng ngày sản xuất!");
            this.ngayHetHan = LocalDate.now();
        }
    }

    @Override
    public double getVAT() {
        return donGia * 0.05;
    }

    @Override
    public String danhGiaMucDoBuonBan() {
        if (soLuongTon > 0 && LocalDate.now().isAfter(ngayHetHan)) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + String.format(" %-15s %-20s %-11s",
                ngaySanXuat.format(dtf), ngayHetHan.format(dtf), nhaCungCap);
    }
}
