<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户注册</title>
</head>
<body>
<%
	request.setCharacterEncoding("GBK");
%>
<%
	List<String> info = (List<String>)request.getAttribute("info");
	if (info != null)
	{
		Iterator<String> iter = info.iterator();
		while (iter.hasNext())
		{
%>
			<h4><%=iter.next() %></h4>
<%
		}
	}
%>

<form action="RegisterServlet" method="post">	
	姓名：<input type="text" name="name"><br>
	密码：<input type="text" name="password"><br>
	再次输入：<input type="text" name="confirm"><br>
	<input type="submit" name="提交">
	<input type="reset" name="重置"> 
</form>
</body>
</html>