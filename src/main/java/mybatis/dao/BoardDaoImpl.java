package mybatis.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import mybatis.vo.Board;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	@Resource(name="sqlSession")
	protected SqlSession sqlSessionTemplate;

	@Override
	public Board showBoard(int idx) {
		return (Board)sqlSessionTemplate.selectOne("board.selectOne", idx);
	}

	@Override
	public int min() {
		return sqlSessionTemplate.selectOne("board.min");
	}

	@Override
	public int max() {
		return sqlSessionTemplate.selectOne("board.max");
	}

	@Override
	public int insert(Board vo) {
		return sqlSessionTemplate.insert("board.insert", vo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return sqlSessionTemplate.update("board.update", map);
	}

	@Override
	public int delete(int idx) {
		return sqlSessionTemplate.delete("board.delete", idx);
	}

}
