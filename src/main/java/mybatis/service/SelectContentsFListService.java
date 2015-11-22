package mybatis.service;

import java.util.HashMap;

import mybatis.util.ListUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SelectContentsFListService {
	@Autowired
	HobbyBoardListServiceImpl service;
	
	public ListUtil getList(int cate){
		int totalCount = service.getCount(cate);
		int pageSize = 4;
		ListUtil lu = new ListUtil(totalCount, pageSize, 1);
		int startNo = lu.getStartNo()-1;
		int endNo = lu.getPageSize();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", startNo);	// ���� ��ȣ
		map.put("end", endNo);		// limit ����
		map.put("category_no", cate);
		lu.setHlist(service.showList(map));
		return lu;
	}
}
