<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css">
		a{
		  text-decoration:none;
		  color:black;
		}
		a:HOVER{
		  color:green;
		}
	</style>
<title>Insert title here</title>
</head>
<body>
	메뉴리스트
	<hr/>
	
	<a href="add">[리스트작성]</a>
	
	 <table style="border-collapse: collapse; border: 1px solid black; width:600px; text-align:center;">
		<tr style="background-color: #ffcc00;">
          <td style="border:1px solid black;">메뉴이름</td>
		  <td style="border:1px solid black;">가격</td>
		  <td style="border:1px solid black;">식당</td>
		  <td style="border:1px solid black;">메뉴 정보</td>
		  <td style="border:1px solid black;">메뉴 사진</td>
		  <td style="border:1px solid black;">핫해핫해</td>
	    </tr>
	   
	   <tr>
		 	 <td style="border:1px solid black;">${menuList.mlname}</td>
			 <td style="border:1px solid black;">${menuList.mlprice}</td>
			 <td style="border:1px solid black;">${menuList.mlresid}</td>
			 <td style="border:1px solid black;">${menuList.mlinfo}</td>
			 <td style="border:1px solid black;">${menuList.mlsavedfile}</td>
			 <td style="border:1px solid black;">${menuList.mlishot}</td>
		   </tr>
	 </table>
	 
	  <div style="width:600px">
	  
	 	<a href="list?pageNo=1">[처음]</a>
	 	
	 	<c:if test="${groupNo>1}">
	 		<a href="list?pageNo=${startPageNo-1}">[이전]</a>
	 	</c:if><!-- 이전번호가 나오게하는 조건 pageNo가 2부터 이전버튼 나오게함 -->
	 	
	 	<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
	 	  &nbsp;
	 		<a href="list?pageNo=${i}"
	 		<c:if test="${pageNo==i}">style="color:red"</c:if>
	 		>${i}</a>
	 		&nbsp;
	 	</c:forEach>
	 	
	 	<c:if test="${groupNo<totalGroupNo}">
	 		<a href="list?pageNo=${endPageNo+1}">[다음]</a>
	 	</c:if>
	 	
	 	<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
	 </div>
</body>
</html>