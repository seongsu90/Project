<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		
		메뉴리스트
		<hr/>
			1. <a href="/ourapp/menulist/add">메뉴리스트 생성</a><br/>
			2. <a href="/ourapp/menulist/modify?mlresid=4">메뉴리스트 수정</a> <br/>
			3. <a href="/ourapp/menulist/info?mlresid=4&mlname=김밥">메뉴리스트 정보</a> <br/>
			4. <a href="/ourapp/menulist/list">메뉴 리스트보기</a> <br/>
			5. <a href="/ourapp/menulist/delete">메뉴 리스트삭제</a> <br/>
			6. <a href="/ourapp/menulist/hotlist?mlresid=1&mlishot=1">핫메뉴리스트 보기</a><br/>
			7. <a href="/ourapp/menulist/hotinfo?mlresid=1&mlishot=1">핫메뉴 정보</a><br/>
			8. <a href="/ourapp/menulist/modifyhot?mlresid=1&mlishot=1">핫메뉴 수정</a>
	</body>
</html>