package mybatis.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.dao.BoardListDao;
import mybatis.vo.Board;

@Repository
public class BoardListServiceImpl implements BoardListService{
	@Autowired
	BoardListDao dao;

	@Override
	public List<Board> showList(HashMap<String, Integer> map) {
		return dao.showList(map);
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}

}
