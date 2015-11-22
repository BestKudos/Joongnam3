package mybatis.service;

import java.util.HashMap;

import mybatis.vo.HobbyBoard;

public interface HobbyBoardService {
	HobbyBoard showBoard(HashMap<String, Integer> map);
	public int min(int idx);
	public int max(int idx);
    public int insert(HobbyBoard hvo);
    public int update(HashMap<String, Object> map);
    public int delete(int idx);
}
