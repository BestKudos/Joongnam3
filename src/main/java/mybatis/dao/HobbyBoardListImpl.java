package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import mybatis.vo.HobbyBoard;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class HobbyBoardListImpl implements HobbyBoardListDao {
	@Autowired
	@Resource(name="sqlSession")
	protected SqlSession sqlSessionTemplate;

	@Override
	public List<HobbyBoard> showList(HashMap<String, Integer> map) {
		return sqlSessionTemplate.selectList("hboard.list", map);
	}

	@Override
	public int getCount(int cate) {
		return sqlSessionTemplate.selectOne("hboard.count", cate);
	}

}
