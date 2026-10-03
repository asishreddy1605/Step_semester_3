// Cart.java
public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    // Adds an item price to the cart if capacity permits
    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    // Computes and returns the sum of all item prices in the cart
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    // Read-only getter for the number of items added
    public int getItemCount() {
        return this.itemCount;
    }

    // Read-only getter for cart ID
    public String getCartId() {
        return this.cartId;
    }
}

// Main.java (Driver class for testing)
public class The_Shopping_Cart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total price: " + (int) cart.getTotal());   // 500
        System.out.println("Item count: " + cart.getItemCount());       // 3
    }
}