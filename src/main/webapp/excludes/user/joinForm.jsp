<%@ include file="../include/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript"
	src="<c:url value="/resources/js/joinCheck.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/joinAjaxData.js"/>"></script>
<link href="<c:url value="/resources/css/loading.css"/>"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<c:url value="/resources/js/loading.js"/>"></script>
<body>
	<div id="loadingImage">
		<img src="<c:url value="/resources/img/loading.gif"/>">
	</div>
	<div id="loadingMask"></div>
	<form id="ajaxSubmit" name="ajaxSubmit" method="post"
		action="javascript:ajaxPostSend();">
		<table width="100%" height="30px" border="0" cellpadding="0px"
			cellspacing="0px" align="center">
			<tr>
				<td bgcolor="#FFFFFF" style="width: 20%; height: 30px;"></td>
				<td bgcolor="#FFFFFF" style="width: 60%; height: 30px;"><font
					size="5" style="font-weight: bolder; color: #BDBDBD;">Joongnam3</font>
				</td>
				<td bgcolor="#FFFFFF" style="width: 20%; height: 30px;"></td>
			</tr>
		</table>
		<table width="100%" height="70" border="0" cellpadding="0px"
			cellspacing="0px">
			<tr>
				<td bgcolor="#1DDB16" style="width: 100%; height: 5px;" colspan="3"></td>
			</tr>
			<tr>
				<td bgcolor="#353535" style="width: 20%; height: 65px;"></td>
				<td bgcolor="#353535" style="width: 60%; height: 65px;"><font
					size="5" style="font-weight: bolder; color: #FFFFFF;">회원></font> <font
					size="5" style="font-weight: bolder; color: #ABF200;">회원가입</font></td>
				<td bgcolor="#353535" style="width: 20%; height: 65px;"></td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" style="width: 100%; height: 50px;" colspan="3"></td>
			</tr>
		</table>
		<div style="text-align: center;">
			<div style="border: 1px solid black; width: 65%; text-align: left;">
				<table id="member_wrap">
					<tbody>
						<tr>
							<td class="lb">* 아이디</td>
							<td><input type="text" id="id" name="id"
								style="width: 130px;" onkeyup="javascript:idCheck()"
								onchange="javascript:overlapCheck()" /></td>
							<td id="idCheckTD">${idmsg }</td>
						</tr>
						<tr>
							<td class="lb">* 비밀번호</td>
							<td><input type="password" id="password" name="password"
								style="width: 130px;" value="" /></td>
							<td></td>
						</tr>
						<tr>
							<td class="lb">* 비밀번호 확인</td>
							<td><input type="password" id="password2" name="password2"
								style="width: 130px;" onkeyup="javascript:passwordCheck()"
								value="" /></td>
							<td id="passwordCheckTD"></td>
						</tr>
						<tr>
							<td class="lb">* 이름</td>
							<td><input type="text" id="name" name="name"
								style="width: 130px;" value="" /></td>
							<td></td>
						</tr>
						<tr>
							<td class="lb">* 생년월일</td>
							<td><input type="text" id="birthday" name="birthday"
								style="width: 130px;" value="" /></td>
							<!-- <td><input type="text" name="memBirth01" size="4" maxlength="4">년</td>
  					<td><input type="text" name="memBirth02" size="3" maxlength="2">월</td>
                    <td><input type="text" name="memBirth03" size="3" maxlength="2">일</td> -->
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<table cellpadding="0" cellspacing="0" align="center">
			<tr height="5px">
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="가입" tabindex="3"
					style="width: 100px; height: 30px; border-color: #FFFFFF; background-color: #8C8C8C; font-size: 15pt; font-weight: bold; font-family: 굴림; color: #FFFFFF; vertical-align: middle; text-align: center;">
					<input type="button" value="취소" tabindex="3" onclick="loginForm"
					style="width: 100px; height: 30px; border-color: #FFFFFF; background-color: #8C8C8C; font-size: 15pt; font-weight: bold; font-family: 굴림; color: #FFFFFF; vertical-align: middle; text-align: center;">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
