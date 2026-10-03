// TrafficLight.java
public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Default starting color
    }

    // Cycles through colors in exact order: RED -> GREEN -> YELLOW -> RED
    public void next() {
        if ("RED".equals(this.color)) {
            this.color = "GREEN";
        } else if ("GREEN".equals(this.color)) {
            this.color = "YELLOW";
        } else if ("YELLOW".equals(this.color)) {
            this.color = "RED";
        }
    }

    // Read-only getter for current color
    public String getColor() {
        return this.color;
    }

    // Read-only getter for light ID
    public String getId() {
        return this.id;
    }
}

// Main.java (Driver class for testing)
public class The_Traffic_Light {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("Initial color: " + t.getColor()); // RED

        t.next();
        System.out.println("After 1st next(): " + t.getColor()); // GREEN

        t.next();
        System.out.println("After 2nd next(): " + t.getColor()); // YELLOW

        t.next();
        System.out.println("After 3rd next(): " + t.getColor()); // RED
    }
}