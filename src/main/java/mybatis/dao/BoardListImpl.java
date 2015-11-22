package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import mybatis.vo.Board;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardListImpl implements BoardListDao {
	@Autowired
	@Resource(name="sqlSession")
	protected SqlSession sqlSessionTemplate;

	@Override
	public List<Board> showList(HashMap<String, Integer> map) {
		return sqlSessionTemplate.selectList("board.list", map);
	}

	@Override
	public int getCount() {
		return sqlSessionTemplate.selectOne("board.count");
	}

}
