package com.board.spring;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.dao.BoardDAO;
import com.board.dao.BoardDAOImpl;
import com.board.dao.ImageUrlDAO;
import com.board.dao.ItemDetailsDAO;
import com.board.dto.ItemDTO;
import com.board.dto.ItemDetailsDTO;
import com.board.model.BoardModel;
import com.board.util.PageNumber;



@Controller("boardController")
public class BoardController {
	
		
	@RequestMapping("/boardList.do")
	public String boardList(HttpServletRequest request, BoardModel boardModel, Model model) throws Exception{
		String cate = boardModel.getCate();
		int pageNo = boardModel.getPageNo();
		String pickPlace = boardModel.getPickPlace();
		String searchText = boardModel.getSearchText();

		if(pageNo == 0)
			pageNo = 1;
		int startNo = (pageNo-1) * 20 + 1;
		int endNo = pageNo * 20;
		
		BoardDAOImpl boardDAO = new BoardDAO();
		ArrayList<ItemDTO> item = boardDAO.getItemList(startNo+"", endNo+"", cate, pickPlace, searchText);
		int totalCount = boardDAO.getTotalCount(startNo+"", endNo+"", cate, pickPlace, searchText);
		PageNumber pageNumber = new PageNumber();
		String pageString = pageNumber.getPageNumber(totalCount, pageNo, cate, pickPlace, searchText);
		
		model.addAttribute("item", item);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("cate", cate);
		model.addAttribute("pickPlace", pickPlace);
		model.addAttribute("searchText", searchText);
		model.addAttribute("pageString", pageString);
				
		return "/boardList";
	}
	
	@RequestMapping("/boardView.do")
	public String boardView(HttpServletRequest request, BoardModel boardModel, Model model) throws Exception{
		String id = boardModel.getId();
		int pageNo = boardModel.getPageNo();
		String cate = boardModel.getCate();
		String pickPlace = boardModel.getPickPlace();
		String searchText = boardModel.getSearchText();


		
		
		
		
		BoardDAO boardDAO = new BoardDAO();
		ItemDetailsDTO item = boardDAO.getItemDetails(id);
		
		String url = boardDAO.getImageUrl(id);
		
		model.addAttribute("id", id);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("cate", cate);
		model.addAttribute("pickPlace", pickPlace);
		model.addAttribute("searchText", searchText);
		model.addAttribute("item", item);
		model.addAttribute("url", url);
		
		return "/boardView";
	}
	
}
