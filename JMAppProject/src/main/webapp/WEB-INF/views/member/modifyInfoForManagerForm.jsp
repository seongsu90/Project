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
				width: 150px;
			}
			
			.content {
				text-align: left;
				padding-left: 5px;
			}
		</style>
	</head>
	<body>
		<b>회원 정보 수정</b>
		<hr/>
		
		<form method="post" action="/ourapp/member/modifyInfoForManager">
			
			<table>
				<tr>
					<td class="list">아이디 </td>
					<td class="content"><input type="text" name="mid" value="${member.mid}"></td>
				</tr>
					
				<tr>
					<td class="list">이름 </td>
					<td class="content"><input type="text" name="mname" value="${member.mname}"></td>
				</tr>
				
				<tr>
					<td class="list">비밀번호 </td>
					<td class="content"><input type="text" name="mpassword" value="${member.mpassword}"></td>
				</tr>
				
				<tr>
					<td class="list">휴대전화 </td>
					<td class="content"><input type="tel" name="mphone" value="${member.mphone}"></td>
				</tr>
				
				<tr>
					<td class="list">생일 </td>
					<td class="content"><input type="date" name="mbirth" value="${member.mbirth}"></td>
				</tr>
				
				<tr>
					<td class="list">관심지역 </td>
					<td class="content"><input type="text" name="mlocation" value="${member.mlocation}"/></td>
				</tr>
				
				<tr>
					<td class="list">회원 등급 </td>
					<td class="content"><input type="number" name="mrank" value="${member.mrank}"/></td>
				</tr>
				
				<tr>
					<td class="list">적립 포인트 </td>
					<td class="content"><input type="number" name="mpoint" value="${member.mpoint}"/></td>
				</tr>
				
				<tr>
					<td class="list">보유 레스토랑 id </td>
					<td class="content"><input type="number" name="mresid" value="${member.mresid}"/></td>
				</tr>
			</table>
			<br/>
			
			<input type="submit" value="수정하기"/> <input type="reset" value="초기화"/> &nbsp; <span style="color: red"><b>${error}</b></span> <br/>
		</form>
	</body>
</html>