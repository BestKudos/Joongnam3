<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<%@ page pageEncoding="UTF-8" %>

<link rel="stylesheet"
	href="<c:url value="/resources/css/informationheader.css"/>" />
<header id="information_header" style="margin-top: 5%;">
	<hgroup id="information_title">
		<h1>${category.category_name }</h1>
	</hgroup>
	<nav id="information_lnb">
		<ul>
			<li><a href="informationboardlist.do?log=${log }&category=21">자동차</a></li>
			<li><a href="informationboardlist.do?log=${log }&category=22">골프</a></li>
			<li><a href="informationboardlist.do?log=${log }&category=23">바이크</a></li>
			<li><a href="informationboardlist.do?log=${log }&category=24">등산</a></li>
		</ul>
	</nav>
</header>
