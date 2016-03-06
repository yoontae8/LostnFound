package com.board.dto;

public class ItemDTO {

	String id;
	String take_place;
	String name;
	String date;
	String position;

	public ItemDTO() {
		this("0", "0", "0", "0", "0");
	}

	public ItemDTO(String id, String take_place, String name, String date,
			String position) {
		super();
		this.id = id;
		this.take_place = take_place;
		this.name = name;
		this.date = date;
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTake_place() {
		return take_place;
	}

	public void setTake_place(String take_place) {
		this.take_place = take_place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		ItemDTO item = (ItemDTO) o;

		if (item.getId().equals(this.getId())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();

		str.append("분실물 ID : ").append(id).append(", 수령 가능장소 : ")
				.append(take_place).append(", 습득물품명 : ").append(name)
				.append("습득일자 : ").append(date).append(", 습득위치_회사명 : ")
				.append(position);

		return str.toString();

	}

}
