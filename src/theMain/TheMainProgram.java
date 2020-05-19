package theMain;

public class TheMainProgram 
{
	public static void main(String[] args) 
	{	
	UserDataClass userDataClass = new UserDataClass();
	userDataClass.setLogin(false);
	logginCheck(userDataClass.isLogin());
	}
 
	public static void logginCheck(Boolean isLoggedin) 
	{
	 new TheInterface(isLoggedin);
	}
}
 

