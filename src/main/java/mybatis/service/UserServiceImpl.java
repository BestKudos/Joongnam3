package mybatis.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import mybatis.dao.UserDao;
import mybatis.vo.UserVo;

@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	public int getLoginResult(Map<String, String> map) {
		return dao.getLoginResult(map);
	}

	@Override
	public UserVo getUserInfo(String id) {
		return dao.getUserInfo(id);
	}

	@Override
	public UserVo getUserInfo2(int no) {
		return dao.getUserInfo2(no);
	}

	@Override
	public int getUserIdCheck(String id) {
		return dao.getUserIdCheck(id);
	}

	@Override
	public int insertUser(UserVo userVo) {
		return dao.insertUser(userVo);
	}

}
