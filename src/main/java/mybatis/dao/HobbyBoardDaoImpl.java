package mybatis.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import mybatis.vo.HobbyBoard;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class HobbyBoardDaoImpl implements HobbyBoardDao {

	@Autowired
	@Resource(name="sqlSession")
	protected SqlSession sqlSessionTemplate;

	@Override
	public HobbyBoard showBoard(HashMap<String, Integer> map) {
		return (HobbyBoard)sqlSessionTemplate.selectOne("hboard.selectOne", map);
	}

	@Override
	public int min(int idx) {
		return sqlSessionTemplate.selectOne("hboard.min", idx);
	}

	@Override
	public int max(int idx) {
		return sqlSessionTemplate.selectOne("hboard.max", idx);
	}

	@Override
	public int insert(HobbyBoard hvo) {
		return sqlSessionTemplate.insert("hboard.insert", hvo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return sqlSessionTemplate.update("hboard.update", map);
	}

	@Override
	public int delete(int idx) {
		return sqlSessionTemplate.delete("hboard.delete", idx);
	}

}
