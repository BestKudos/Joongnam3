package mybatis.service;

import java.util.HashMap;

import mybatis.dao.InformationBoardDao;
import mybatis.vo.InformationBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InformationBoardServiceImpl implements InformationBoardService {
	
	@Autowired
	InformationBoardDao informationboardDao;

	@Override
	public InformationBoard showBoard(HashMap<String, Integer> map) {
		return informationboardDao.showBoard(map);
	}

	@Override
	public int min(int idx) {
		return informationboardDao.min(idx);
	}

	@Override
	public int max(int idx) {
		// TODO Auto-generated method stub
		return informationboardDao.max(idx);
	}

	@Override
	public int insert(InformationBoard ivo) {
		return informationboardDao.insert(ivo);
	}

	@Override
	public int update(HashMap<String, Object> map) {
		return informationboardDao.update(map);
	}

	@Override
	public int delete(int idx) {
		return informationboardDao.delete(idx);
	}

}
