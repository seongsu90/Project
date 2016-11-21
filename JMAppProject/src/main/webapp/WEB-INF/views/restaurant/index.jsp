<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	<body> 
		Restaurant 메인 화면
		<hr/>		
		
              ※<a href="/ourapp/restaurant/list">음식점 리스트보기</a><br/>
    <c:if test="${mrank==1}">
   	      ※<a href="/ourapp/restaurant/add">음식점추가하기</a><br/>	
	      ※<a href="/ourapp/restaurant/delete">음식점삭제하기</a><br/> -->
    </c:if>
    
    <c:if test="${mrank!=0}">
 	      ※<a href="/ourapp/restaurant/modify">음식점 정보수정하기</a><br/> 
	</c:if>

	</body>
</html>