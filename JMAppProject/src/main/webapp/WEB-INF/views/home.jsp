<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
	[membercontroller]<br/>
	<c:if test="${login==null}">
	※<a href="/ourapp/member/login">로그인하기</a><br/>
	</c:if> 	
	<c:if test="${login!=null}">
	※ <a href="/ourapp/member/logout">로그아웃</a><br/>
	</c:if> 
	※<a href="/ourapp/member/findMid">아이디찾기</a><br/>
	※<a href="/ourapp/member/findMpassword">비밀번호찾기</a><br/>
    ※<a href="/ourapp/member/join">회원가입</a><br/>
    ※<a href="/ourapp/member/list">회원목록</a><br/>
    <c:if test="${login != null}">
    ※<a href="/ourapp/member/info?mid=${login}">회원정보</a>
    </c:if><br/>
    ------------------------------------------------------<br/>
    [couponcontroller]<br/>
    <c:if test="${login==null}">
    로그인을 해야 쿠폰기능을 이용할 수 있습니다.<br/>
    </c:if> 
    <c:if test="${login!=null}">
     ※<a href="/ourapp/coupon/index?mid=${login}">쿠폰 기능</a><br/>
     </c:if>
     ------------------------------------------------------<br/>
     <b>[poscontroller-King of Analog]</b><br/>
    ※<a href="/ourapp/pos/index">pos 기능</a><br/>
  <!--   ※<a href="/ourapp/pos/modify">pos 수정</a><br/>
    ※<a href="/ourapp/pos/delete">pos 삭제</a><br/>
    ※<a href="/ourapp/pos/info">pos 정보보기</a><br/>
    ※<a href="/ourapp/pos/calcsum">총가격</a><br/> -->
    -------------------------------------------------------<br/>
     <b>[reviewcontroller-King of Analog]</b><br/>
     ※<a href="/ourapp/review/write">리뷰쓰기</a><br/>
     ※<a href="/ourapp/review/delete">리뷰삭제</a><br/>
     ※<a href="/ourapp/review/info">리뷰보기</a><br/>
     ※<a href="/ourapp/review/list">리뷰리스트</a><br/>
    -------------------------------------------------------<br/>
     [restaurant]<br/>
     ※<a href="/ourapp/restaurant/list">음식점 리스트보기</a><br/>
     ※<a href="/ourapp/restaurant/add">음식점추가하기</a><br/>
     ※<a href="/ourapp/restaurant/delete">음식점삭제하기</a><br/>
     ※<a href="/ourapp/restaurant/info?resid=1">음식점 정보보기</a><br/>
     ※<a href="/ourapp/restaurant/modify">음식점 정보수정하기</a><br/>
     -------------------------------------------------------<br/>
     [Event] <br/>
     ※<a href="/ourapp/event/index">이벤트 기능</a><br/>
     -------------------------------------------------------<br/>
     [MenuList] <br/>
     ※<a href="/ourapp/menulist/index">메뉴리스트</a><br/>
     -------------------------------------------------------<br/>
     [Reservation]<br/>
     <c:if test="${login==null}">
    로그인을 해야 예약기능을 이용할 수 있습니다.<br/>
    </c:if> 
    <c:if test="${login!=null}">
     ※<a href="/ourapp/reservation/index">예약기능</a><br/>
    </c:if>
     -------------------------------------------------------<br/>
     [Favorite]<br/>
     ※<a href="/ourapp/favorite/index">즐겨찾기 기능하라고 현태가 오더내림</a>
</body>
	<!--  -->

</html>
