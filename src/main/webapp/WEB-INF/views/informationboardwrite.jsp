<%@page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String today = formatter.format(new Date());
%>
<title>글쓰기</title>
<script type="text/javascript">
	function formchk() {
		f = document.wform;
		if (!f.board_pass.value) {
			alert('암호는 반드시 입력해야합니다.');
			f.board_pass.focus();
			return false;
		}
		if (!f.title.value) {
			alert('글제목은 반드시 입력해야합니다.');
			f.title.focus();
			return false;
		}
		if (!f.content.value) {
			alert('내용은 반드시 입력해야합니다.');
			f.content.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form action="informationboardlist.do?log=${log }&confirm=1&m_no=${user.userSeq }" method="post" name="wform"
		onsubmit="return formchk()" style="margin-top: 5%;">
<table align="center" width="80%" border="1">
	<tr>
		<td>작성자</td>
		<td><input type="hidden" name="name" value="${user.userName }">${user.userName }</td>
		<td>작성일</td>
		<td><input type="hidden" name="write_date" value="<%=today%>"><%=today %></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="board_pass" style="width: 99%;">
		</td>
		<td>분류</td>
		<td><input type="hidden" name="category" value="${category.category_no }">${category.category_name }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="3">
			<input type="text" name="title" style="width: 99%;">
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<textarea name="content" rows="20" cols="100" style="color: black"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="submit" style="float: right; margin-right: 1%;" value="글쓰기">
		</td>
	</tr>
	<tr>
		<td colspan="4"></td>
	</tr>
	<tr></tr>
</table>
</form>
</body>
</html>