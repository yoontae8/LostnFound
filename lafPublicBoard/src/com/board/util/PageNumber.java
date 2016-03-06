package com.board.util;

public class PageNumber {
	
	public PageNumber(){};
	
	public String getPageNumber(int totalCount, int pageNo, String cate, String pickPlace, String searchText) {
		int listCount = 20;
		int pagePerBlock = 5;
		StringBuffer sb = new StringBuffer();
		// 페이지 네비게이터
		if(totalCount > 0) {
			int totalNumOfPage = (totalCount % listCount == 0) ? 
					totalCount / listCount :
					totalCount / listCount + 1;
			
			int totalNumOfBlock = (totalNumOfPage % pagePerBlock == 0) ?
					totalNumOfPage / pagePerBlock :
					totalNumOfPage / pagePerBlock + 1;
			
			int currentBlock = (pageNo % pagePerBlock == 0) ? 
					pageNo / pagePerBlock :
					pageNo / pagePerBlock + 1;
			
			int startPage = (currentBlock - 1) * pagePerBlock + 1;
			int endPage = startPage + pagePerBlock - 1;
			
			if(endPage > totalNumOfPage)
				endPage = totalNumOfPage;
			boolean isNext = false;
			boolean isPrev = false;
			if(currentBlock < totalNumOfBlock)
				isNext = true;
			if(currentBlock > 1)
				isPrev = true;
			if(totalNumOfBlock == 1){
				isNext = false;
				isPrev = false;
			}
			if(pageNo > 1){
				sb.append("<a href=\"").append("boardList.do?pageNo=1&cate="+cate+"&pickPlace="+pickPlace+"&searchText="+searchText);
				sb.append("\" title=\"<<\"><<</a>&nbsp;");
			}
			if (isPrev) {
				int goPrevPage = startPage - pagePerBlock;			
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList.do?pageNo="+goPrevPage+"&cate="+cate+"&pickPlace="+pickPlace+"&searchText="+searchText);
				sb.append("\" title=\"<\"><</a>");
			} else {
				
			}
			for (int i = startPage; i <= endPage; i++) {
				if (i == pageNo) {
					sb.append("&nbsp;<strong>").append(i).append("</strong>&nbsp;&nbsp;");
				} else {
					sb.append("&nbsp;<a href=\"").append("boardList.do?pageNo="+i+"&cate="+cate+"&pickPlace="+pickPlace+"&searchText="+searchText);
					sb.append("\" title=\""+i+"\">").append(i).append("</a>&nbsp;&nbsp;");
				}
			}
			if (isNext) {
				int goNextPage = startPage + pagePerBlock;

				sb.append("<a href=\"").append("boardList.do?pageNo="+goNextPage+"&cate="+cate+"&pickPlace="+pickPlace+"&searchText="+searchText);
				sb.append("\" title=\">\">></a>");
			} else {
				
			}
			if(totalNumOfPage > pageNo){
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList.do?pageNo="+totalNumOfPage+"&cate="+cate+"&pickPlace="+pickPlace+"&searchText="+searchText);
				sb.append("\" title=\">>\">>></a>");
			}
		}
		return sb.toString();
		
	}
}
