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
<form action="ShowGoodsServlet" method="get"></form>
<table>
	<tr>
		<td align="center">商品名</td>
	</tr>
	<%
		List<Goods> list = (List<Goods>)request.getAttribute("list");
		list = DAOFactory.getIGoodsDAOInstance().findAll();
		if (list != null)
		{
			for (Goods good : list)
			{
	%>
			<tr>
				<td align="center"><a href="detail.jsp?name=<%=good.getName()%>"><%=good.getName() %></a></td>
			</tr>
		<%
			}
		}
		%>
</table>
</body>
</html>