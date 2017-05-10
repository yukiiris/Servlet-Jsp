<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<script language='Javascript'>
	function validate(f)
	{
		if (!/^\w{5,15}$/.test(f.userid.value)))
		{
			alert("user Id aaaa");
			f.userid.focus();
			return false;
		}
		if (!/^\w{5,15}$/.test(f.userpass.value)))
		{
			alert("user Id aaaa");
			f.userpass.focus();
			return false;
		}
		return true;
	}
</script>
<body>
<h2>Login Page</h2>
<%
	List<String> info = (List<String>)request.getAttribute("info");
	if (info != null)
	{
		Iterator<String> iter = info.iterator();
		while (iter.hasNext())
		{
%>
		<h4><%=iter.next()%></h4>
<%
		}
	}
%>
</body>
</html>