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
			2. <a href="/ourapp/event/list">이벤트 리스트</a><br/>
			3. <a href="/ourapp/event/modify?eresid=${event.eresid}&emlname=${event.emlname}">이벤트 수정</a><br/>
			4. <a href="/ourapp/event/info?eresid=1&emlname=ㄹㅇㄹ">이벤트 정보</a><br/>
			5. <a href="/ourapp/event/delete">이벤트 삭제</a>
	</body>
</html>