package mybatis.service;

import java.util.HashMap;

import mybatis.dao.CategoryDao;
import mybatis.vo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public Category showCategory(int idx) {
		return categoryDao.showCategory(idx);
	}

	@Override
	public int categoryIdx(String category_name) {
		return categoryDao.categoryIdx(category_name);
	}

	@Override
	public int insert(Category cvo) {
		return categoryDao.insert(cvo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return categoryDao.update(map);
	}

	@Override
	public int delete(int idx) {
		return categoryDao.delete(idx);
	}

}
