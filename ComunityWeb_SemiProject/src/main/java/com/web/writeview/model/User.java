package user;

public class User {
    private String USER_ID;
    private String PASSWORD;
    private String IS_MANAGER;
    
    public User(String userid, String password) {
    	this.USER_ID = userid;
    	this.PASSWORD = password;
    	this.IS_MANAGER = "0";
    }
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getIS_MANAGER() {
		return IS_MANAGER;
	}
	public void setIS_MANAGER(String iS_MANAGER) {
		IS_MANAGER = iS_MANAGER;
	}
 
    
}
