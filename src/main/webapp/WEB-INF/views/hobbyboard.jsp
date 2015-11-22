<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>취미게시글 화면</title>
</head>
<body>
	<table align="center" width="80%" border="1" style="margin-top: 5%;">
		<tr>
			<td>작성자</td>
			<td>${boardUser.userName}</td>
			<td>작성일</td>
			<td>${bo.update_at}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" style="width: 99%;"
				disabled="disabled"></td>
			<td>분류</td>
			<td>${category.category_name}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${bo.title}</td>
		</tr>
		<tr>
			<td colspan="4"><textarea rows="20" cols="100" style="color: black">${bo.content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<button
					onclick="location.href='hobbyboarddelete.do?page=${currentPage}&idx=${currentIdx}&category=${category.category_no}&log=${log}'"
					style="float: right; margin-right: 1%;">삭제</button>
				<button
					onclick="location.href='hobbyboardupdate.do?page=${currentPage}&idx=${currentIdx}&category=${category.category_no}&log=${log}'"
					style="float: right; margin-right: 1%;">수정</button>
				<button onclick="location.href='hobbyboardlist.do?page=${currentPage}&category=${category.category_no}&log=${log}'"
					style="float: right; margin-right: 1%;">목록</button>
			</td>
		</tr>
		<tr>
			<td colspan="4"><c:if test="${currentIdx > min}">
					<button
						onclick="location.href='hobbyboard.do?totalCount=${totalCount}&page=${currentPage}&idx=${prevIdx}&category=${category.category_no}&log=${log}'"
						style="float: left; margin-left: 1%;">이전글</button>
				</c:if> <c:if test="${currentIdx < max}">
					<button
						onclick="location.href='hobbyboard.do?totalCount=${totalCount}&page=${currentPage}&idx=${nextIdx}&category=${category.category_no}&log=${log}'"
						style="float: right; margin-right: 1%;">다음글</button>
				</c:if></td>
		</tr>
		<tr></tr>
	</table>
</body>
</html>