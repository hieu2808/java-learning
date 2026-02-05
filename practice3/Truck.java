public class Truck extends Vehicle {
    private double tonnage;

    public Truck(String id, String manufacturer, int year, String color, Owner owner, double tonnage) {
        super(id, manufacturer, year, color, owner);
        this.tonnage = tonnage;
    }

    @Override
    public void showInfo() {
        System.out.println("TRUCK | ID: " + id + " | Maker: " + manufacturer + " | Year: " + year +
                " | Color: " + color + " | Tonnage: " + tonnage);
        System.out.println("\t-> " + owner.toString());
    }
}
