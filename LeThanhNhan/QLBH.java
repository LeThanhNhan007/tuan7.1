package LeThanhNhan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class QLBH<T> {
    private List<T> danhSach;

    // Khởi tạo danh sách
    public QLBH() {
        this.danhSach = new ArrayList<>();
    }

    // Thêm 1 phần tử
    public boolean them(T item) {
        return this.danhSach.add(item);
    }

    // Thêm nhiều phần tử cùng lúc (Varargs T... items)
    @SafeVarargs
    public final void themNhieu(T... items) {
        Collections.addAll(this.danhSach, items);
    }

    // Đếm số lượng phần tử thỏa điều kiện Predicate (Lambda)
    public int dem(Predicate<T> p) {
        int count = 0;
        for (T item : danhSach) {
            if (p.test(item)) {
                count++;
            }
        }
        return count;
    }

    // Lọc ra danh sách các phần tử thỏa điều kiện
    public List<T> loc(Predicate<T> p) {
        List<T> kq = new ArrayList<>();
        for (T item : danhSach) {
            if (p.test(item)) {
                kq.add(item);
            }
        }
        return kq;
    }

    // In toàn bộ danh sách
    public void xuat() {
        for (T item : danhSach) {
            System.out.println(item);
        }
    }

    // Hàm main thực thi chương trình
    public static void main(String[] args) {
        QLBH<KhachHang> ql = new QLBH<>();

        ql.themNhieu(
            new KhachHangVietNam("VN01", "Nguyen Van A", LocalDate.of(2018, 9, 10), 100, 1500, "sinh hoạt", 50),
            new KhachHangVietNam("VN02", "Tran Thi B", LocalDate.of(2018, 10, 5), 200, 2000, "kinh doanh", 100),
            new KhachHangVietNam("VN03", "Le Van C", LocalDate.of(2019, 1, 20), 80, 1800, "sản xuất", 60),
            new KhachHangNuocNgoai("NN01", "John Smith", LocalDate.of(2018, 9, 25), 150, 2500, "Mỹ"),
            new KhachHangNuocNgoai("NN02", "Yuki Tanaka", LocalDate.of(2018, 8, 15), 120, 3000, "Nhật"),
            new KhachHangNuocNgoai("NN03", "Kim Min Su", LocalDate.of(2019, 3, 8), 90, 2800, "Hàn")
        );

        // 1. Xuất danh sách
        System.out.println("=== DANH SÁCH HÓA ĐƠN ===");
        ql.xuat();

        // 2. Đếm số lượng
        System.out.println("\n=== THỐNG KÊ ===");
        System.out.println("VN: " + ql.dem(kh -> kh instanceof KhachHangVietNam));
        System.out.println("NN: " + ql.dem(kh -> kh instanceof KhachHangNuocNgoai));
    }
}