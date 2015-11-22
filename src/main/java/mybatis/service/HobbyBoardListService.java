package mybatis.service;

import java.util.HashMap;
import java.util.List;

import mybatis.vo.HobbyBoard;

public interface HobbyBoardListService {
	List<HobbyBoard> showList(HashMap<String, Integer> map);
	int getCount(int cate);
}
