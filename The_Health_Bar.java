
public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; 
    }
    public void takeDamage(int amount) {
        if (amount <= 0) return; 
        this.currentHealth -= amount;
        if (this.currentHealth < 0) {
            this.currentHealth = 0; 
        }
    }
    public void heal(int amount) {
        if (amount <= 0) return; 
        this.currentHealth += amount;
        if (this.currentHealth > maxHealth) {
            this.currentHealth = maxHealth; 
        }
    }
    public int getHealth() {
        return this.currentHealth;
    }
    public int getMaxHealth() {
        return this.maxHealth;
    }
}
public class The_Health_Bar {
    public static void main(String[] args) {
        Character c = new Character(100);
        System.out.println("Initial health: " + c.getHealth());
        c.takeDamage(30);
        System.out.println("After taking 30 damage: " + c.getHealth()); 
        c.heal(50);
        System.out.println("After healing 50: " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After taking 150 damage: " + c.getHealth());
    }
}