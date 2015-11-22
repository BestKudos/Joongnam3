package mybatis.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.dao.BoardDao;
import mybatis.vo.Board;

@Repository
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public Board showBoard(int idx) {
		return boardDao.showBoard(idx);
	}

	@Override
	public int min() {
		return boardDao.min();
	}

	@Override
	public int max() {
		return boardDao.max();
	}

	@Override
	public int insert(Board vo) {
		return boardDao.insert(vo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return boardDao.update(map);
	}

	@Override
	public int delete(int idx) {
		return boardDao.delete(idx);
	}

}
