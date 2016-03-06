package com.board.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.ItemDAO;
import com.board.dto.ItemDTO;
import com.board.util.PageNumber;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/temp/boardList.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPageNo = request.getParameter("pageNo");
		String cate = request.getParameter("cate");
		String pickPlace = request.getParameter("pickPlace");
		String searchText = request.getParameter("searchText");

		int pageNo;
		if(sPageNo != null)
			pageNo = Integer.parseInt(sPageNo);
		else
			pageNo = 1;
		int startNo = (pageNo-1) * 20 + 1;
		int endNo = pageNo * 20;
		itemDAO = new ItemDAO(startNo+"", endNo+"", cate, pickPlace, searchText);
		ArrayList<ItemDTO> item = itemDAO.getItemList();
		int totalCount = itemDAO.getTotalCount();
		PageNumber pageNumber = new PageNumber();
		String pageString = pageNumber.getPageNumber(itemDAO.getTotalCount(), pageNo, cate, pickPlace, searchText);
		
		request.setAttribute("item", item);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("cate", cate);
		request.setAttribute("pickPlace", pickPlace);
		request.setAttribute("searchText", searchText);
		request.setAttribute("pageString", pageString);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/board/boardList.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
