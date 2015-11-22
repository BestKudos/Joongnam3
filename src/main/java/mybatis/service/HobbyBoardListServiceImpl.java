package mybatis.service;

import java.util.HashMap;
import java.util.List;

import mybatis.dao.HobbyBoardListDao;
import mybatis.vo.HobbyBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HobbyBoardListServiceImpl implements HobbyBoardListService{
	@Autowired
	HobbyBoardListDao hdao;

	@Override
	public List<HobbyBoard> showList(HashMap<String, Integer> map) {
		return hdao.showList(map);
	}

	@Override
	public int getCount(int cate) {
		return hdao.getCount(cate);
	}

}
