<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시글 삭제</title>
<script type="text/javascript">
	function formchk() {
		f = document.dform;
		if (!f.dboard_pass.value) {
			alert('암호는 반드시 입력해야합니다.');
			f.dboard_pass.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form action="hobbyboardlist.do?confirm=3&page=${currentPage }&idx=${currentIdx }&category=${category.category_no}&log=${log}" method="post" name="uform"
		onsubmit="return formchk()" style="margin-top: 5%;">
<table align="center" width="40%"  border="1">
	<tr>
		<td>작성자</td>
		<td>${bo.m_name }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="dboard_pass" style="width: 98%;"></td>
	</tr>
	<tr>
		<td>작성일</td>
		<td>${bo.update_at }</td>
	</tr>
	<tr>
		<td>분류</td>
		<td>${category.category_name }</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="확인" style="float: right;"></td>
	</tr>
</table>
</form>
</body>
</html>