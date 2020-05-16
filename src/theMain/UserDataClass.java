package theMain;

public class UserDataClass {
	public String userNameString = "";
	public String userPasswordString = "";
	public String gehashedesPasswordString = "";
	public String passworSaltString = "";
	public byte[] userSaltByte;
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

