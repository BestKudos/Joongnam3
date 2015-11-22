package mybatis.dao;

import java.util.HashMap;

import mybatis.vo.Category;

public interface CategoryDao {
	public Category showCategory(int idx);
	public int categoryIdx(String category_name);
    public int insert(Category cvo);
    public int update(HashMap<String, Object> map);
    public int delete(int idx);
}
