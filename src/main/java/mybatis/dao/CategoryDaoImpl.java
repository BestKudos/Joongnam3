package mybatis.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import mybatis.vo.Category;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	@Resource(name="sqlSession")
	protected SqlSession sqlSessionTemplate;

	@Override
	public Category showCategory(int idx) {
		return sqlSessionTemplate.selectOne("category.selectOne", idx);
	}

	@Override
	public int categoryIdx(String category_name) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("category.selectIdx", category_name);
	}

	@Override
	public int insert(Category cvo) {
		return sqlSessionTemplate.insert("category.insert", cvo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return sqlSessionTemplate.update("category.update", map);
	}

	@Override
	public int delete(int idx) {
		return sqlSessionTemplate.delete("category.delete", idx);
	}


}
