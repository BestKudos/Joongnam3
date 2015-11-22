<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>" />
<script></script>
	<div id="index_aside">
		<input id="first_menu" type="radio" name="tab" checked="checked" />
		<input id="second_menu" type="radio" name="tab" />
		<input id="third_menu" type="radio" name="tab" />
		<input id="forth_menu" type="radio" name="tab" />
		<section class="button">
			<label for="first_menu">자동차</label>
			<label for="second_menu">골프</label>
			<label for="third_menu">바이크</label>
			<label for="forth_menu">등산</label>
		</section>
		<div class="tab_item">
			<ul>
				<c:forEach items="${lu1.hlist}" var="hvo" varStatus="index">
				<li class="item"><a href="hobbyboard.do?totalCount=${lu1.totalCount}&page=1&idx=${hvo.con_no}&category=11&log=${log}">
						<!-- <div class="thumbnail">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription">
							<strong>${hvo.title}</strong>
							<p>${hvo.m_name}</p>
						</div>
				</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="tab_item">
			<ul>
				<c:forEach items="${lu2.hlist}" var="hvo" varStatus="index">
				<li class="item"><a href="hobbyboard.do?totalCount=${lu1.totalCount}&page=1&idx=${hvo.con_no}&category=12&log=${log}">
						<!-- <div class="thumbnail">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription">
							<strong>${hvo.title}</strong>
							<p>${hvo.m_name}</p>
						</div>
				</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="tab_item">
			<ul>
				<c:forEach items="${lu3.hlist}" var="hvo" varStatus="index">
				<li class="item"><a href="hobbyboard.do?totalCount=${lu1.totalCount}&page=1&idx=${hvo.con_no}&category=13&log=${log}">
						<!-- <div class="thumbnail">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription">
							<strong>${hvo.title}</strong>
							<p>${hvo.m_name}</p>
						</div>
				</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="tab_item">
			<ul>
				<c:forEach items="${lu4.hlist}" var="hvo" varStatus="index">
				<li class="item"><a href="hobbyboard.do?totalCount=${lu1.totalCount}&page=1&idx=${hvo.con_no}&category=14&log=${log}">
						<!-- <div class="thumbnail">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription">
							<strong>${hvo.title}</strong>
							<p>${hvo.m_name}</p>
						</div>
				</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
