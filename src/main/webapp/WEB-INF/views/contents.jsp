<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>메인 콘텐츠</title>
</head>
<body>
<table align="center" width="90%" style="margin-top: 5%;">
	<tr>
		<td colspan="2"><img alt="Main Image" src="<c:url value="/resources/img/mainimage.png"/>" width="480" height="180"></td>
		<td rowspan="2" width = "170" height = "120">
			<div style="text-align: center; border: 1px solid black;"><strong>추천매장</strong></div>
			<div style="border: 1px solid black;"><a href="http://www.jctoday.co.kr"><img alt="Car Image" src="<c:url value="/resources/img/car.png"/>" style = "width : 170; height : 120;"/></a></div>
			<div style="border: 1px solid black;"><a href="http://www.akgolf.co.kr"><img alt="Golf Image" src="<c:url value="/resources/img/golf.png"/>" style = "width : 170; height : 120;"/></a></div>
			<div style="border: 1px solid black;"><a href="http://www.bikemall.net"><img alt="Bike Image" src="<c:url value="/resources/img/bike.png"/>" style = "width : 170; height : 120;"/></a></div>
			<div style="border: 1px solid black;"><a href="http://www.okmall.com"><img alt="Climb Image" src="<c:url value="/resources/img/climb.png"/>" style = "width : 170; height : 120;"/></a></div>
		</td>
	</tr>
	<tr>
		<td>
			<%@ include file="/include/contents_first.jsp" %>
		</td>
		<td>
			<%@ include file="/include/contents_second.jsp" %>
		</td>
	</tr>
</table>
</body>
</html>