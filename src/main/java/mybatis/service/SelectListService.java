package mybatis.service;

import java.util.HashMap;

import mybatis.util.ListUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SelectListService {
	@Autowired
	BoardListServiceImpl service;
	
	public ListUtil getList(int page){
		int totalCount = service.getCount();
		int pageSize = 10;
		ListUtil lu = new ListUtil(totalCount, pageSize, page);
		int startNo = lu.getStartNo()-1;
		int endNo = lu.getPageSize();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", startNo);	// ���� ��ȣ
		map.put("end", endNo);		// limit ����
		lu.setList(service.showList(map));
		return lu;
	}
}
