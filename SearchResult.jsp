<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="design.Search" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>
</head>
<body>
	<%
		
	Search sr = (Search)request.getAttribute("search"); 
	sr.Connect();
	sr.searchRecord(0,"College");
	
	String record;
	
	while(true){
		sr.toNext();
		record = (String)sr.getRecord("Name");
		if(record != ""){
	%>
	<div align="center">
	<p>
	<a href="CollegeInfo.jsp?cName=<%=java.net.URLEncoder.encode(record,"UTF-8")%>">
	<%=record %> 
	</a>
	</p>
	
	<%
		}else{
			break;
		}
	}
	sr.CloseConnect();
	%>
	
	<a class="button" href="Searchindex.html">検索TOPに戻る</a>

<form method="POST" action="SortServlet">
<select name="sort">
	<option value="agree">一致度順</option>
	<option value="major">閲覧が多い順</option>
	<option value="minor">閲覧が少ない順</option>
</select>
<input type="image" src="sort.png" width="20" height="20" value="ソート">
</form>

</div>

</body>
</html>