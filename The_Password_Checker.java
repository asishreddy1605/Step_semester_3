// PasswordChecker.java
public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    // Calculates and reveals only the strength rating based on length
    public String getStrength() {
        if (password == null) {
            return "Weak";
        }

        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

// Main.java (Driver class for testing)
public class The_Password_Checker {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc1 strength: " + pc1.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("pc2 strength: " + pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("pc3 strength: " + pc3.getStrength()); // Strong
    }
}