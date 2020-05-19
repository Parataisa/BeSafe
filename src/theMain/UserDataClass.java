package theMain;



public class UserDataClass {
	public String userNameString = "";
	public String userPasswordString = "";
	public String gehashedesPasswordString = "";
	public String passworSaltString = "";
	public byte[] userSaltByte;
	public boolean login;
	public String userSiteNameString;


	public String[] userSavedAccountSiteStringArray;
	public String[] userSavedAccountStringArray;
	public String[] userSavedAccountPasswordStringArray;
	
	
	
	
	/**
	 * @return the userSiteNameString
	 */
	public String getUserSiteNameString() {
		return userSiteNameString;
	}
	/**
	 * @param userSiteNameString the userSiteNameString to set
	 */
	public void setUserSiteNameString(String userSiteNameString) {
		this.userSiteNameString = userSiteNameString;
	}
	/**
	 * @return the login
	 */
	public boolean isLogin() {
		return login;
	}
	/**
	 * @return the userSavedAccountSiteStringArray
	 */
	public String[] getUserSavedAccountSiteStringArray() {
		return userSavedAccountSiteStringArray;
	}
	/**
	 * @param userSavedAccountSiteStringArray the userSavedAccountSiteStringArray to set
	 */
	public void setUserSavedAccountSiteStringArray(String[] userSavedAccountSiteStringArray) {
		this.userSavedAccountSiteStringArray = userSavedAccountSiteStringArray;
	}
	/**
	 * @return the userSavedAccountStringArray
	 */
	public String[] getUserSavedAccountStringArray() {
		return userSavedAccountStringArray;
	}
	/**
	 * @param userSavedAccountStringArray the userSavedAccountStringArray to set
	 */
	public void setUserSavedAccountStringArray(String[] userSavedAccountStringArray) {
		this.userSavedAccountStringArray = userSavedAccountStringArray;
	}
	/**
	 * @return the userSavedAccountPasswordStringArray
	 */
	public String[] getUserSavedAccountPasswordStringArray() {
		return userSavedAccountPasswordStringArray;
	}
	/**
	 * @param userSavedAccountPasswordStringArray the userSavedAccountPasswordStringArray to set
	 */
	public void setUserSavedAccountPasswordStringArray(String[] userSavedAccountPasswordStringArray) {
		this.userSavedAccountPasswordStringArray = userSavedAccountPasswordStringArray;
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

