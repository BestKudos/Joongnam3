package mybatis.service;

import java.util.HashMap;

import mybatis.dao.HobbyBoardDao;
import mybatis.vo.HobbyBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HobbyBoardServiceImpl implements HobbyBoardService {
	
	@Autowired
	HobbyBoardDao hobbyboardDao;

	@Override
	public HobbyBoard showBoard(HashMap<String, Integer> map) {
		return hobbyboardDao.showBoard(map);
	}

	@Override
	public int min(int idx) {
		return hobbyboardDao.min(idx);
	}

	@Override
	public int max(int idx) {
		// TODO Auto-generated method stub
		return hobbyboardDao.max(idx);
	}

	@Override
	public int insert(HobbyBoard hvo) {
		return hobbyboardDao.insert(hvo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return hobbyboardDao.update(map);
	}

	@Override
	public int delete(int idx) {
		return hobbyboardDao.delete(idx);
	}

}
