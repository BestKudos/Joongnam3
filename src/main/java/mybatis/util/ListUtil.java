package mybatis.util;

import java.util.List;

import mybatis.vo.Board;
import mybatis.vo.HobbyBoard;
import mybatis.vo.InformationBoard;


public class ListUtil {
	private List<Board> list;
	private List<HobbyBoard> hlist;
	private List<InformationBoard> ilist;
	private int totalCount;
	private int pageSize; 	
	private int currentPage;	
	
	private int totalPage;   
	private int startNo; 	
	private int endNo; 		
	private int startPage; 		
	private int endPage; 		
	
	public ListUtil(int totalCount, int pageSize, int currentPage) {
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		
		calcPage();
		
	}

	private void calcPage() {
		totalPage = (totalCount -1)/pageSize + 1;
		if(currentPage>totalPage || currentPage<1) currentPage=1;
		
		startNo = (currentPage-1) * pageSize + 1;
		endNo = startNo + pageSize -1;
		if(endNo>totalCount) endNo = totalCount;
		
		startPage = (currentPage-1)/pageSize * pageSize + 1;
		endPage = startPage + pageSize -1;
		if(endPage>totalPage) endPage = totalPage;
	}

	public List<Board> getList() {
		return list;
	}

	public void setList(List<Board> list) {
		this.list = list;
	}

	public List<HobbyBoard> getHlist() {
		return hlist;
	}

	public void setHlist(List<HobbyBoard> hlist) {
		this.hlist = hlist;
	}

	public List<InformationBoard> getIlist() {
		return ilist;
	}

	public void setIlist(List<InformationBoard> ilist) {
		this.ilist = ilist;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcPage();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		calcPage();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		calcPage();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
}
