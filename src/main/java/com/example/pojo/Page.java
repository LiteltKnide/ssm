package com.example.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable{
	private int nowPage = 1;
	private int pageSize = 5;
	private int totalCount;
	private int totalPage;
	private List<T> result = new ArrayList<>();
	public int getNowPage() {
		if (nowPage > getTotalPage()) {
			nowPage = getTotalPage();
		}
		if (nowPage <= 0) {
			nowPage = 1;
		}
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		totalPage = (totalCount / pageSize);
		if (totalCount % pageSize == 0) {
			return totalPage;
		}else {
			return totalPage + 1;
		}
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Page [nowPage=" + nowPage + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", totalPage=" + totalPage
				+ ", result=" + result + "]";
	}
	
	
}
