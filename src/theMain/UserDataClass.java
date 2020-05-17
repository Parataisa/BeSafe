package theMain;

import com.sun.org.apache.xerces.internal.xs.StringList;

public class UserDataClass {
	public String userNameString = "";
	public String userPasswordString = "";
	public String gehashedesPasswordString = "";
	public String passworSaltString = "";
	public byte[] userSaltByte;
	public boolean login;
	public String[] testArrayStrings;
	/**
	 * @return the testArrayStrings
	 */
	public String[] getTestArrayStrings() {
		return testArrayStrings;
	}
	/**
	 * @param testArrayStrings the testArrayStrings to set
	 */
	public void setTestArrayStrings(String[] testArrayStrings) {
		this.testArrayStrings = testArrayStrings;
	}
	public StringList userSavedAccountSiteStringList;
	public StringList userSavedAccountStringList;
	public StringList userSavedAccountPasswordStringList;
	
	
	
	
	/**
	 * @return the userSavedAccountSiteStringList
	 */
	public StringList getUserSavedAccountSiteStringList() {
		return userSavedAccountSiteStringList;
	}
	/**
	 * @param userSavedAccountSiteStringList the userSavedAccountSiteStringList to set
	 */
	public void setUserSavedAccountSiteStringList(StringList userSavedAccountSiteStringList) {
		this.userSavedAccountSiteStringList = userSavedAccountSiteStringList;
	}
	/**
	 * @return the userSavedAccountStringList
	 */
	public StringList getUserSavedAccountStringList() {
		return userSavedAccountStringList;
	}
	/**
	 * @param userSavedAccountStringList the userSavedAccountStringList to set
	 */
	public void setUserSavedAccountStringList(StringList userSavedAccountStringList) {
		this.userSavedAccountStringList = userSavedAccountStringList;
	}
	/**
	 * @return the userSavedAccountPasswordStringList
	 */
	public StringList getUserSavedAccountPasswordStringList() {
		return userSavedAccountPasswordStringList;
	}
	/**
	 * @param userSavedAccountPasswordStringList the userSavedAccountPasswordStringList to set
	 */
	public void setUserSavedAccountPasswordStringList(StringList userSavedAccountPasswordStringList) {
		this.userSavedAccountPasswordStringList = userSavedAccountPasswordStringList;
	}
	/**
	 * @return the login
	 */
	public boolean isLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(boolean login) {
		this.login = login;
	}
	/**
	 * @return the userNameString
	 */
	public String getUserNameString() {
		return userNameString;
	}
	/**
	 * @param userNameString the userNameString to set
	 */
	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	/**
	 * @return the userPasswordString
	 */
	public String getUserPasswordString() {
		return userPasswordString;
	}
	/**
	 * @return the userSaltByte
	 */
	public byte[] getUserSaltByte() {
		return userSaltByte;
	}
	/**
	 * @param userSaltByte the userSaltByte to set
	 */
	public void setUserSaltByte(byte[] userSaltByte) {
		this.userSaltByte = userSaltByte;
	}
	/**
	 * @param userPasswordString the userPasswordString to set
	 */
	public void setUserPasswordString(String userPasswordString) {
		this.userPasswordString = userPasswordString;
	}
	/**
	 * @return the gehashedesPasswordString
	 */
	public String getGehashedesPasswordString() {
		return gehashedesPasswordString;
	}
	/**
	 * @param gehashedesPasswordString the gehashedesPasswordString to set
	 */
	public void setGehashedesPasswordString(String gehashedesPasswordString) {
		this.gehashedesPasswordString = gehashedesPasswordString;
	}
	/**
	 * @return the passworSaltString
	 */
	public String getPassworSaltString() {
		return passworSaltString;
	}
	/**
	 * @param passworSaltString the passworSaltString to set
	 */
	public void setPassworSaltString(String passworSaltString) {
		this.passworSaltString = passworSaltString;
	}

		
	}

