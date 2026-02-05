import java.util.*;

public class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();

    // 1. Thêm phương tiện
    public void addVehicle() {
        System.out.println("\n--- ADD NEW VEHICLE ---");
        System.out.println("1. Car  2. Motorbike  3. Truck");
        System.out.print("Choose type: ");
        int type;
        try {
            type = Integer.parseInt(InputValidator.sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        String id = InputValidator.inputId(vehicles);
        String maker = InputValidator.inputManufacturer();
        int year = InputValidator.inputYear();
        System.out.print("Enter Color: ");
        String color = InputValidator.sc.nextLine();

        System.out.println("--- Owner Info ---");
        String cccd = InputValidator.inputCCCD();
        System.out.print("Enter Full Name: ");
        String name = InputValidator.sc.nextLine();
        String email = InputValidator.inputEmail();
        Owner owner = new Owner(cccd, name, email);

        switch (type) {
            case 1:
                System.out.print("Enter Seats: ");
                int seats = Integer.parseInt(InputValidator.sc.nextLine());
                System.out.print("Enter Engine Type: ");
                String engine = InputValidator.sc.nextLine();
                vehicles.add(new Car(id, maker, year, color, owner, seats, engine));
                break;
            case 2:
                System.out.print("Enter Capacity: ");
                double cap = Double.parseDouble(InputValidator.sc.nextLine());
                vehicles.add(new Motorbike(id, maker, year, color, owner, cap));
                break;
            case 3:
                System.out.print("Enter Tonnage: ");
                double ton = Double.parseDouble(InputValidator.sc.nextLine());
                vehicles.add(new Truck(id, maker, year, color, owner, ton));
                break;
            default:
                System.out.println("Invalid type!");
        }
        System.out.println("Added successfully!");
    }

    // 2. Tìm theo ID
    public void searchById() {
        System.out.print("Enter Vehicle ID to search: ");
        String searchId = InputValidator.sc.nextLine();
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getId().equalsIgnoreCase(searchId)) {
                v.showInfo();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Vehicle not found.");
    }

    // 3. Tìm theo CMND
    public void searchByOwnerCccd() {
        System.out.print("Enter Owner CCCD to search: ");
        String searchCccd = InputValidator.sc.nextLine();
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getOwner().getCccd().equals(searchCccd)) {
                v.showInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No vehicles found for this CCCD.");
    }

    // 4. Xóa theo hãng
    public void deleteByManufacturer() {
        System.out.print("Enter Manufacturer to delete all vehicles: ");
        String maker = InputValidator.sc.nextLine();
        boolean removed = vehicles.removeIf(v -> v.getManufacturer().equalsIgnoreCase(maker));
        if (removed) System.out.println("Deleted all vehicles from " + maker);
        else System.out.println("No vehicles found from " + maker);
    }

    // 5. Hãng nhiều xe nhất
    public void findTopManufacturer() {
        if (vehicles.isEmpty()) {
            System.out.println("No data.");
            return;
        }
        Map<String, Integer> countMap = new HashMap<>();
        for (Vehicle v : vehicles) {
            countMap.put(v.getManufacturer(), countMap.getOrDefault(v.getManufacturer(), 0) + 1);
        }

        int max = 0;
        for (int val : countMap.values()) {
            if (val > max) max = val;
        }

        System.out.print("Manufacturer(s) with most vehicles (" + max + "): ");
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }

    // 6. Sắp xếp giảm dần
    public void sortVehiclesDesc() {
        Collections.sort(vehicles);
        System.out.println("List sorted by ID (Descending):");
        for (Vehicle v : vehicles) {
            v.showInfo();
        }
    }

    // 7. Thống kê
    public void showStatistics() {
        int carCount = 0, motoCount = 0, truckCount = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) carCount++;
            else if (v instanceof Motorbike) motoCount++;
            else if (v instanceof Truck) truckCount++;
        }
        System.out.println("--- Statistics ---");
        System.out.println("Cars: " + carCount);
        System.out.println("Motorbikes: " + motoCount);
        System.out.println("Trucks: " + truckCount);
    }
}
