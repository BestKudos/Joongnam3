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
		map.put("start", startNo);	// 시작 번호
		map.put("end", endNo);		// limit 제한
		lu.setList(service.showList(map));
		return lu;
	}
}
