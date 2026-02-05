public class Motorbike extends Vehicle {
    private double capacity;

    public Motorbike(String id, String manufacturer, int year, String color, Owner owner, double capacity) {
        super(id, manufacturer, year, color, owner);
        this.capacity = capacity;
    }

    @Override
    public void showInfo() {
        System.out.println("MOTORBIKE | ID: " + id + " | Maker: " + manufacturer + " | Year: " + year +
                " | Color: " + color + " | Capacity: " + capacity);
        System.out.println("\t-> " + owner.toString());
    }
}
