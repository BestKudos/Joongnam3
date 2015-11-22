package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import mybatis.vo.HobbyBoard;

public interface HobbyBoardListDao {
	List<HobbyBoard> showList(HashMap<String, Integer> map);
	int getCount(int cate);
}
