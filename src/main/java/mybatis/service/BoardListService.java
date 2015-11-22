package mybatis.service;

import java.util.HashMap;
import java.util.List;

import mybatis.vo.Board;

public interface BoardListService {
	List<Board> showList(HashMap<String, Integer> map);
	int getCount();
}
