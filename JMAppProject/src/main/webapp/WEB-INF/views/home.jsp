<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  contentType="text/html;charset=UTF-8"%>

﻿<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css"
			href="/ourapp/resources/bootstrap-3.3/css/bootstrap.min.css">
			<script type="text/javascrpt"
			src="/ourapp/resources/bootstrap-3.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/ourapp/resources/css/style.css" />	
	<script type="text/javascript" src="/ourapp/resources/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="/ourapp/resources/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="/ourapp/resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="/ourapp/resources/js/prefixfree.min.js"></script>
	<script type="text/javascript" src="/ourapp/resources/js/custom.js"></script>
	<script type="text/javascrpt" src="/ourapp/resources/js/bootstrap.min.js"></script>

</head>
<body>

	<!-- 배경동영상 -->
	<figure class="vid">
		<video  loop="loop" autoplay="autoplay">
			<source src="/ourapp/resources/img/nike.mp4" type="video/mp4" />
		</video>
	</figure>
	
	<!-- 로고 -->
	<h1><img src="/ourapp/resources/img/logo.png" /></h1>
	
	<!-- header -->
	<header>		
		<ul id="gnb">
		<c:if test="${mrank==2}">
			<li>
				<a href="#"><em>회원 관리</em></a>
				<ul>
					<li><a href="/ourapp/member/list"><em><b>회원목록</b></em></a></li>	
					<li><a href="#"><em><b>블랙리스트 관리</b></em></a></li>
				</ul>
			</li>
			<li>
				<a href="#"><em>음식점 관리</em></a>				
				<ul>
					<li><a href="/ourapp/restaurant/add"><em>음식점 추가</em></a></li>
					<li><a href="/ourapp/restaurant/delete"><em>음식점 삭제</em></a></li>
					<li><a href="/ourapp/restaurant/info?resid=1"><em>음식점 정보보기</em></a></li>
					<li><a href="/ourapp/restaurant/modify"><em>음식점 정보수정하기</em></a></li>
					<li><a href="/ourapp/restaurant/list"><em>음식점 리스트보기</em></a></li>
				</ul>
			</li>
			<li>
				<a href="#"><em> 문자서비스 관리</em></a>
				<ul>
					<li><a href="#"><em>문자서비스 수정</em></a></li>
					<li><a href="#"><em>문자서비스 삭제</em></a></li>
					<li><a href="#"><em>문자서비스 추가</em></a></li>		
				</ul>
			</li>
			</c:if>
		<c:if test="${mrank==1}">
			<li>
				<a href="#"><em>POS 관리</em></a>
				<ul>
					<li><a href="/ourapp/pos/index"><em><b>POS 시스템</b></em></a></li>	
					<li><a href=""><em><b>예약확인</b></em></a></li>
				</ul>
			</li>
			<li>
				<a href="#"><em>음식점 관리</em></a>				
				<ul>
					<li><a href="/ourapp/restaurant/info?resid=1"><em>음식점 정보보기</em></a></li>
					<li><a href="/ourapp/restaurant/modify"><em>음식점 정보수정하기</em></a></li>
				</ul>
			</li>
			<li>
				<a href="#"><em>메뉴판 관리</em></a>				
				<ul>
					<li><a href="/ourapp/menulist/add"><em>메뉴 추가</em></a></li>
					<li><a href="/ourapp/menulist/modify"><em>메뉴 수정</em></a></li>
					<li><a href="/ourapp/menulist/info?mlresid=${event.mlresid}&mlname=${event.mlname}"><em>메뉴 정보</em></a></li>
					<li><a href="/ourapp/menulist/list"><em>메뉴 리스트</em></a></li>
				</ul>
			</li>
			<li>
				<a href="#"><em>쿠폰 관리</em></a>
				<ul>
					<li><a href="/ourapp/coupon/add"><em>쿠폰 생성</em></a></li>
					<li><a href="/ourapp/coupon/send"><em>쿠폰 전송</em></a></li>
					<li><a href="/ourapp/coupon/delete"><em>쿠폰 삭제</em></a></li>
					<li><a href="/ourapp/coupon/info?cnumber=2115507"><em>쿠폰 상세보기</em></a></li>	
					<%-- 회원전용 메뉴 --%>	
					<li><a href="/ourapp/coupon/list"><em>※내 쿠폰함</em></a></li>
				</ul>
			</li>
			<li>
				<a href="#"><em>이벤트 관리</em></a>
				<ul>
					<li><a href="/ourapp/event/add"><em>이벤트 생성</em></a></li>
					<li><a href="/ourapp/event/modify?eresid=${event.eresid}&emlname=${event.emlname}"><em>이벤트 수정</em></a></li>
					<li><a href="/ourapp/event/delete"><em>이벤트 삭제</em></a></li>
					<li><a href="/ourapp/event/list"><em>이벤트 리스트</em></a></li>
					<li><a href="/ourapp/event/info?eresid=1&emlname=ㄹㅇㄹ"><em>이벤트 정보</em></a></li>	
				</ul>
			</li>
			</c:if>
		<c:if test="${mrank==null}">
				<li>
				<a href="#"><em>회원 관리</em></a>
				</li>
				<li>
				<a href="#"><em>음식점 관리</em></a>
				</li>
				<li>
				<a href="#"><em>문자서비스 관리</em></a>
				</li>
				<li>
				<a href="#"><em>메뉴판 관리</em></a>
				</li>
				<li>
				<a href="#"><em>쿠폰 관리</em></a>
				</li>
				<li>
				<a href="#"><em>이벤트 관리</em></a>
				</li>
				</c:if>
		</ul>
	</header>
	
	<!-- sns 버튼모음 -->
	<ul id="sns">
		<!-- 
		<li><a href="#"><i class="fa fa-twitter"></i></a></li>
		<li><a href="#"><i class="fa fa-youtube"></i></a></li>
		<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
		<li><a href="#"><i class="fa fa-android"></i></a></li> -->
		<c:if test="${login==null}">
		<li><a href="/ourapp/member/login"><i class="fa fa-user"><em>LOGIN</em></i></a></li>
		</c:if>
		<c:if test="${login!=null}">
		<li><a href="/ourapp/member/logout"><i class="fa fa-user"><em>LOGOUT</em></i></a></li>
		</c:if>
	</ul>
	
	<!-- 웹폰트 텍스트박스 -->
	<section class="txtBox">
		<p class="txt">Best Qualified<b><br/>FRESH FOOD</b></p>
		<!-- <p class="tit">50<em>/ 24</em></p> -->
	</section>	
	
	<!-- 하단 컨텐츠박스 -->
	<section id="side">
		<div class="con">
			<p>
				<em>Event & Community</em>
				<a href="#"><img src="/ourapp/resources/img/pic1.png" /></a>				
			</p>
			<p>
				<em>News & Notice</em>
				<a href="#"><img src="/ourapp/resources/img/pic2.png" /></a>				
			</p>
			<p>
				<em>Product Review</em>
				<a href="#"><img src="/ourapp/resources/img/pic3.png" /></a>				
			</p>		
		</div>	
		<!-- 자동롤링 버튼 -->
		<div class="btnContents">
			<i class="fa fa-angle-double-left"></i>
			<i class="fa fa-angle-double-left"></i>  
			<i class="fa fa-angle-double-left"></i>
		</div>
	</section>
	
</body>
</html>