<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	<body> 
	식당 수정
	<hr/>
	<form method="post"  enctype="multipart/form-data">
		<input type="hidden" name="mresid" value="${member.mresid}">
		
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
		<td style="background-color:orange; width:70px">식당 전체 테이블 수</td>
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
				<td style="background-color:#9966FF; width:70px">사진</td>
				<td><img src="showPhoto?ressavedfile=${restaurant.ressavedfile}" width="50px"/></td>
			</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 사진</td>
		<td><input type="file" name="resphoto"/></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 휴일</td>
		<td>
		<input type="checkbox" name="rescloseday" value="월요일" >월요일
			          <input type="checkbox" name="rescloseday" value="화요일" >화요일
			          <input type="checkbox" name="rescloseday" value="수요일" >수요일
			          <input type="checkbox" name="rescloseday" value="목요일" >목요일
			          <input type="checkbox" name="rescloseday" value="금요일" >금요일
			          <input type="checkbox" name="rescloseday" value="토요일" >토요일
			          <input type="checkbox" name="rescloseday" value="일요일" >일요일 <br/> 
		
		</td>
		</tr>
		
		</table>
		
		<input type="submit" value="수정하기"/>
	</form>
	</body>
</html>