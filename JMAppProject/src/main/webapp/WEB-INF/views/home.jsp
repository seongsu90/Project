<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
	[membercontroller]<br/>
	1. <a href="/ourapp/member/login">로그인하기</a><br/>
	2.<a href="/ourapp/member/findMid">아이디찾기</a><br/>
	3.<a href="/ourapp/member/findMpassword">비밀번호찾기</a><br/>
    4.<a href="/ourapp/member/join">회원가입</a><br/>
    ------------------------------------------------------<br/>
    [couponcontroller]<br/>
    5.<a href="/ourapp/coupon/index">쿠폰 기능</a><br/>
      ------------------------------------------------------<br/>
     <b>[poscontroller-King of Analog]</b><br/>
    6.<a href="/ourapp/pos/add">pos 추가</a><br/>
    7.<a href="/ourapp/pos/modify">pos 수정</a><br/>
    8.<a href="/ourapp/pos/delete">pos 삭제</a><br/>
    9.<a href="/ourapp/pos/info">pos 정보보기</a><br/>
    10.<a href="/ourapp/pos/calcsum">총가격</a><br/>
    -------------------------------------------------------<br/>
     <b>[reviewcontroller-King of Analog]</b><br/>
     11.<a href="/ourapp/review/write">리뷰쓰기</a><br/>
     12.<a href="/ourapp/review/delete">리뷰삭제</a><br/>
     11.<a href="/ourapp/review/info">리뷰보기</a><br/>
</body>
	<!--  -->

</html>
