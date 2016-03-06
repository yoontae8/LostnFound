package com.board.dto;

public class ItemDetailsDTO {

	private String url;
	private String title;
	private String status;
	private String date;
	private String getplace;
	private String thing;
	private String takeplace;
	private String contact;
	private String itmename;
	private String cate;
	private String getposition;
	private String drive_num;
	private String finder;

	public ItemDetailsDTO(String url, String title, String status, String date,
			String getplace, String thing, String takeplace, String contact,
			String itmename, String cate, String getposition, String drive_num,
			String finder) {
		this.url = url;
		this.title = title;
		this.status = status;
		this.date = date;
		this.getplace = getplace;
		this.thing = thing;
		this.takeplace = takeplace;
		this.contact = contact;
		this.itmename = itmename;
		this.cate = cate;
		this.getposition = getposition;
		this.drive_num = drive_num;
		this.finder = finder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGetplace() {
		return getplace;
	}

	public void setGetplace(String getplace) {
		this.getplace = getplace;
	}

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public String getTakeplace() {
		return takeplace;
	}

	public void setTakeplace(String takeplace) {
		this.takeplace = takeplace;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getItemname() {
		return itmename;
	}

	public void setItmename(String itmename) {
		this.itmename = itmename;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getGetposition() {
		return getposition;
	}

	public void setGetposition(String getposition) {
		this.getposition = getposition;
	}

	public String getDrive_num() {
		return drive_num;
	}

	public void setDrive_num(String drive_num) {
		this.drive_num = drive_num;
	}

	public String getFinder() {
		return finder;
	}

	public void setFinder(String finder) {
		this.finder = finder;
	}

}
