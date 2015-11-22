package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import mybatis.vo.Board;

public interface BoardListDao {
	List<Board> showList(HashMap<String, Integer> map);
	int getCount();
}
