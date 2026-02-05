import java.time.LocalDate;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        QuanLyKho kho = new QuanLyKho(100);
        Scanner scanner = new Scanner(System.in);

        // --- DỮ LIỆU MẪU ĐỂ TEST ---
        // 1. Thực phẩm (Hết hạn để test "Khó bán")
        HangHoa tp1 = new HangThucPham("TP01", "Gạo ST25", 10, 25000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 6, 1), "VinEco");

        // 2. Điện máy (SL < 3 để test "Bán được")
        HangHoa dm1 = new HangDienMay("DM01", "Tủ lạnh LG", 2, 8000000, 24, 200);

        // 3. Sành sứ (SL > 50 và nhập lâu để test "Bán chậm")
        HangHoa ss1 = new HangSanhSu("SS01", "Bình hoa", 60, 150000, "Bát Tràng", LocalDate.of(2023, 1, 1));

        kho.themHangHoa(tp1);
        kho.themHangHoa(dm1);
        kho.themHangHoa(ss1);

        // --- MENU NHẬP LIỆU THỦ CÔNG ---
        int choice = 0;

        do {
            System.out.println("\n--- MENU QUẢN LÝ KHO ---");
            System.out.println("1. Thêm Hàng Thực Phẩm");
            System.out.println("2. Thêm Hàng Điện Máy");
            System.out.println("3. Thêm Hàng Sành Sứ");
            System.out.println("4. Xem Danh Sách & Đánh Giá");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (choice >= 1 && choice <= 3) {
                System.out.print("Nhập mã hàng: "); String ma = scanner.nextLine();
                System.out.print("Nhập tên hàng: "); String ten = scanner.nextLine();
                System.out.print("Số lượng tồn: "); int sl = scanner.nextInt();
                System.out.print("Đơn giá: "); double gia = scanner.nextDouble();
                scanner.nextLine();

                HangHoa hh = null;

                switch (choice) {
                    case 1:
                        System.out.println("Nhập ngày SX (yyyy-mm-dd): ");
                        LocalDate nsx = LocalDate.parse(scanner.nextLine());
                        System.out.println("Nhập ngày HH (yyyy-mm-dd): ");
                        LocalDate nhh = LocalDate.parse(scanner.nextLine());
                        System.out.print("Nhà cung cấp: "); String ncc = scanner.nextLine();
                        hh = new HangThucPham(ma, ten, sl, gia, nsx, nhh, ncc);
                        break;
                    case 2:
                        System.out.print("Bảo hành (tháng): "); int bh = scanner.nextInt();
                        System.out.print("Công suất (KW): "); double kw = scanner.nextDouble();
                        hh = new HangDienMay(ma, ten, sl, gia, bh, kw);
                        break;
                    case 3:
                        System.out.print("Nhà sản xuất: "); String nsxSS = scanner.nextLine();
                        System.out.println("Ngày nhập (yyyy-mm-dd): ");
                        LocalDate nnk = LocalDate.parse(scanner.nextLine());
                        hh = new HangSanhSu(ma, ten, sl, gia, nsxSS, nnk);
                        break;
                }

                if (kho.themHangHoa(hh)) {
                    System.out.println("Thêm thành công!");
                }
            } else if (choice == 4) {
                kho.inDanhSach();
            }

        } while (choice != 0);

        scanner.close();
    }
}
