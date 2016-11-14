<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			.list {
				text-align: right;
				background-color: #ffccff;
				padding: 5px 5px;
				width: 100px;
			}
			
			.content {
				text-align: left;
				padding-left: 5px;
			}
		</style>
	</head>
	<body>
		<b>회원 정보</b>
		<hr/>
			<table>
				<tr>
					<td class="list">아이디 </td>
					<td class="content"><input type="text" name="mid" value="${member.mid}" readonly/></td>
				</tr>
				
				<tr>
					<td class="list">이름 </td>
					<td class="content"><input type="text" name="mname" value="${member.mname}" readonly/></td>
				</tr>
				
				<tr>
					<td class="list">휴대전화 </td>
					<td class="content"><input type="tel" name="mphone" value="${member.mphone}" readonly/></td>
				</tr>
				
				<tr>
					<td class="list">생일 </td>
					<td class="content"><input type="date" name="mbirth" value="${member.mbirth}" readonly/></td>
				</tr>
				
				<tr>
					<td class="list">관심지역 </td>
					<td class="content"><input type="text" name="mlocation" value="${member.mlocation}"/></td>
				</tr>
				
				<tr>
					<td class="list">적립 포인트 </td>
					<td class="content">${member.mpoint}</td>
				</tr>
				
				<c:if test="${member.mresid==1}">
					<tr>
						<td class="list">보유 Restaurant </td>
						<td class="content">${member.mresid}</td>
					</tr>
				</c:if>
			</table>
			<br/>
			
			<a href="/ourapp/member/modifyInfo?mid=${login}"><input type="button" value="수정하기"/><br/></a>
	</body>
</html>