import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {
    public static final Scanner sc = new Scanner(System.in);

    public static String inputId(List<Vehicle> list) {
        while (true) {
            System.out.print("Enter Vehicle ID (5 chars): ");
            String id = sc.nextLine().trim();
            if (id.length() != 5) {
                System.out.println("Error: ID must be exactly 5 characters.");
                continue;
            }
            boolean exists = false;
            for (Vehicle v : list) {
                if (v.getId().equalsIgnoreCase(id)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("Error: ID already exists.");
            } else {
                return id;
            }
        }
    }

    public static String inputManufacturer() {
        List<String> validMakers = Arrays.asList("Honda", "Yamaha", "Toyota", "Suzuki");
        while (true) {
            System.out.print("Enter Manufacturer (Honda, Yamaha, Toyota, Suzuki): ");
            String maker = sc.nextLine().trim();
            String formattedMaker = maker.substring(0, 1).toUpperCase() + maker.substring(1).toLowerCase();

            if (validMakers.contains(formattedMaker)) {
                return formattedMaker;
            }
            System.out.println("Error: Invalid manufacturer.");
        }
    }

    public static int inputYear() {
        int currentYear = Year.now().getValue();
        while (true) {
            try {
                System.out.print("Enter Year of Manufacture (>2000): ");
                int year = Integer.parseInt(sc.nextLine().trim());
                if (year > 2000 && year <= currentYear) {
                    return year;
                }
                System.out.println("Error: Year must be > 2000 and <= " + currentYear);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number.");
            }
        }
    }

    public static String inputCCCD() {
        while (true) {
            System.out.print("Enter Owner CCCD (12 digits): ");
            String cccd = sc.nextLine().trim();
            if (cccd.matches("\\d{12}")) {
                return cccd;
            }
            System.out.println("Error: CCCD must be exactly 12 digits.");
        }
    }

    public static String inputEmail() {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        while (true) {
            System.out.print("Enter Owner Email: ");
            String email = sc.nextLine().trim();
            if (Pattern.matches(emailRegex, email)) {
                return email;
            }
            System.out.println("Error: Invalid email format.");
        }
    }
}
