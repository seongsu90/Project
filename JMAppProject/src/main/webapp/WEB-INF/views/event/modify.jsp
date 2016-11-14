<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		
		이벤트 수정
		<hr/>
			<form method="post">
				이름 : <input type="text" name="ename" value="${event.ename}"/><br/>	
				식당명 : <input type="text" name="eResid" value="${event.eResid}"/><br/>
				이벤트 사진 : <input type="file" name="esavedfile" value="${event.esavedfile}"/><br/>
				이벤트 정보 : <input type="text" name="einfo" value="${event.einfo}"/><br/>
				이벤트 메뉴 : <input type="text" name="eMlname" value="${event.eMlname}" /><br/>
				이벤트 할인가격 : <input type="text" name="eprice" value="${event.eprice}"/><br/>
				이벤트 시작기간 : <input type="datetime" name="estart" value="${event.estart}"/><br/>
				이벤트 종료기간 : <input type="datetime" name="eend" value="${event.eend}"/><br/>
				
				<input type="submit" value="수정"/>
			</form>
	</body>
</html>