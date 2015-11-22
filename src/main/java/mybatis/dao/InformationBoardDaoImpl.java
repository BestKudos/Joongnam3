package mybatis.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import mybatis.vo.HobbyBoard;
import mybatis.vo.InformationBoard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InformationBoardDaoImpl implements InformationBoardDao {

	@Autowired
	@Resource(name="sqlSession")
	protected SqlSession sqlSessionTemplate;

	@Override
	public InformationBoard showBoard(HashMap<String, Integer> map) {
		return (InformationBoard)sqlSessionTemplate.selectOne("iboard.selectOne", map);
	}

	@Override
	public int min(int idx) {
		return sqlSessionTemplate.selectOne("iboard.min", idx);
	}

	@Override
	public int max(int idx) {
		return sqlSessionTemplate.selectOne("iboard.max", idx);
	}

	@Override
	public int insert(InformationBoard ivo) {
		return sqlSessionTemplate.insert("iboard.insert", ivo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return sqlSessionTemplate.update("iboard.update", map);
	}

	@Override
	public int delete(int idx) {
		return sqlSessionTemplate.delete("iboard.delete", idx);
	}

}
