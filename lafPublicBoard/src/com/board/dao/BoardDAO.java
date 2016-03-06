package com.board.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.board.dto.ItemDTO;
import com.board.dto.ItemDetailsDTO;
import com.board.parsing.Parsing;

public class BoardDAO implements BoardDAOImpl {
	private String url;

	@Override
	public String getImageUrl(String strId) {
		// TODO Auto-generated method stub
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
		
		
		return parsing.getImageURL();
	}

	@Override
	public int getTotalCount(String startSize, String endSize, String strKind,
			String strPlace, String searchText) {
		// TODO Auto-generated method stub
		String strSize = startSize + "/" + endSize + "/";
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
		
		String query = Parsing.SEARCH_ITEM + strSize + strKind + strPlace + searchText;;
		Parsing parsing = new Parsing(query);
		parsing.setType("search");
		parsing.start();
		
		while (true) {
			if (parsing.istSwitch() == true) {
				break;
			}
		}
		
		return parsing.getTotalCount();

	}

	@Override
	public ArrayList<ItemDTO> getItemList(String startSize, String endSize, String strKind, String strPlace, String searchText) {
		// TODO Auto-generated method stub
		String strSize = startSize + "/" + endSize + "/";
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
		
		String query = Parsing.SEARCH_ITEM + strSize + strKind + strPlace + searchText;;
		Parsing parsing = new Parsing(query);
		parsing.setType("search");
		parsing.start();
		
		while (true) {
			if (parsing.istSwitch() == true) {
				break;
			}
		}
		
		return parsing.getItem();
	}

	@Override
	public ItemDetailsDTO getItemDetails(String strId) {
		// TODO Auto-generated method stub
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
		
		return parsing.getItemDetails();
	}

}
