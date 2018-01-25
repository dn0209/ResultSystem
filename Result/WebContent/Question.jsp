<%@page import="com.sys.Operation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<br><br><br>
Virat is Best Player of 2017?
<br><br>
<form action="PrecentageController" method="post">
<input type="submit" value="YES" name="operation">&nbsp;&nbsp;<input type="submit" value="NO" name="operation">
</form>
<%
	Operation operation=new Operation();
	ArrayList<Integer> list=operation.percentage();
	int a[]=new int[2];
	int j=0;
	for(int i:list) {
		a[j]=i;
		j++;
	}
%>
<br><br>
YES : <%=a[0] %> %
<br>
NO : <%=a[1] %> %
</center>
</body>
</html>