package mybatis.service;

import java.util.HashMap;
import java.util.List;

import mybatis.vo.InformationBoard;

public interface InformationBoardListService {
	List<InformationBoard> showList(HashMap<String, Integer> map);
	int getCount(int cate);
}
