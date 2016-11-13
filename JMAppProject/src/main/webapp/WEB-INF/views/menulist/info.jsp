<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		
		메뉴리스트 정보
		<hr/>
		<table style="width:570px text-align=center;">
		    <tr>
				<td style="background-color:blue; width:100px">메뉴 이름</td>
				<td>${event.mlname}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">메뉴 가격</td>	
				<td>${event.mlprice}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">식당</td>
				<td>${event.mlResid}</td>
			</tr>	
			<tr>
				<td style="background-color:orange; width:100px">정보</td>
				<td>${event.mlinfo}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">메뉴 사진</td>
				<td>${event.mlsavedfile}</td>
			</tr>
	</body>
</html>