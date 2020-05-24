package theMain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordControll{
	
	UserDataClass userDataSet = new UserDataClass();
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

	public static String generatePassword(char[] password, String salt) throws NoSuchAlgorithmException {	
        String returnValue = null;
        byte[] securePassword = hash(password, salt.getBytes());
 
        returnValue = Base64.getEncoder().encodeToString(securePassword);
 
        return returnValue;
    }
		
	
	public static byte[] hash(char[] userPassword, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(userPassword, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(userPassword, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
	
	
    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
    public static boolean verifyUserPassword(char[] providedPassword,
            char[] securedPassword, String salt) throws NoSuchAlgorithmException
    {
        boolean returnValue = false;

        String newSecurePassword = generatePassword(providedPassword, salt);
        String securedPasswordStringConvertedString = new String(securedPassword);
        returnValue = newSecurePassword.equalsIgnoreCase(securedPasswordStringConvertedString);
        
        return returnValue;
    }
			
}

