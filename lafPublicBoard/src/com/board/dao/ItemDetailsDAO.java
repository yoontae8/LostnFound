package com.board.dao;

import com.board.dto.ItemDetailsDTO;
import com.board.parsing.Parsing;

public class ItemDetailsDAO {

	private ItemDetailsDTO item;
	/**
	 * @param args
	 */
	public ItemDetailsDAO() {
	}
	public ItemDetailsDAO(String strId) {
		strId += "/";
		String query = Parsing.ITEM_INFO + "1/5/" + strId;
		Parsing parsing = new Parsing(query);
		parsing.setType("info");
		parsing.start();
		
		while (true) {
			if (parsing.istSwitch() == true) {
				break;
			}
		}
		
		item = parsing.getItemDetails();
	}
	
	public ItemDetailsDTO getItemDetails() {
			
		return item;
	}
}
