package mybatis.vo;

public class UserVo {
	
	private String userId;
	private String userPassword;
	private String userBirthday;
	private String userName;
	private int userSeq;
	
	public String getUserId()       { return userId;       }   public void setUserId(String userId)             { this.userId       = userId;       }
	public String getUserPassword() { return userPassword; }   public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
	public String getUserBirthday() { return userBirthday; }   public void setUserBirthday(String userBirthday) { this.userBirthday = userBirthday; }
	public String getUserName()     { return userName;     }   public void setUserName(String userName)         { this.userName     = userName;     }
	public int getUserSeq()         { return userSeq;      }   public void setUserSeq(int userSeq)              { this.userSeq      = userSeq;      }
	
}
