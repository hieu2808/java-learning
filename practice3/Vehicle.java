public abstract class Vehicle implements Comparable<Vehicle> {
    protected String id;
    protected String manufacturer;
    protected int year;
    protected String color;
    protected Owner owner;

    public Vehicle(String id, String manufacturer, int year, String color, Owner owner) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.year = year;
        this.color = color;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Owner getOwner() {
        return owner;
    }

    public abstract void showInfo();

    @Override
    public int compareTo(Vehicle other) {
        return other.id.compareTo(this.id); // Sắp xếp giảm dần theo ID
    }
}
