<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판 목록</title>
</head>
<body>
	<%@ include file="/include/informationheader.jsp"%>
	<hr />
	<table align="center" width="90%" border="1" style="margin: 1%">
		<tr align="center">
			<td>ID</td>
			<td>제목</td>
			<td>작성일</td>
			<td>작성자</td>
		</tr>
		<c:if test="${lu.totalCount==0}">
			<tr>
				<td colspan="4" align="center">글이 존재하지 않습니다.</td>
			</tr>
		</c:if>
		<!-- 게시물 생성 -> 리스트화 -->
		<c:if test="${lu.totalCount>0}">
			<c:forEach items="${lu.ilist}" var="ivo" varStatus="index">
				<tr>
					<td align="center">${lu.totalCount-(lu.currentPage-1)*lu.pageSize - index.count+1}</td>
					<td><a
						href="informationboard.do?totalCount=${lu.totalCount}&page=${lu.currentPage}&idx=${ivo.con_no}&category=${category.category_no}&log=${log}">${ivo.title}</a></td>
					<td align="center">${ivo.update_at}</td>
					<td align="center">${ivo.m_name}</td>
				</tr>
			</c:forEach>
		</c:if>

		<tr>
			<td align="center" colspan="4">
				<!-- 이전표시 --> <c:if test="${lu.startPage>lu.pageSize}">
					<a href="?page=${lu.startPage-1}&log=${log}&category=${category.category_no}">이전 </a>
				</c:if> <!-- 페이지 표시 --> <c:forEach var="i" begin="${lu.startPage}"
					end="${lu.endPage}">
					<c:if test="${i!=lu.currentPage}">
					[<a href="?page=${i}&log=${log}&category=${category.category_no}">${i }</a>]
				</c:if>
					<c:if test="${i==lu.currentPage}">
					[${i }]
				</c:if>
				</c:forEach> <!-- 이후표시 --> <c:if test="${lu.endPage<lu.totalPage}">
					<a href="?page=${lu.endPage+1}&log=${log}&category=${category.category_no}"> 이후</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td align="right" colspan="4"><input type="button"
				onclick="location.href='informationboardwrite.do?log=${log}&category=${category.category_no}'"
				value="글쓰기"></td>
		</tr>
	</table>
</body>
</html>