package theMain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
		accountButton.setText(userDataClass.getSiteNameString());
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
		String keyString = new String(Files.readAllBytes(Paths.get(file.toString(), "/data.txt")));
		String pathString = (file + "/Udata" + "/" + "Acc.data");
		String uDataString = new String(Files.readAllBytes(Paths.get(pathString.toString())));
		Pattern regexFirstScanPatten = Pattern.compile("\\[(.*?)\\]");
		Matcher match = regexFirstScanPatten.matcher(uDataString);
		int count = 0;
		while(match.find())
			count++;
		Integer matchesCountInteger = count; 
		Integer siteID = matchesCountInteger;
		String encryptedAccountNameString = encrypt(userDataClass.getSiteUserNameString(), keyString);
		String encryptedPwString = encrypt(userDataClass.getUserPasswordString(), keyString);
		String encryptedSiteNameString = encrypt(userDataClass.getSiteNameString(), keyString);
		try {
			File appendFileCheck = new File(pathString);
			boolean appendToFile = appendFileCheck.exists();
			FileWriter writer = new FileWriter(pathString, appendToFile);
			writer.write("[SiteID:" + siteID + ":SiteID" + 
						 "Acc:" + encryptedAccountNameString + ":Acc" +
						 "Pw:" + encryptedPwString + ":Pw" +  
						 "Site:" + encryptedSiteNameString + ":Site]");
			writer.close();


		} catch (Exception e) {
			e.printStackTrace();
			}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}	
		
	}
	public void restoreAccountData (UserDataClass userDataClass, GridLayout centerButtonGridLayout,
			JPanel buttonPanel, JFrame frame) 
	{
		File file = new File(userDataClass.getUserNameString());
		if(file.exists() == true)
		{
		try {
			String keyString = new String(Files.readAllBytes(Paths.get(file.toString(), "/data.txt")));
			UserDataClass decryptUserDataClass = new UserDataClass();			
			String pathString = (file + "/Udata" + "/" + "Acc.data");
			String uDataString = new String(Files.readAllBytes(Paths.get(pathString.toString())));
			Pattern regexFirstScanPatten = Pattern.compile("\\[(.*?)\\]");
			Matcher match = regexFirstScanPatten.matcher(uDataString);
			while (match.find())
			{
			System.out.println(match.group(1));
			accSiteDataReader(decryptUserDataClass, match.group(1));
			userDataClass.setSiteID(decryptUserDataClass.getSiteID());
			userDataClass.setSiteUserNameString(decrypt(decryptUserDataClass.getSiteUserNameString(), keyString));
			userDataClass.setUserPasswordString(decrypt(decryptUserDataClass.getUserPasswordString(), keyString));
			userDataClass.setSiteNameString(decrypt(decryptUserDataClass.getSiteNameString(), keyString));
			addAccountToTheList(userDataClass, 
        			centerButtonGridLayout, buttonPanel, frame);
			}
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
    
    private void accSiteDataReader(UserDataClass decryptUserDataClass, String match) {
    	Pattern siteIdPattern = Pattern.compile("SiteID:(.*?):SiteID");
    	Matcher siteIdMatcher = siteIdPattern.matcher(match);
    	siteIdMatcher.find();
    	decryptUserDataClass.setSiteID(Integer.parseInt(siteIdMatcher.group(1)));
    	
    	Pattern siteAccPattern = Pattern.compile("Acc:(.*?):Acc");
    	Matcher siteAccMatcher = siteAccPattern.matcher(match);
    	siteAccMatcher.find();
    	decryptUserDataClass.setSiteUserNameString(siteAccMatcher.group(1));
    	
    	Pattern sitePwPattern = Pattern.compile("Pw:(.*?):Pw");
    	Matcher sitePwMatcher = sitePwPattern.matcher(match);
    	sitePwMatcher.find();
    	decryptUserDataClass.setUserPasswordString(sitePwMatcher.group(1));
    	
    	Pattern siteNamePattern = Pattern.compile("Site:(.*?):Site");
    	Matcher siteNameMatcher = siteNamePattern.matcher(match);
    	siteNameMatcher.find();
    	decryptUserDataClass.setSiteNameString(siteNameMatcher.group(1));
	}
	}

