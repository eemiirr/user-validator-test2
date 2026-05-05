import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }

    @Test
    void validName() {
        assertTrue(validator.isValidName("Ahmet"));
    }

    @Test
    void emptyName() {
        assertFalse(validator.isValidName(""));
    }

    @Test
    void invalidEmail() {
        assertFalse(validator.isValidEmail("testgmail.com"));
    }

    @Test
    void validEmail() {
        assertTrue(validator.isValidEmail("test@gmail.com"));
    }

    @Test
    void passwordShort() {
        assertFalse(validator.isValidPassword("1234567", "1234567"));
    }

    @Test
    void passwordValid() {
        assertTrue(validator.isValidPassword("12345678", "12345678"));
    }

    @Test
    void passwordMismatch() {
        assertFalse(validator.isValidPassword("12345678", "12345679"));
    }

    @Test
    void validDate() {
        assertTrue(validator.isValidBirthDate("10/10/2000"));
    }

    @Test
    void futureDate() {
        assertFalse(validator.isValidBirthDate("10/10/2100"));
    }
}
