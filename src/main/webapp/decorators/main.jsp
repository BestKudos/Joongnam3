<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ page session="false"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>" />
<title>메인 화면</title>
</head>
<body>
	<header id="index_header">
		<div id="title">
			<a href="contents.do?log=${log }">
				<img alt="Logo" src="<c:url value="/resources/img/smallLogo.png"/>">
			</a>
        </div>

        <nav id="index_gnb">
            <ul>
            	<c:if test="${log==0 }">
	                <li><a href="loginForm.do">로그인</a></li>
	                <li><a href="joinForm.do">회원가입</a></li>
                </c:if>
                <c:if test="${log==1 }">
	                <li>${user.userName }님 </li>
	                <li><a href="contents.do?log=0">로그아웃</a></li>
                </c:if>
            </ul>
        </nav>
        <nav id="index_lnb">
            <ul>
                <li><a href="hobbyboardlist.do?log=${log }&category=11">취미공간</a></li>
                <li><a href="informationboardlist.do?log=${log }&category=21">취미정보</a></li>
                <li><a href="boardlist.do?log=${log }&category=31">자유공간</a></li>
                <!-- <li><a href="#">추천매장</a></li> -->
            </ul>
        </nav>
	</header>
    <hr>
	<div id="content">
		<decorator:body/>
	</div>
	<footer id="footer"></footer>
</body>
</html>