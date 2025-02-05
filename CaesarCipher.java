import java.util.Scanner;

public class CaesarCipher {

    // Encryption method
    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedText.append(c);  // Keep non-alphabetic characters as is
            }
        }
        return encryptedText.toString();
    }

    // Decryption method
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26)); // In Caesar cipher, decryption is reverse encryption
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caesar Cipher Program");
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();

        System.out.print("Encrypt or Decrypt? (E/D): ");
        char choice = scanner.next().toUpperCase().charAt(0);

        String result;
        if (choice == 'E') {
            result = encrypt(text, shift);
            System.out.println("Encrypted text: " + result);
        } else if (choice == 'D') {
            result = decrypt(text, shift);
            System.out.println("Decrypted text: " + result);
        } else {
            System.out.println("Invalid choice. Please select 'E' for encrypt or 'D' for decrypt.");
        }

        scanner.close();
    }
}
