package theMain;



public class UserDataClass implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userNameString = "";
	public char[] userPasswordCharAr;
	public String gehashedesPasswordString = "";
	public String passworSaltString = "";
	public String userSaltString;
	public boolean login;
	public String userSitePasswordString;
	public String userSiteNameString;
	public String siteUserNameString;
	public int siteID;
	
	
	
	
	/**
	 * @return the userSitePasswordString
	 */
	public String getUserSitePasswordString() {
		return userSitePasswordString;
	}
	/**
	 * @param userSitePasswordString the userSitePasswordString to set
	 */
	public void setUserSitePasswordString(String userSitePasswordString) {
		this.userSitePasswordString = userSitePasswordString;
	}
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
	 * @return the siteID
	 */
	public int getSiteID() {
		return siteID;
	}
	/**
	 * @param siteID the siteID to set
	 */
	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}
	/**
	 * @return the siteUserNameString
	 */
	public String getSiteUserNameString() {
		return siteUserNameString;
	}
	/**
	 * @param siteUserNameString the siteUserNameString to set
	 */
	public void setSiteUserNameString(String siteUserNameString) {
		this.siteUserNameString = siteUserNameString;
	}
	/**
	 * @return the userSiteNameString
	 */
	public String getSiteNameString() {
		return userSiteNameString;
	}
	/**
	 * @param userSiteNameString the userSiteNameString to set
	 */
	public void setSiteNameString(String userSiteNameString) {
		this.userSiteNameString = userSiteNameString;
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
	public char[] getUserPasswordCharAr() {
		return userPasswordCharAr;
	}
	/**
	 * @return the userSaltByte
	 */
	public String getUserSaltString() {
		return userSaltString;
	}
	/**
	 * @param userSaltByte the userSaltByte to set
	 */
	public void setUserSaltString(String userSaltString) {
		this.userSaltString = userSaltString;
	}
	/**
	 * @param userPasswordString the userPasswordString to set
	 */
	public void setUserPasswordCharAr(char[] userPasswordCharAr) {
		this.userPasswordCharAr = userPasswordCharAr;
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

