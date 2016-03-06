package com.board.dao;

import com.board.parsing.Parsing;

public class ImageUrlDAO{

	private String item;
	/**
	 * @param args
	 */
	public ImageUrlDAO() {
	}
	public ImageUrlDAO(String strId) {
		strId += "/";
		String query = Parsing.ITEM_IMEAGEURL + "1/5/" + strId;
		Parsing parsing = new Parsing(query);
		parsing.setType("image");
		parsing.start();
		
		while (true) {
			if (parsing.istSwitch() == true) {
				break;
			}
		}
		
		item = parsing.getImageURL();
	}
	
	public String getImageUrl() {
		
		
		return item;
	}
}
