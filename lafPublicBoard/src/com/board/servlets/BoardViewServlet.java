package com.board.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.ImageUrlDAO;
import com.board.dao.ItemDetailsDAO;
import com.board.dto.ItemDetailsDTO;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/temp/boardView.do")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemDetailsDAO itemDetailsDAO;
    private ImageUrlDAO imageUrlDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pageNo = request.getParameter("pageNo");
		String cate = request.getParameter("cate");
		String pickPlace = request.getParameter("pickPlace");
		String searchText = request.getParameter("searchText");

		itemDetailsDAO = new ItemDetailsDAO(id);
		ItemDetailsDTO item = itemDetailsDAO.getItemDetails();
		
		imageUrlDAO = new ImageUrlDAO(id);
		String url = imageUrlDAO.getImageUrl();
		
		request.setAttribute("id", id);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("cate", cate);
		request.setAttribute("pickPlace", pickPlace);
		request.setAttribute("searchText", searchText);
		request.setAttribute("item", item);
		request.setAttribute("url", url);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/board/boardView.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
