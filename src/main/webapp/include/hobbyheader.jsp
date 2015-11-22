<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<%@ page pageEncoding="UTF-8" %>

<link rel="stylesheet"
	href="<c:url value="/resources/css/hobbyheader.css"/>" />
<header id="hobby_header" style="margin-top: 5%;">
	<hgroup id="hobby_title">
		<h1>${category.category_name }</h1>
	</hgroup>
	<nav id="hobby_lnb">
		<ul>
			<li><a href="hobbyboardlist.do?log=${log }&category=11">자동차</a></li>
			<li><a href="hobbyboardlist.do?log=${log }&category=12">골프</a></li>
			<li><a href="hobbyboardlist.do?log=${log }&category=13">바이크</a></li>
			<li><a href="hobbyboardlist.do?log=${log }&category=14">등산</a></li>
		</ul>
	</nav>
</header>
