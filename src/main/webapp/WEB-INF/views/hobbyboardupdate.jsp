<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>글 수정</title>
<script type="text/javascript">
	function formchk() {
		f = document.uform;
		if (!f.uboard_pass.value) {
			alert('암호는 반드시 입력해야합니다.');
			f.uboard_pass.focus();
			return false;
		}
		if (!f.utitle.value) {
			alert('글제목은 반드시 입력해야합니다.');
			f.utitle.focus();
			return false;
		}
		if (!f.ucontent.value) {
			alert('내용은 반드시 입력해야합니다.');
			f.ucontent.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form action="hobbyboardlist.do?confirm=2&page=${currentPage}&idx=${currentIdx}&category=${category.category_no}" method="post" name="uform"
		onsubmit="return formchk()" style="margin-top: 5%;">
<table align="center" width="80%" border="1">
	<tr>
		<td>작성자</td>
		<td><input type="hidden" name="uname" value="${bo.m_name}">${bo.m_name}</td>
		<td>작성일</td>
		<td><input type="hidden" name="uwrite_date" value="${bo.update_at}">${bo.update_at}</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="uboard_pass" style="width: 99%;">
		</td>
		<td>분류</td>
		<td>${category.category_name}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="3">
			<input type="text" name="utitle" style="width: 99%;" value="${bo.title}">
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<textarea name="ucontent" rows="20" cols="100" style="color: black">${bo.content}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="submit" style="float: right; margin-right: 1%;" value="수정">
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