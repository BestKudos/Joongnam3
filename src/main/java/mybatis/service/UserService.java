package mybatis.service;

import java.util.Map;

import mybatis.vo.UserVo;

public interface UserService {
	public int getLoginResult(Map<String, String> map);
	public UserVo getUserInfo(String id);
	public UserVo getUserInfo2(int no);
	public int getUserIdCheck(String id);
	public int insertUser(UserVo userVo);
}
