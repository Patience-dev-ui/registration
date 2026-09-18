/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration;

/**
 *
 * @author masho
 */
import java.util.Scanner;

public class Registration {

    private static String userName;
    private static String password;
    private static String cellPhoneNumber;
    private static String firstName;
    private static String lastName;

    public static void setFirstName(String fname) {
        firstName = fname;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setUserName(String username) {
        userName = username;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setPassword(String passw0rd) {
        password = passw0rd;
    }

    public static String getPassword() {
        return password;
    }

    public static void setLastname(String lname) {
        lastName = lname;
    }

    public static String getLastname() {
        return lastName;
    }

    public static void setCellNumber(String cellphonenumber) {
        cellPhoneNumber = cellphonenumber;
    }

    public static String getCellNumber() {
        return cellPhoneNumber;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login(firstName, lastName);

        System.out.println("*Registration*");

        System.out.print("Please enter your first name: ");
        firstName = input.nextLine();

        System.out.print("Please enter your last name: ");
        lastName = input.nextLine();

        System.out.print("Enter your username (less than 5 characters and must contain an underscore): ");
        userName = input.nextLine();

        System.out.print("Create a password (at least 8 characters, 1 capital letter, 1 number, 1 special character): ");
        password = input.nextLine();

        System.out.print("Please enter cellphone number with international country code: ");
        cellPhoneNumber = input.nextLine();

        String regStatus = login.registerUser(userName, password, cellPhoneNumber, firstName, lastName);
        System.out.println(regStatus);

        if (regStatus.equals("Registration successful.")) {
            System.out.println("*Login*");

            System.out.print("Enter the username you created: ");
            String loginUser = input.nextLine();

            System.out.print("Enter the password you created: ");
            String loginPass = input.nextLine();

            String loginStatus = login.returnLoginStatus(loginUser, loginPass);
            System.out.println(loginStatus);

        }

        input.close();
    }
}
