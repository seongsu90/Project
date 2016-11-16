<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	<body> 
	글쓰기
	<hr/>
	<form method="post">
		<input type="hidden" name="resid" value="${restaurant.resid}">
		
		<table>
		<tr>
		<td style="background-color:orange; width:70px">식당 이름</td>
		<td><input type="text" name="resname" style="width:600px" value="${restaurant.resname}"></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 위치</td>
		<td><input type="text" name="reslocation" style="width:600px" value="${restaurant.reslocation}"></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 테이블수</td>
		<td><input type="number" name="restotaltable" style="width:600px" value="${restaurant.restotaltable}"></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 정보</td>
		<td><textarea name="resinfo" style="width:600px; height:200px">${restaurant.resinfo}</textarea></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 전화번호</td>
		<td><input type="tel" name="restel" style="width:600px" value="${restaurant.restel}"></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 오픈타임</td>
		<td><input type="time" name="resopen" style="width:600px" value="${restaurant.resopen}"></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 클로즈타임</td>
		<td><input type="time" name="resclose" style="width:600px" value="${restaurant.resclose}"></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">사진</td>
		<td><input type="file" name="resphoto"/></td>
		</tr>
		
		
		</table>
		
		<input type="submit" value="글쓰기"/>
	</form>
	</body>
</html>