import java.util.Scanner;

class Shape {
    double width, height;
    public Shape(double w, double h) { this.width = w; this.height = h; }
}

class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class Circle extends Shape {
    public Circle(double diameter) {
        super(diameter, diameter);
    }

    public double getArea() {
        double radius = width / 2;
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return Math.PI * width;
    }
}


public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU QUẢN LÝ HÌNH HỌC =====");
            System.out.println("1. Tính Hình Chữ Nhật");
            System.out.println("2. Tính Hình Tròn");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập chiều rộng: ");
                    double width = sc.nextDouble();
                    System.out.print("Nhập chiều cao: ");
                    double height = sc.nextDouble();
                    Rectangle r = new Rectangle(width, height);
                    System.out.println("Diện tích: " + r.getArea());
                    System.out.println("Chu vi: " + r.getPerimeter());
                    break;
                case 2:
                    System.out.print("Nhập đường kính: ");
                    double d = sc.nextDouble();
                    Circle circ = new Circle(d);
                    System.out.printf("-> Diện tích: %.2f\n", circ.getArea());
                    System.out.println("-> Chu vi: " + circ.getCircumference());
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);

        sc.close();
    }
}
