import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== POLICE TRAFFIC MANAGEMENT ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Search by Vehicle ID");
            System.out.println("3. Search by Owner CMND");
            System.out.println("4. Delete by Manufacturer");
            System.out.println("5. Find Manufacturer with most vehicles");
            System.out.println("6. Sort vehicles by ID (Descending)");
            System.out.println("7. Statistics by Type");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            try {
                String input = sc.nextLine();
                if (input.isEmpty()) continue;
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1: manager.addVehicle(); break;
                    case 2: manager.searchById(); break;
                    case 3: manager.searchByOwnerCccd(); break;
                    case 4: manager.deleteByManufacturer(); break;
                    case 5: manager.findTopManufacturer(); break;
                    case 6: manager.sortVehiclesDesc(); break;
                    case 7: manager.showStatistics(); break;
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default: System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}
