package com.board.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.board.dto.ItemDTO;
import com.board.parsing.Parsing;

public class ItemDAO {

	private String strSize;
	private int totalCount;
	private ArrayList<ItemDTO> item;
	/**
	 * @param args
	 */
	public ItemDAO() {
	}
	public ItemDAO(String startSize, String endSize, String strKind, String strPlace, String searchText) {
		this.strSize = startSize + "/" + endSize + "/";
		strPlace += "/";
				
		try {
			strKind = URLEncoder.encode(strKind, "utf-8");
			if(!"".equals(searchText)) {
				searchText = URLEncoder.encode(searchText, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strKind += "/";
		
		String query = Parsing.SEARCH_ITEM + this.strSize + strKind + strPlace + searchText;;
		Parsing parsing = new Parsing(query);
		parsing.setType("search");
		parsing.start();
		
		while (true) {
			if (parsing.istSwitch() == true) {
				break;
			}
		}
		
		item = parsing.getItem();
		totalCount = parsing.getTotalCount();
		
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public ArrayList<ItemDTO> getItemList() {
		
		return item;
	}
}
