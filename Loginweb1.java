import java.util.Scanner;

public class Loginweb1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome , it is great to see you");

        System.out.println("Enter Username: ");
        String username = sc.nextLine();

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = sc.nextLine();

        Login login = new Login(username, password);
        String registrationMessage = login.registerUser();
        System.out.println(registrationMessage);
        if (registrationMessage.equals("login successfully")) {
            System.out.println("+");
        }

        if (registrationMessage.equals("Registration successful.")) {
            System.out.println("\nLogin:");
            System.out.print("Enter Username: ");
            String loginUsername = sc.nextLine();
            System.out.print("Enter Password: ");
            String loginPassword = sc.nextLine();

            // Verify login credentials and provide appropriate message
            if (login.loginUser(loginUsername, loginPassword)) {
                System.out.println("A successful login");
            } else {
                System.out.println("A failed login");
            }
        }

        sc.close();
    }
}

class Login {
    private String username;

    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[0-9]*.") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[@#$%^&+=].*");
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) { // Pass the password as an argument here
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        return "Registration successful.";
    }

    public boolean loginUser(String username, String password) {
        return username.matches(username) && password.matches(password);
    }

}