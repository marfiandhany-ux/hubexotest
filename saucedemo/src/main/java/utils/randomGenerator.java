package utils;

public class randomGenerator {

    public static String generateRandomLetters(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(random.nextInt(chars.length())));
        }
        return result.toString();
    }

    // Generates a random string of numbers
    public static String generateRandomNumbers(int length) {
        String numbers = "0123456789";
        StringBuilder result = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            result.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return result.toString();
    }
}
