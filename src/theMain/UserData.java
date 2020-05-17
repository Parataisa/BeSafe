package theMain;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Scanner;

import javafx.scene.shape.Line;


public class UserData extends PasswordControll {

	void saveUserData(String userPassword, String userName) {
		try {
			 getUserDataForProcessingList(userPassword, userName);
			 String userNameString = userDataSet.getUserNameString();
			 if (new File(userNameString).exists()) {
				System.out.print("User already used!");
			}
			 else {
				 new File(userNameString).mkdir();
				 String userPasswordString = userDataSet.getUserPasswordString();
				 byte[] userSalt = userDataSet.getUserSaltByte();
				 PrintWriter saltWriter = new PrintWriter(userNameString + "/salt.txt");
				 for (byte b : userSalt) {
					saltWriter.println(b);
					}
				 saltWriter.close();
				 PrintWriter writer = new PrintWriter(userNameString + "/data.txt");	 
				 writer.append(userPasswordString);
				 writer.close();
			}
		} catch (Exception e1) {
			
		}
	}
	
	
		public boolean CheckUserData(String userName, String userPassword) throws URISyntaxException, IOException
		{
			File file = new File(userName);
			if(file.exists() == false)
			{
				System.out.println("User doesn't exist");
				return false;
			}
			else if (file.exists()) {
				List userList = saltGettingMethode(userName);
				String savedUserPasswordString = userList.getItem(0);
				byte[] savedSalt = new byte[16];
				savedSalt =	userDataSet.getUserSaltByte();
				
				String checkUserPasswordString = getSecurePassword(userPassword, savedSalt);
				if (checkUserPasswordString.equals(savedUserPasswordString))
				{
					System.out.println("It worked");
					return true;
				}
				else {
					System.out.println("Wrong Password!");
					return false;
				}
				}
				else {
					System.out.println("Something went wrong!");
					return false;
				}
		}
		
		
		List saltGettingMethode(String userName) throws URISyntaxException, IOException
		{
			List lines =  new List();
			File file = new File(userName + "/data.txt");
			File fileS = new File(userName + "/salt.txt");
			try {
				Scanner scanner = new Scanner(file);
				lines.add(scanner.nextLine(), 0);
				scanner.close();
				Scanner saltScanner = new Scanner(fileS);
				byte[] scannedSalt = new byte[16];
				for (int i = 0; i < scannedSalt.length; i++) {
					scannedSalt[i] = saltScanner.nextByte();
				}
				saltScanner.close();
				userDataSet.setUserSaltByte(scannedSalt);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			return lines;
		}
	}
	

