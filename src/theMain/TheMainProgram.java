package theMain;

public class TheMainProgram 
{
	public static void main(String[] args) 
	{	
	UserDataClass userDataClass = new UserDataClass();
	userDataClass.setLogin(false);
	logginCheck(userDataClass);
	}
 
	public static void logginCheck(UserDataClass userDataClass) 
	{
	 new TheInterface(userDataClass);
	}
}
 

