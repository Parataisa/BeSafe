package theMain;
import java.awt.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
public class PasswordControll {
	public String gehashedesPasswordString;
	
	public String userPasswordString;
	private String getUserPasswordString() {
		return userPasswordString;
	}
	public void setUserPasswordString(String userPasswordString) {
		this.userPasswordString = userPasswordString;
	}
	
	
	public String userNameString;
	private String getUserNameString() {
		return userNameString;
	}
	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	

	public List GetUserData(String userPassword, String userName) throws NoSuchAlgorithmException 
	{
		setUserPasswordString(userPassword);
		setUserNameString(userName);
		return passwordHashing();
	}
	
	
	private List passwordHashing() throws NoSuchAlgorithmException {
		String userPassword = getUserPasswordString();
		String userNameString = getUserNameString();
		byte[] salt = getSalt();
		String sPassword = getSecurePassword(userPassword, salt);
		List PwList = new List();
		PwList.add(sPassword);
		PwList.add(salt.toString());
		PwList.add(userNameString);
		return PwList;
		}
	
	
	
	private String getSecurePassword(String userPassword, byte[] salt) {
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
