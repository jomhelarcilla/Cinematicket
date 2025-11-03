import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] users = new String[100][2];
        int userCount = 0;

        while (true) {
            System.out.println("\\n==== LOGIN SYSTEM ====");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter username: ");
                String username = input.nextLine();
                System.out.print("Enter password: ");
                String password = input.nextLine();

                boolean found = false;

                for (int i = 0; i < userCount; i++) {
                    if (users[i][0].equals(username) && users[i][1].equals(password)) {
                        System.out.println("Hello, " + username + "!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid username or password!");
                }
            } 
            else if (choice.equals("2")) {
                System.out.print("Enter username: ");
                String newUser = input.nextLine();

                boolean exists = false;
                for (int i = 0; i < userCount; i++) {
                    if (users[i][0].equals(newUser)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Username already exists!");
                } else {
                    System.out.print("Enter password: ");
                    String pass = input.nextLine();
                    System.out.print("Confirm password: ");
                    String confirm = input.nextLine();

                    if (!pass.equals(confirm)) {
                        System.out.println("Passwords do not match!");
                    } else {
                        users[userCount][0] = newUser;
                        users[userCount][1] = pass;
                        userCount++;
                        System.out.println("Registration successful!");
                    }
                }
            } 
            else if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
        }

        input.close();
    }
}