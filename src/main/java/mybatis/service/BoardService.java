package mybatis.service;

import java.util.HashMap;

import mybatis.vo.Board;

public interface BoardService {
	Board showBoard(int idx);
	public int min();
	public int max();
    public int insert(Board vo);
    public int update(HashMap<String, Object> map);
    public int delete(int idx);
}
