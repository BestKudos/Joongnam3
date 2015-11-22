package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import mybatis.vo.InformationBoard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InformationBoardListImpl implements InformationBoardListDao {
	@Autowired
	@Resource(name="sqlSession")
	protected SqlSession sqlSessionTemplate;

	@Override
	public List<InformationBoard> showList(HashMap<String, Integer> map) {
		return sqlSessionTemplate.selectList("iboard.list", map);
	}

	@Override
	public int getCount(int cate) {
		return sqlSessionTemplate.selectOne("iboard.count", cate);
	}

}
