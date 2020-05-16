package theMain;
import java.awt.List;
import java.io.File;
import java.io.PrintWriter;

public class UserData extends PasswordControll {
	void saveUserData(String userPassword, String userName) {
		try {
			 List testList = GetUserData(userPassword, userName);
			 String userNameString = testList.getItem(2);
			 if (new File(userNameString).exists()) {
				System.out.print("User already used!");
			}
			 else {
				 new File(userNameString).mkdir();
				 String userPasswordString = testList.getItem(1);
				 String userSaltString = testList.getItem(0);
				 PrintWriter writer = new PrintWriter(userNameString + "/data.txt",  "UTF-8");
				 writer.append(userPasswordString);
				 writer.println();
				 writer.append(userSaltString);
				 writer.close();			
			}
		} catch (Exception e1) {
		}
	}

}
