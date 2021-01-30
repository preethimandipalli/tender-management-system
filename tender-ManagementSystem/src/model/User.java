package model;

public class User {
		private String firstName;
	    private String lastName;
	    private String userName;
	    private String password;
	    private String emailId;
	    private long phoneNo;
	    private String confirmPassword;
	    
	    public User(String firstName, String lastName, String userName, long phoneNo, String emailId,String confirmPassword,String password) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
			this.emailId = emailId;
			this.phoneNo = phoneNo;
			this.confirmPassword=confirmPassword;
		}
		public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    public String getUserName() {
	        return userName;
	    }
	    public void setUserName(String userName) {
	        this.userName = userName;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getEmailId() {
	        return emailId;
	    }
	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }
	    public long getPhoneNo() {
	        return phoneNo;
	    }
	    public void setPhoneNo(long phoneNo) {
	        this.phoneNo = phoneNo;
	    }
	    public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		
		
	}

