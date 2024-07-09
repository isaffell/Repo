
/**
 *CMSC203 40539
Assignment 3
Grigoriy Grinberg
Summary of Description: isStringinBounds checks for if charcter is within ASCII values. 
CaesarEncryption encrypts a message with caesar encryption, CeasarDecrytion decodes.
BellasoEncryption encrypts a message with caesar encryption, BellasoDecrytion decodes.
07/08/24
Eclipse IDE
I pledge that I have completed the programming assessment independently. I have not copied the code from a student or any source. 
Isabel Saffell 

 */

public class CryptoManager {

	private static final char LOWER_RANGE = 35;
	private static final char UPPER_RANGE = 96;
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	public static boolean isStringInBounds(String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			if (c < LOWER_RANGE || c > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) { 
			return "";
		}
		String encrypted = "";
		for (int i = 0; i < plainText.length(); i++) {
			char cPlain = plainText.charAt(i);
			int newChar = cPlain + key;

			while (newChar > UPPER_RANGE) {
				newChar -= RANGE;
			}
			while (newChar < LOWER_RANGE) {
				newChar += RANGE;
			}
			encrypted += (char)newChar;
		}
		return encrypted;
	}

	public static String caesarDecryption(String encryptedText, int key) {
		String decrypt = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			char cPlain = encryptedText.charAt(i);
			int newChar = cPlain - key;

			while (newChar < LOWER_RANGE) {
				newChar += RANGE;
			}
			while (newChar > UPPER_RANGE) {
				newChar -= RANGE;
			}
			decrypt += (char)newChar;
		}
		return decrypt;
	}

	public static String bellasoEncryption(String plainText, String bellasoStr) {
		String encrypted = "";
		for (int i = 0; i < plainText.length(); i++) {
			char cPlain = plainText.charAt(i);
			int keyChar = bellasoStr.charAt(i % bellasoStr.length());
			int newChar = (int)cPlain + keyChar;
			while (newChar > UPPER_RANGE) {
				newChar -= RANGE;
			}
			while (newChar < LOWER_RANGE) {
				newChar += RANGE;
			}
			encrypted += (char)newChar;
		}
		return encrypted;
	}

	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decrypted = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			char cPlain = encryptedText.charAt(i);
			int keyChar = bellasoStr.charAt(i % bellasoStr.length());
			int newChar = (int)cPlain - keyChar;
			while (newChar < LOWER_RANGE) {
				newChar += RANGE;
			}
			while (newChar > UPPER_RANGE) {
				newChar -= RANGE;
			}
			decrypted += (char)newChar;
		}
		return decrypted;
	}

	public static void main(String[] args) {
		// Test case to validate caesarEncryption
		String plainText = "HELLO";
		int key = 5;
		String encrypted = caesarEncryption(plainText, key);
		System.out.println("Encrypted: " + encrypted);

		// Test case to validate caesarDecryption
		String decrypted = caesarDecryption(encrypted, key);
		System.out.println("Decrypted: " + decrypted);
	}
}

