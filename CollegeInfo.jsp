<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="design.Search" %>
<%@ page import="design.*" %>
<%@ page import= "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<% 
	
	//テスト用
	String get = new String(request.getParameter("cName").getBytes("ISO-8859-1"));
	String deResult = java.net.URLDecoder.decode(get,"UTF-8");
	
	
	Search search = new Search();
	search.Connect();
	search.setWord(deResult);
	search.AccessCount(deResult);
	
	//大学情報の取得・表示
	search.searchRecord(1,"College");
	search.toNext();
	%>
	<div align="center">
	<p><%=search.getRecord("Name")%></p>
	<p><%=search.getRecord("NorP")%></p>
	<p>試験科目：<%=search.getRecord("Exam")%></p>
	<p>偏差値：<%=search.getRecord("Border")%></p>
	<p>アクセス数：<%=search.getRecord("Access")%></p>
	
	<%
	//学科情報の取得・表示
	search.searchRecord(1,"Class");
	search.toNext();
	while(search.getRecord("Name")!=""){
	%>
	
	<p><%=search.getRecord("Class") %></p>
	<p><%=search.getRecord("Border") %></p>
	
	<%
	search.toNext();
	}
	
	//大学の位置情報等の取得・表示
	/*
	search.searchRecord(1,"Address");
	search.toNext();
	%>
	
	<p><%=search.getRecord("Address") %></p>
	<p><%=search.getRecord("Tell") %></p>
	<p><%=search.getRecord("Mail") %></p>
	</div>
	<%
	*/
	search.CloseConnect();
	
	//out.println(deResult);
	/*サーバ用
	String deResult = java.net.URLDecoder.decode(request.getParameter("cName"),"UTF-8");
	out.println(deResult);
	*/
	%>
	
</body>
</html>