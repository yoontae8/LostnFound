package com.board.dao;

import java.util.ArrayList;

import com.board.dto.ItemDTO;
import com.board.dto.ItemDetailsDTO;

public interface BoardDAOImpl {
	
	public String getImageUrl(String strId);
	
	public int getTotalCount(String startSize, String endSize, String strKind, String strPlace, String searchText);
	
	public ArrayList<ItemDTO> getItemList(String startSize, String endSize, String strKind, String strPlace, String searchText);
	
	public ItemDetailsDTO getItemDetails(String strId);
	

}
