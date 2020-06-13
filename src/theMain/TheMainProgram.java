package theMain;

public class TheMainProgram {
	public static void main(String[] args) {
		UserDataClass userDataClass = new UserDataClass();
		new StartWindow(userDataClass);
	}

	public static void logginCheck(UserDataClass userDataClass) {
		new LoggedInWindow(userDataClass);
	}
}
