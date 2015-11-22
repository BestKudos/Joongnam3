<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/css/contents_second.css"/>" />
	<div id="index_aside2">
		<input id="first_menu2" type="radio" name="tab2" checked="checked" />
		<!-- <input id="second_menu2" type="radio" name="tab2" />
		<input id="third_menu2" type="radio" name="tab2" />
		<input id="forth_menu2" type="radio" name="tab2" /> -->
		<section class="button2">
			<label for="first_menu2">자유공간</label>
			<!-- <label for="second_menu2">Second</label>
			<label for="third_menu2">Third</label>
			<label for="forth_menu2">Forth</label> -->
		</section>
		<div class="tab_item2">
			<ul>
				<c:forEach items="${luF.list}" var="vo" varStatus="index">
				<li class="item"><a href="board.do?totalCount=${luF.totalCount}&page=1&idx=${vo.con_no}&category=31&log=${log}">
						<!-- <div class="thumbnail">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription">
							<strong>${vo.title}</strong>
							<p>${vo.m_name}</p>
						</div>
				</a></li>
				</c:forEach>
			</ul>
		</div>
		<%-- <div class="tab_item2">
			<ul>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>두번째 1</strong>
							<p>내용 1</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>두번째 22222222222222</strong>
							<p>내용 2</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>두번째 3</strong>
							<p>내용 33333333333333</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>두번째 4</strong>
							<p>내용 4</p>
						</div>
				</a></li>
			</ul>
		</div>
		<div class="tab_item2">
			<ul>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>세번째 1</strong>
							<p>내용 1111111111111111</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>세번째 2</strong>
							<p>내용 2</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>세번째 3</strong>
							<p>내용 3</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>세번째 444444444444444</strong>
							<p>내용 4</p>
						</div>
				</a></li>
			</ul>
		</div>
		<div class="tab_item2">
			<ul>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>네번째 1</strong>
							<p>내용 1111111111111111</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>네번째 2</strong>
							<p>내용 2</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>네번째 3</strong>
							<p>내용 3</p>
						</div>
				</a></li>
				<li class="item2"><a href="#">
						<!-- <div class="thumbnail2">
							<img src="http://placehold.it/45x45" />
						</div> -->
						<div class="discription2">
							<strong>네번째 444444444444444</strong>
							<p>내용 4</p>
						</div>
				</a></li>
			</ul>
		</div> --%>
	</div>
