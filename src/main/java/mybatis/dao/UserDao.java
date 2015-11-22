package mybatis.dao;

import java.util.Map;

import mybatis.vo.UserVo;

public interface UserDao {
	public int getLoginResult(Map<String, String> map);
	public UserVo getUserInfo(String id);
	public UserVo getUserInfo2(int no);
	public int getUserIdCheck(String id);
	public int insertUser(UserVo userVo);
}
