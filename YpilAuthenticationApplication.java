import java.util.HashMap;
import java.util.Scanner;

public class YpilAuthenticationApplication {
    public static void main(String[] args) {
        // HashMap to store username and password pairs
        HashMap<String, String> userDatabase = new HashMap<>();

       //  Given username&password, so you can now log in.
        userDatabase.put("gianzkie", "gianzkie30");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--Authentication System--");

        // Function to display the options
        while (true) {
			System.out.println("\nSelect your choice");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose your choice(1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Login
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                        System.out.println("Login successfully! Welcome, " + username + "! My idol.");
                    } else {
                        System.out.println("Invalid username&password. Please try again.");
                    }
                    break;

                case 2:
                    // Register
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();

                    if (userDatabase.containsKey(newUsername)) {
                        System.out.println("Username already exists. Please choose a different one.");
                    } else {
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        userDatabase.put(newUsername, newPassword);
                        System.out.println("Registration successful! You can now log in.");
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("Thank you for trusting my application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
