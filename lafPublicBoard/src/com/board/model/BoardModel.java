package com.board.model;

public class BoardModel {
	private int pageNo;
	private String cate;
	private String pickPlace;
	private String searchText;
	private String id;
	
	public BoardModel(){}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getPickPlace() {
		return pickPlace;
	}

	public void setPickPlace(String pickPlace) {
		this.pickPlace = pickPlace;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	};
	
	

}
