<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
		Reset
		body,p,h1,h2,h3,h4,h5,h6,ul,ol,li,dl,dt,dd,table,th,td,form,fieldset,legend,input,textarea,button,select,blockquote,strong,xmp{margin:0; padding:0; font-size:14px; line-height:20px; font-weight:normal; font-family: 'NanumGothic', arial, '돋움', Helvetica, verdana, futura, tahoma, sans-serif; color:#555;}
		legend,caption{display:none;}
		img,fieldset{border:0;}
		ul,ol{list-style:none;}
		a:link,a:visited,a:hover,a:active{text-decoration:none;color:#999;}
		a{display:block;}
		body{}
		div{}
		h2{color:purple; margin:auto; width:100%; font-size:30px; text-align:center;}
	
		div>ul{margin:auto; width:100%;}
		div>ul>li{float:left; width:180px; text-align:center; margin-right:10px;}
		div>ul>li:hover{cursor:pointer;}
		div>ul>li>a{font:bold 20px NanumGothic; height:64px; display:inline-block;}
		div>ul>li:hover>a{color:#77a52b; border-bottom:4px solid #77a52b; height:30px;}
		div ul ul{background:#fafbf9; padding:5px 0; height:320px; display:none;}
		div ul li:hover ul{background:#eeefed;}
		ul li a{font-size:13px; padding:0 5px; text-align:center; color:#606060; }
		div ul ul li a:hover{color:#77a52b; text-decoration:underline;}
       
		</style>
	</head>
	<body>
		
		<h2>메뉴리스트</h2>
		<hr/>
		<div>
			<ul>
			<c:if test="${login!=null}"> 
				<c:if test="${mrank!=0}">
					<li><a href="/ourapp/menulist/add">메뉴리스트 생성</a><br/></li>
					<li><a href="/ourapp/menulist/modify?mlresid=28&mlname=핫치킨">메뉴리스트 수정</a><br/></li>
					<li><a href="/ourapp/menulist/delete">메뉴 리스트삭제</a><br/></li>
					<li><a href="/ourapp/menulist/modifyhot?mlresid=28&mlname=핫치킨&mlishot=1">핫메뉴 수정</a><br/></li>
				</c:if>
			</c:if>
				<li><a href="/ourapp/menulist/info?mlresid=28&mlname=쌀국수">메뉴 정보</a><br/></li>
				<li><a href="/ourapp/menulist/list">메뉴 리스트보기</a><br/></li>
				<li><a href="/ourapp/menulist/hotlist?mlresid=0&mlishot=1">핫메뉴리스트 보기</a><br/></li>
				<li><a href="/ourapp/menulist/hotinfo?mlresid=0&mlname=닭발&mlishot=1">핫메뉴 정보</a><br/></li>
			</ul>
		</div>	
	</body>
</html>