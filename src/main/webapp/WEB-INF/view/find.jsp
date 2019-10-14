<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table >
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>价格</td>
				<td>百分比</td>
			</tr>
		<c:forEach items="${list}" var="li">
			
			<tr>
				<td>${li.id}</td>		
				<td>${li.name}</td>		
				<td>${li.fen}</td>		
				<td>${li.bai}</td>		
			</tr>
		</c:forEach>
	
	</table>
	<a href="find?page=${prepage}">上一页</a>
	<a href="find?page=${nextpage}">下一页</a>
</body>
</html>