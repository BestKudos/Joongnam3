package mybatis.dao;

import java.util.Map;

import javax.annotation.Resource;

import mybatis.vo.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	@Resource(name="sqlSession2")
	protected SqlSession sqlSessionTemplate;

	@Override
	public int getLoginResult(Map<String, String> map) {
		return sqlSessionTemplate.selectOne("user.getLoginResult", map);
	}

	@Override
	public UserVo getUserInfo(String id) {
		return (UserVo) sqlSessionTemplate.selectOne("user.getUserInfo", id);
	}

	@Override
	public UserVo getUserInfo2(int no) {
		return (UserVo) sqlSessionTemplate.selectOne("user.getUserInfo2", no);
	}

	@Override
	public int getUserIdCheck(String id) {
		return sqlSessionTemplate.selectOne("user.getUserIdCheck", id);
	}

	@Override
	public int insertUser(UserVo userVo) {
		return sqlSessionTemplate.insert("user.insertUser", userVo);
	}

}
