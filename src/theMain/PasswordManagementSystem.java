package theMain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PasswordManagementSystem {

	
	public void addAccountToTheList(UserDataClass userDataClass, GridLayout centerButtonGridLayout,
			JPanel buttonPanel, JFrame frame) 
	{
		buttonPanel.setLayout(centerButtonGridLayout);
		JButton accountButton = new JButton();					
		accountButton.setText(userDataClass.getUserSiteNameString());
		accountButton.setSize(250, 100);
		buttonPanel.add(accountButton);
		buttonPanel.revalidate();
		buttonPanel.repaint();
		frame.getContentPane().add(BorderLayout.WEST, buttonPanel);
		frame.revalidate();
		frame.repaint();
	}
	public void storeAccountLocally(UserDataClass userDataClass) 
	{
	File file = new File(userDataClass.getUserNameString());
	if(file.exists() == true)
	{
	try {
		numberOfFiles(userDataClass);
		String keyString = new String(Files.readAllBytes(Paths.get(file.toString(), "/data.txt")));
		String encryptedAccountNameString = encrypt(userDataClass.getSiteUserNameString(), keyString);
		String encryptedPwString = encrypt(userDataClass.getUserPasswordString(), keyString);
		String encryptedSiteNameString = encrypt(userDataClass.getUserSiteNameString(), keyString);
		FileOutputStream fos;
		ObjectOutputStream oOut;
		UserDataClass encrpteDataClass = new UserDataClass();
		encrpteDataClass.setUserSiteNameString(encryptedAccountNameString);
		encrpteDataClass.setUserPasswordString(encryptedPwString);
		encrpteDataClass.setSiteUserNameString(encryptedSiteNameString);
		try {
			fos = new FileOutputStream(file + "/Udata" + "/" + userDataClass.getSiteID() + "Acc.ser");
			
			oOut = new ObjectOutputStream(fos);
	        oOut.writeObject(encrpteDataClass);
	        oOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}	
		
	}
	public void restoreAccountData (UserDataClass userDataClass, int i) 
	{
		File file = new File(userDataClass.getUserNameString());
		if(file.exists() == true)
		{
			FileInputStream fis = null;
			ObjectInputStream in = null;
		try {
			String keyString = new String(Files.readAllBytes(Paths.get(file.toString(), "/data.txt")));
			UserDataClass decryptUserDataClass = new UserDataClass();			
            fis = new FileInputStream(file + "/Udata" + "/" + i + "Acc.ser");
            in = new ObjectInputStream(fis);
            decryptUserDataClass = (UserDataClass) in.readObject();
            in.close();
            userDataClass.setUserSiteNameString(decrypt(decryptUserDataClass.getUserSiteNameString(), keyString));
            userDataClass.setUserPasswordString(decrypt(decryptUserDataClass.getUserPasswordString(), keyString));
            userDataClass.setSiteUserNameString(decrypt(decryptUserDataClass.getUserSiteNameString(), keyString));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		}
		
	}
	
	
    private static SecretKeySpec secretKey;
    private static byte[] key;
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    
    
    public static String decrypt(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    public void numberOfFiles(UserDataClass userDataClass) {
		int count = 0;
		File file = new File(userDataClass.getUserNameString() + "/Udata");
		File[] files = file.listFiles();
		if (files != null) 
		{
		for (int i = 0; i < files.length; i++) {
			count++;	
		}	
		userDataClass.setSiteID(count);
		}
	}
	}

