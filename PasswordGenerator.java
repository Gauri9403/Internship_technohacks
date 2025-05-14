import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Generator ===");
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include symbols? (y/n): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, useUpper, useLower, useDigits, useSymbols);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean upper, boolean lower, boolean digits, boolean symbols) {
        String allowed = "";
        if (upper) allowed += UPPER;
        if (lower) allowed += LOWER;
        if (digits) allowed += DIGITS;
        if (symbols) allowed += SYMBOLS;

        if (allowed.isEmpty()) {
            return "Error: No character types selected!";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowed.length());
            password.append(allowed.charAt(index));
        }

        return password.toString();
    }
}
