package theMain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class UserData extends LoginPasswordControll {

	void saveUserData(char[] userPassword, String userName) {
		try {
			String saltString = getSalt(30);
			String pwString = generatePassword(userPassword, saltString);		
			 if (new File(userName).exists()) {
				System.out.print("User already used!");
			}
			 else {
				 new File(userName).mkdir();
				 new File(userName + "/Udata").mkdir();
				 File userDataFile = new File(userName + "/Udata/Acc.data");			 
				 userDataFile.createNewFile();
				 char[] userPasswordChar = new char[pwString.length()];
				 for (int i = 0; i < pwString.length(); i++) {
					 userPasswordChar[i] = pwString.charAt(i);
				}
				 PrintWriter saltWriter = new PrintWriter(userName + "/salt.txt");
				 saltWriter.write(saltString);
				 saltWriter.close();
				 PrintWriter writer = new PrintWriter(userName + "/data.txt");
				 for (char pw : userPasswordChar) {
					 writer.write(pw);				
				}
				 writer.close();
			}
		} catch (Exception e1) {
			
		}
	}
	
	
		public boolean CheckUserData(String userName, char[] userPassword) 
				throws URISyntaxException, IOException
		{
			File file = new File(userName);
			if(file.exists() == false)
			{
				System.out.println("User doesn't exist");
				return false;
			}
			else if (file.exists()) {
				userDataFetch(userName, userDataSet);
				char[] savedUserPasswordChar = userDataSet.getUserPasswordCharAr();
				String savedSalt =	userDataSet.getUserSaltString();		
				boolean passwordCheck;
				try {
					passwordCheck = verifyUserPassword(userPassword, 
							savedUserPasswordChar, savedSalt);
					if (passwordCheck)
					{
						System.out.println("It worked");
						return true;
					}
					else {
						System.out.println("Wrong Password!");
						return false;
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
					return false;
				}
				}
			return false;
		}
		
		
		void userDataFetch(String userName, UserDataClass userDataClass) throws URISyntaxException, IOException
		{
			File file = new File(userName + "/salt.txt");
			File fileU = new File(userName + "/data.txt");
			try {
				FileReader fr = new FileReader(fileU);
				BufferedReader brUserDate = new BufferedReader(fr); 
				String i;
				char[] tempCharAr = {};
				while ((i=brUserDate.readLine()) != null)
				{
					tempCharAr = i.toCharArray();					
				}
				brUserDate.close();
				userDataClass.setUserPasswordCharAr(tempCharAr);	
				String saltString = "";
				Scanner saltScanner = new Scanner(file);
				while (saltScanner.hasNextLine()) {
					saltString = saltScanner.nextLine();				
				}
				saltScanner.close();
				userDataSet.setUserSaltString(saltString);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		}
	}
	

