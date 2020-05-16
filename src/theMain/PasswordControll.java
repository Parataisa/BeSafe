package theMain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordControll extends UserDataClass{
	
	UserDataClass userDataSet = new UserDataClass();

	public void getUserDataForProcessingList(String userPassword, String userName) throws NoSuchAlgorithmException 
	{
		userDataSet.setUserPasswordString(userPassword);
		userDataSet.setUserNameString(userName);
		passwordHashing();
	}
	private UserData passwordHashing() throws NoSuchAlgorithmException {
		String userPassword = userDataSet.getUserPasswordString();
		String userNameString = userDataSet.getUserNameString();
		byte[] salt = getSalt();
		String sPassword = getSecurePassword(userPassword, salt);
		UserData newUserData = new UserData();
		userDataSet.setUserNameString(userNameString);
		userDataSet.setUserPasswordString(sPassword);
		userDataSet.setUserSaltByte(salt);
		return newUserData;
		}
		
	public static String getSecurePassword(String userPassword, byte[] salt) {
		String hashedPasswordString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt); 
            byte[] bytes = md.digest(userPassword.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPasswordString = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPasswordString;
	}
	private static byte[] getSalt() throws NoSuchAlgorithmException
	{
	    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	    byte[] salt = new byte[16];
	    sr.nextBytes(salt);
	    return salt;
	}
			
}

