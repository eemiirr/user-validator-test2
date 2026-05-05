import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserValidator {

    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        return name.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+");
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        return email.contains("@") && email.contains(".");
    }

    public boolean isValidPassword(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) return false;
        if (password.length() < 8) return false;
        return password.equals(confirmPassword);
    }

    public boolean isValidBirthDate(String date) {
        if (date == null || date.isEmpty()) return false;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return parsedDate.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}