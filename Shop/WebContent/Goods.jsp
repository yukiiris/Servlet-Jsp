<%@page import="com.shop.vo.Goods"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.dao.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品</title>
</head>
<body>
<%
	request.setCharacterEncoding("GBK");
%>
<table>
	<tr>
		<td>商品名</td>
		<td>价格</td>
		<td>简介</td>
	</tr>
	<%
		DAOFactory factory = new DAOFactory();
		List<Goods> list = DAOFactory.getIGoodsDAOInstance().findAll();
		for (Goods good : list)
		{
	%>
		<tr>
			<td><%=good.getName() %></td>	
			<td><%=good.getPrice() %></td>
			<td><%=good.getIntroduction() %></td>
		</tr>
		<%
		}
		%>
</table>
</body>
</html>