<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head> 
	<body>
		
		이벤트
		<hr/>
			1. <a href="/ourapp/event/add">이벤트 생성</a><br/>
			2. <a href="/ourapp/event/modify?eresid=${event.eresid}&emlname=${event.emlname}">이벤트 수정</a><br/>
			3. <a href="/ourapp/event/info?eresid=${event.eresid}&emlname=${event.emlname}">이벤트 정보</a>
	</body>
</html>