<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<meta name="viewport" content="width=device-width; initial-scale=1.0" />
<title>게시판 목록</title>
<style type="text/css">
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
	text-align: left;
	text-transform: uppercase;
	padding-bottom: 10px;
	font: 200% "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS",
		sans-serif;
}

table thead th {
	background: #3A4856;
	padding: 15px 10px;
	color: #fff;
	text-align: left;
	font-weight: normal;
}

table tbody,table thead {
	border-left: 1px solid #EAECEE;
	border-right: 1px solid #EAECEE;
}

table tbody {
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

table tfoot td,table tfoot th,table tfoot tr {
	text-align: center;
	font: 120% "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS",
		sans-serif;
	text-transform: uppercase;
	background: #fff;
	padding: 10px;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<form name="searchForm" action="boardList.do" method="get" >
	<p align="center">
		분류: <select name="cate">
			<option value="지갑" <c:if test="${cate eq '지갑'}">selected="selected"</c:if>>지갑</option>
			<option value="쇼핑백" <c:if test="${cate eq '쇼핑백'}">selected="selected"</c:if>>쇼핑백</option>
			<option value="서류봉투" <c:if test="${cate eq '서류봉투'}">selected="selected"</c:if>>서류봉투</option>
			<option value="가방" <c:if test="${cate eq '가방'}">selected="selected"</c:if>>가방</option>
			<option value="베낭" <c:if test="${cate eq '베낭'}">selected="selected"</c:if>>베낭</option>
			<option value="핸드폰" <c:if test="${cate eq '핸드폰'}">selected="selected"</c:if>>핸드폰</option>
			<option value="옷" <c:if test="${cate eq '옷'}">selected="selected"</c:if>>옷</option>
			<option value="책" <c:if test="${cate eq '책'}">selected="selected"</c:if>>책</option>
			<option value="파일" <c:if test="${cate eq '파일'}">selected="selected"</c:if>>파일</option>
			<option value="기타" <c:if test="${cate eq '기타'}">selected="selected"</c:if>>기타</option>
		</select>
		장소: <select name="pickPlace">
			<option value="b1" <c:if test="${pickPlace eq 'b1'}">selected="selected"</c:if>>버스</option>
			<option value="b2" <c:if test="${pickPlace eq 'b2'}">selected="selected"</c:if>>마을버스</option>
			<option value="t1" <c:if test="${pickPlace eq 't1'}">selected="selected"</c:if>>법인택시</option>
			<option value="t2" <c:if test="${pickPlace eq 't2'}">selected="selected"</c:if>>개인택시</option>
			<option value="s4" <c:if test="${pickPlace eq 's4'}">selected="selected"</c:if>>지하철(9호선)</option>
		</select>
		<input type=text name=searchText />
		<input type="submit" value="검색" />
	</p>
	</form>
	<table align="center" cellpadding="3" >
		<colgroup>
			<col width="60" align="center"/>
			<col width="120" align="center"/>
			<col width="300" align="center"/>
			<col width="150" align="center"/>
			<col width="180" align="center"/>
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>습득 날짜</th>
				<th>습득 물품</th>
				<th>습득 회사</th>
				<th>수령 가능장소</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${totalCount == 0 }">
			<tr><td colSpan = 5 align="center">검색된 정보가 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="board" items="${item}" varStatus="status">
			<tr>
				<td align="center"><c:out value="${totalCount - (pageNo-1)*20 - status.index}"/></td>
				<td><c:out value="${item.get(status.index).getDate()}" /></td>
				<td align="center"><a href="<c:url value="boardView.do?id=${item.get(status.index).getId()}&amp;pageNo=${pageNo}&amp;cate=${cate}&amp;pickPlace=${pickPlace}&amp;searchText=${searchText}"/>"><c:out value="${item.get(status.index).getName()}"/></a></td>
				<td align="center"><c:out value="${item.get(status.index).getPosition()}" /></td>
				<td align="center"><c:out value="${item.get(status.index).getTake_place()}" /></td>
			</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colSpan="5"><c:out value="${pageString}" escapeXml="false"/></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>