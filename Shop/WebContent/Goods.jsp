<%@page import="com.shop.vo.Goods"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.dao.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>��Ʒ</title>
</head>
<body>
<%
	request.setCharacterEncoding("GBK");
%>
<table>
	<tr>
		<td>��Ʒ��</td>
		<td>�۸�</td>
		<td>���</td>
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