<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	// 파라미터
	String id = request.getParameter("id");

	ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO(id);
	ItemDetailsDTO item = itemDetailsDAO.getItemDetails();
	
	ImageUrlDAO imageUrlDAO = new ImageUrlDAO(id);
	String url = imageUrlDAO.getImageUrl();
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<meta name="viewport" content="width=device-width; initial-scale=1.0" />
<title>게시판 상세보기</title>
<style type="text/css">
	table thead td{
	background: #3A4856;
	padding: 15px 10px;
	color: #fff;
	text-align: center;
	font-weight: normal;
}

table {
	font: 85% "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS",
		sans-serif;
	padding: 0;
	border-collapse: collapse;
	color: #333;
	background: #F3F5F7;
}

table a {
	color: #3A4856;
	text-decoration: none;
	border-bottom: 1px solid #C6C8CB;
}

table a:visited {
	color: #777;
}

table a:hover {
	color: #000;
}

table caption {
	background-color: lightblue;
	color: white;
	text-align: center;
	text-transform: uppercase;
		padding-bottom: 10px;
	font-size: 20px;
	font: 200% "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS",
		sans-serif;
	
}

table tbody,table thead,table tfoot {
	border-left: 1px solid #EAECEE;
	border-right: 1px solid #EAECEE;
}

table tbody, table tfoot{
	border-bottom: 1px solid #EAECEE;
}

table tbody td,table tbody th {
	padding: 10px;
	background: url("http://www.klavina.com/csstablegallery/td_back.gif")
		repeat-x;
	text-align: left;
}

table tbody tr {
	background: #F3F5F7;
}

table tbody tr.odd {
	background: #F0F2F4;
}

table tbody  tr:hover {
	background: #EAECEE;
	color: #111;
}

table tfoot th,table tfoot tr {
	text-align: left;
	font: 120% "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS",
		sans-serif;
	text-transform: uppercase;
	background: #fff;
	padding: 10px;
}


</style>
<script type="text/javascript">
	function goUrl(url) {
		location.href = url;
	}
	
	function img_resize() {
		// 이미지 사이즈 조절 폭이 550px보다 크면 550px로 자동 줄이기. 
		if (eval('document.img' + '.width > 350')) {
			eval('document.img' + '.width = 350');
		}

	}
</script>
</head>
<body onload="img_resize()">
	<table align="center" summary="게시판 상세조회" border="1" >
		<caption>분실물 상세정보</caption>
		<colgroup>
			<col width="150" />
			<col width="150" />
			<col width="150" />
			<col width="150" />
		</colgroup>
		<thead>
			<tr valign="left" nowrap style="padding-left: 6px; line-height: 120%;">
				<th >습득일자</th>
				<th>습득위치/회사명</th>
				<th>습득물품</th>
				<th>연락처</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center"><c:out value="${item.getDate()}"/></td>
				<td align="center"><c:out value="${item.getGetposition()}"/></td>
				<td align="center"><c:out value="${item.getItemname()}"/></td>
				<td align="center"><c:out value="${item.getContact()}"/></td>
			</tr>
			<tr>
				<td colspan="3"><c:out value="${item.getThing()}"/></td>
				<c:choose>
				<c:when test="${url.length() > 1}">
				<td colspan="1" align="center"><a href="<c:url value="${url}"/>"><img src="<c:url value="${url}"/>" name="img"></img></a></td>
				</c:when>
				<c:otherwise>
				<td colspan="1" align="center"><c:out value="사진 없음"/></td>
				</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan=4 align="right">
					<input type="button" value="목록" onclick="goUrl('<c:url value="/boardList.do?pageNo=${pageNo}&amp;cate=${cate}&amp;pickPlace=${pickPlace}&amp;searchText=${searchText}"/>');" />		
				</td>
			</tr>
		</tfoot>
	</table>
		
</body>
</html>