package mybatis.service;

import java.util.HashMap;
import java.util.List;

import mybatis.dao.InformationBoardListDao;
import mybatis.vo.InformationBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InformationBoardListServiceImpl implements InformationBoardListService{
	@Autowired
	InformationBoardListDao idao;

	@Override
	public List<InformationBoard> showList(HashMap<String, Integer> map) {
		return idao.showList(map);
	}

	@Override
	public int getCount(int cate) {
		return idao.getCount(cate);
	}

}
