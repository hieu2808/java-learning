public class Car extends Vehicle {
    private int seats;
    private String engineType;

    public Car(String id, String manufacturer, int year, String color, Owner owner, int seats, String engineType) {
        super(id, manufacturer, year, color, owner);
        this.seats = seats;
        this.engineType = engineType;
    }

    @Override
    public void showInfo() {
        System.out.println("CAR | ID: " + id + " | Maker: " + manufacturer + " | Year: " + year +
                " | Color: " + color + " | Seats: " + seats + " | Engine: " + engineType);
        System.out.println("\t-> " + owner.toString());
    }
}
