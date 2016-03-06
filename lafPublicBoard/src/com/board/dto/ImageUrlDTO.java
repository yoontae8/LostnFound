package com.board.dto;

public class ImageUrlDTO {

	String id;
	String image_url;

	public ImageUrlDTO(String id, String image_url) {
		this.id = id;
		this.image_url = image_url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub

		ImageUrlDTO data = (ImageUrlDTO) o;

		if (data.getId().equals(this.getId())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return "분실물 ID : " + id + ", 이미지 URL : " + image_url;

	}

}
