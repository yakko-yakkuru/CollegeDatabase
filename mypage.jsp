<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD> 
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>MYPAGE</TITLE>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="style.css" type="text/css">

</HEAD>
<BODY>
<div align="center">
<h1 class = "br3">MY PAGE</h1>

<!--ユーザー情報の表示-->
<p class = "br2">
ユーザー情報
</p>
<p class = "br4">
<table class="type01">
	<tr>
		<th scope="row">UserID</th>
		<td> <%=Id%> </td>
	</tr>
</table>
</p>

<!--お気に入り情報の表示-->

<p class ="br"><a href="index.html">LOGOUT</a></p>
<p><a href="Serchindex.html">検索Topへ戻る</a></p>

</div>
</BODY>
</HTML>
