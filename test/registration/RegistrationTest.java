
package registration;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationTest {

    // ==============================
    // REGISTRATION CLASS TESTS
    // ==============================

    @Test
    public void testFirstName() {
        Registration.setFirstName("John");

        assertEquals("John", Registration.getFirstName());
    }

    @Test
    public void testUserName() {
        Registration.setUserName("jo_n");

        assertEquals("jo_n", Registration.getUserName());
    }

    @Test
    public void testPassword() {
        Registration.setPassword("Password1!");

        assertEquals("Password1!", Registration.getPassword());
    }

    @Test
    public void testLastname() {
        Registration.setLastname("Doe");

        assertEquals("Doe", Registration.getLastname());
    }

    @Test
    public void testCellNumber() {
        Registration.setCellNumber("+27773456286");

        assertEquals(
                "+27773456286",
                Registration.getCellNumber()
        );
    }


    // ==============================
    // LOGIN CLASS TESTS
    // ==============================

    @Test
    public void testCheckUserNameValid() {
        Login login = new Login("John", "Doe");

        assertTrue(login.checkUserName("jo_n"));
    }

    @Test
    public void testCheckUserNameNoUnderscore() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkUserName("john"));
    }

    @Test
    public void testCheckUserNameTooLong() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkUserName("john_doe"));
    }


    // ==============================
    // PASSWORD TESTS
    // ==============================

    @Test
    public void testCheckPasswordComplexityValid() {
        Login login = new Login("John", "Doe");

        assertTrue(login.checkPasswordComplexity("Password1!"));
    }

    @Test
    public void testCheckPasswordNoCapital() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkPasswordComplexity("password1!"));
    }

    @Test
    public void testCheckPasswordNoNumber() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkPasswordComplexity("Password!"));
    }

    @Test
    public void testCheckPasswordNoSpecialCharacter() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkPasswordComplexity("Password1"));
    }

    @Test
    public void testCheckPasswordTooShort() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkPasswordComplexity("Pass1!"));
    }


    // ==============================
    // CELL PHONE TESTS
    // ==============================

    @Test
    public void testCheckCellPhoneNumberValid() {
        Login login = new Login("John", "Doe");

        assertTrue(login.checkCellPhoneNumber("+27773456286"));
    }

    @Test
    public void testCheckCellPhoneNumberNoInternationalCode() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkCellPhoneNumber("0773456286"));
    }

    @Test
    public void testCheckCellPhoneNumberWithLetters() {
        Login login = new Login("John", "Doe");

        assertFalse(login.checkCellPhoneNumber("+27773456ABC"));
    }


    // ==============================
    // REGISTRATION VALIDATION TESTS
    // ==============================

    @Test
    public void testRegisterUserValid() {
        Login login = new Login("John", "Doe");

        String result = login.registerUser(
                "jo_n",
                "Password1!",
                "+27773456286",
                "John",
                "Doe"
        );

        assertEquals(
                "Registration successful.",
                result
        );
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        Login login = new Login("John", "Doe");

        String result = login.registerUser(
                "john",
                "Password1!",
                "+27773456286",
                "John",
                "Doe"
        );

        assertEquals(
                "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.",
                result
        );
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        Login login = new Login("John", "Doe");

        String result = login.registerUser(
                "jo_n",
                "password",
                "+27773456286",
                "John",
                "Doe"
        );

        assertEquals(
                "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                result
        );
    }

    @Test
    public void testRegisterUserInvalidCellNumber() {
        Login login = new Login("John", "Doe");

        String result = login.registerUser(
                "jo_n",
                "Password1!",
                "0773456286",
                "John",
                "Doe"
        );

        assertEquals(
                "Cell phone number incorrectly formatted or does not contain international code.",
                result
        );
    }


    // ==============================
    // LOGIN FUNCTIONALITY TESTS
    // ==============================

    @Test
    public void testLoginUserValid() {
        Login login = new Login("John", "Doe");

        login.registerUser(
                "jo_n",
                "Password1!",
                "+27773456286",
                "John",
                "Doe"
        );

        assertTrue(
                login.loginUser("jo_n", "Password1!")
        );
    }

    @Test
    public void testLoginUserIncorrectUsername() {
        Login login = new Login("John", "Doe");

        login.registerUser(
                "jo_n",
                "Password1!",
                "+27773456286",
                "John",
                "Doe"
        );

        assertFalse(
                login.loginUser("wrong", "Password1!")
        );
    }

    @Test
    public void testLoginUserIncorrectPassword() {
        Login login = new Login("John", "Doe");

        login.registerUser(
                "jo_n",
                "Password1!",
                "+27773456286",
                "John",
                "Doe"
        );

        assertFalse(
                login.loginUser("jo_n", "WrongPass1!")
        );
    }


    // ==============================
    // LOGIN STATUS TESTS
    // ==============================

    @Test
    public void testReturnLoginStatusValid() {
        Login login = new Login("John", "Doe");

        login.registerUser(
                "jo_n",
                "Password1!",
                "+27773456286",
                "John",
                "Doe"
        );

        String result = login.returnLoginStatus(
                "jo_n",
                "Password1!"
        );

        assertEquals(
                "Welcome John Doe it is great to see you again.",
                result
        );
    }

    @Test
    public void testReturnLoginStatusInvalid() {
        Login login = new Login("John", "Doe");

        login.registerUser(
                "jo_n",
                "Password1!",
                "+27773456286",
                "John",
                "Doe"
        );

        String result = login.returnLoginStatus(
                "wrong",
                "WrongPass1!"
        );

        assertEquals(
                "Username or password incorrect, please try again.",
                result
        );
    }
}