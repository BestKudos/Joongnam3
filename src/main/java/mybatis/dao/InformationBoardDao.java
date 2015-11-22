package mybatis.dao;

import java.util.HashMap;

import mybatis.vo.InformationBoard;

public interface InformationBoardDao {
	InformationBoard showBoard(HashMap<String, Integer> map);
	public int min(int idx);
	public int max(int idx);
    public int insert(InformationBoard ivo);
    public int update(HashMap<String, Object> map);
    public int delete(int idx);
}
