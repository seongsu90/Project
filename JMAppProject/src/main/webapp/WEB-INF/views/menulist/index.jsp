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
			2. <a href="/ourapp/menulist/modify?mlresid=28&mlname=핫치킨">메뉴리스트 수정</a> <br/>
			3. <a href="/ourapp/menulist/info?mlresid=28&mlname=쌀국수">메뉴 정보</a> <br/>
			4. <a href="/ourapp/menulist/list">메뉴 리스트보기</a> <br/>
			5. <a href="/ourapp/menulist/delete">메뉴 리스트삭제</a> <br/>
			6. <a href="/ourapp/menulist/hotlist?mlresid=28&mlishot=1">핫메뉴리스트 보기</a><br/>
			7. <a href="/ourapp/menulist/hotinfo?mlresid=28&mlname=핫치킨&mlishot=1">핫메뉴 정보</a><br/>
			8. <a href="/ourapp/menulist/modifyhot?mlresid=28&mlname=핫치킨&mlishot=1">핫메뉴 수정</a>
	</body>
</html>