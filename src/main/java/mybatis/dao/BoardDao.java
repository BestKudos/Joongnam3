package mybatis.dao;

import java.util.HashMap;

import mybatis.vo.Board;

public interface BoardDao {
	Board showBoard(int idx);
	public int min();
	public int max();
    public int insert(Board vo);
    public int update(HashMap<String, Object> map);
    public int delete(int idx);
}
