package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{

	private int pageNumber;//褰撳墠椤� ---鍓嶅彴浼犻��
	
	private int pageSize;//涓�椤垫樉绀哄灏戞潯鏁版嵁 ---鍚庡彴鑷畾涔�
	
	private int startIndex;//璧峰绱㈠紩涓嬫爣 --- 璁＄畻鍑烘潵
	
	private int totalRecord;//鎬昏褰曟暟---  鏌ヨ鍑烘潵
	
	private int totalPage; //鎬婚〉鏁�  ---  璁＄畻鍑烘潵
	
	private List<T> result;//姣忎竴椤电殑鏁版嵁

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex=(this.getPageNumber()-1)*this.getPageSize();
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage=(this.getTotalRecord()%this.getPageSize()==0?(this.getTotalRecord()/this.getPageSize()):(this.getTotalRecord()/this.getPageSize()+1));
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PageBean [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", startIndex=" + startIndex
				+ ", totalRecord=" + totalRecord + ", totalPage=" + totalPage + ", result=" + result + "]";
	}
	
	
}
