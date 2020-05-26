package theMain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.awt.Toolkit;

public class SiteDataManagementSystem {
	private static HashMap<Integer, String> buttonIdHashMap = new HashMap<>();
	
	public void addAccountToTheList(UserDataClass userDataClass, GridLayout centerButtonGridLayout,
			JPanel buttonPanel, JFrame frame, JCheckBox edit) 
	{
		buttonPanel.setLayout(centerButtonGridLayout);
		JButton accountButton = new JButton();
		Integer siteIdInt = userDataClass.getSiteID();
		String siteIdAsString = new String(siteIdInt.toString());
		accountButton.setName(siteIdAsString);
		accountButton.setText(userDataClass.getSiteNameString());
		accountButton.setSize(250, 100);
		accountButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (edit.isSelected() == true) {
					JPanel editPanel = new JPanel();
					JFrame editFrame = new JFrame();
					
					JLabel editSiteLabel = new JLabel("Site: ");
			        JLabel editNameLabel = new JLabel("Accountname: ");
			        JLabel editPasswordLabel = new JLabel("Accountpassword: ");
			        
			        JTextField editSitetf = new JTextField(20);
			        JTextField editNametf = new JTextField(20);
			        JTextField editPasswordPwf = new JTextField(20);
					
			        JButton editSaveButton = new JButton("Save");
			        JButton editCancelButton = new JButton("Cancel");
			        
			        GridLayout editGridLayout = new GridLayout(4,2);
			        
			        editPanel.setLayout(editGridLayout);
			        editPanel.add(editSiteLabel);
			        editPanel.add(editSitetf);
			        editPanel.add(editNameLabel);
			        editPanel.add(editNametf);
			        editPanel.add(editPasswordLabel);
			        editPanel.add(editPasswordPwf);
			        editPanel.add(editSaveButton);
			        editPanel.add(editCancelButton);
			        
			        editFrame.getContentPane().add(BorderLayout.CENTER, editPanel);
			        editFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			        editFrame.setTitle("BeSafe");
					URL iconUrl = getClass().getResource("/BSIcon.png");
					ImageIcon icon = new ImageIcon(iconUrl);
					editPanel.setBorder(BorderFactory.createEmptyBorder(15,5,15,5));
					editFrame.setSize(400, 200);
					editFrame.setLocationRelativeTo(null);
					editFrame.setIconImage(icon.getImage());
					editFrame.setVisible(true);
				}
				else {
					Integer accButtonNameInteger = Integer.parseInt(accountButton.getName());
					findingThePasswordForTheAccount(accButtonNameInteger, userDataClass);
					StringSelection selection = new StringSelection(
							userDataClass.getUserSitePasswordString());
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(selection, selection);								
				}
			}
		});
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
		getSiteIdFormDataLastMatch(userDataClass, uDataString);
		int siteID = userDataClass.getSiteID();		
		String encryptedAccountNameString = encrypt(userDataClass.getSiteUserNameString(), keyString);
		String encryptedPwString = encrypt(userDataClass.getUserSitePasswordString(), keyString);
		String encryptedSiteNameString = encrypt(userDataClass.getSiteNameString(), keyString + siteID);
		try {
			File appendFileCheck = new File(pathString);
			boolean appendToFile = appendFileCheck.exists();
			FileWriter writer = new FileWriter(pathString, appendToFile);
			writer.write("[SiteID:" + siteID + ":SiteID" + 
						 "Acc:" + encryptedAccountNameString + ":Acc" +
						 "Pw:" + encryptedPwString + ":Pw" +  
						 "Site:" + encryptedSiteNameString + ":Site]");
			writer.close();
			buttonIdHashMap.put(userDataClass.getSiteID(),
							"[Acc:" + userDataClass.getSiteUserNameString() + ":Acc" +
							 "Pw:" + userDataClass.getUserSitePasswordString() + ":Pw" +  
							 "Site:" + userDataClass.getSiteNameString() + ":Site]");

		} catch (Exception e) {
			e.printStackTrace();
			}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}	
		
	}
	public void restoreAccountData (UserDataClass userDataClass, GridLayout centerButtonGridLayout,
			JPanel buttonPanel, JFrame frame, JCheckBox edit) 
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
			userDataClass.setUserSitePasswordString(decrypt(decryptUserDataClass.getUserSitePasswordString(), keyString));
			userDataClass.setSiteNameString(decrypt(decryptUserDataClass.getSiteNameString(), keyString + userDataClass.getSiteID()));
			addAccountToTheList(userDataClass, 
        			centerButtonGridLayout, buttonPanel, frame, edit);
			buttonIdHashMap.put(userDataClass.getSiteID(), 
							"[Acc:" + userDataClass.getUserSiteNameString() + ":Acc" +
							 "Pw:" + userDataClass.getUserSitePasswordString() + ":Pw"+
							 "Site:" + userDataClass.getSiteNameString() + ":Site]");
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
    	getSiteIdFormData(decryptUserDataClass, match);
    	
    	Pattern siteAccPattern = Pattern.compile("Acc:(.*?):Acc");
    	Matcher siteAccMatcher = siteAccPattern.matcher(match);
    	siteAccMatcher.find();
    	decryptUserDataClass.setSiteUserNameString(siteAccMatcher.group(1));
    	
    	Pattern sitePwPattern = Pattern.compile("Pw:(.*?):Pw");
    	Matcher sitePwMatcher = sitePwPattern.matcher(match);
    	sitePwMatcher.find();
    	decryptUserDataClass.setUserSitePasswordString(sitePwMatcher.group(1));
    	
    	Pattern siteNamePattern = Pattern.compile("Site:(.*?):Site");
    	Matcher siteNameMatcher = siteNamePattern.matcher(match);
    	siteNameMatcher.find();
    	decryptUserDataClass.setSiteNameString(siteNameMatcher.group(1));
	}
    
    
	public void getSiteIdFormData(UserDataClass decryptUserDataClass, String match) {
		Pattern siteIdPattern = Pattern.compile("SiteID:(.*?):SiteID");
    	Matcher siteIdMatcher = siteIdPattern.matcher(match);
    	siteIdMatcher.find();
    	decryptUserDataClass.setSiteID(Integer.parseInt(siteIdMatcher.group(1)));
	}
	
	public void getSiteIdFormDataLastMatch(UserDataClass UserDataClass, String match) {
		Pattern siteIdPattern = Pattern.compile("SiteID:(.*?):SiteID");
		Matcher siteIdMatcher = siteIdPattern.matcher(match);
		StringArray siteIds = new StringArray(); 
		siteIds.add("0");
			while (siteIdMatcher.find())
			{
				siteIds.add(siteIdMatcher.group(1));				
			}
			UserDataClass.setSiteID(Integer.parseInt(siteIds.get(siteIds.getSize() - 1)) + 1);	
		}	
     
    
    private void findingThePasswordForTheAccount(int buttonId, UserDataClass userDataClass) {
    	File file = new File(userDataClass.getUserNameString());
		if(file.exists() == true)
		{
			String keyString;
			try {
				keyString = new String(Files.readAllBytes(Paths.get(file.toString(), "/data.txt")));
				String pathString = (file + "/Udata" + "/" + "Acc.data");
				String uDataString = new String(Files.readAllBytes(Paths.get(pathString.toString())));
				Pattern regexFirstScanPatten = Pattern.compile("\\[SiteID:"+ buttonId +"(.*?)\\]");
				Matcher match = regexFirstScanPatten.matcher(uDataString);
				while (match.find())
				{	
					System.out.println(match.group());
			    	Pattern sitePwPattern = Pattern.compile("Pw:(.*?):Pw");
			    	Matcher sitePwMatcher = sitePwPattern.matcher(match.group(1));
			    	sitePwMatcher.find();
			    	String tempUserPasswordString = (sitePwMatcher.group(1));
					userDataClass.setUserSitePasswordString(decrypt(tempUserPasswordString, keyString));
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

    }
    }

