<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
		
		 <script type="text/javascript">
            function showImage(smSrc) {
                document.getElementById('largeImg').src = smSrc;
                showLargeImagePanel();
                unselectAll();
                /*setTimeout(function() {
                    document.getElementById('largeImg').src = lgSrc;
                }, 1)*/
            }
            function showLargeImagePanel() {
                document.getElementById('largeImgPanel').style.display = 'block';
            }
            function unselectAll() {
                if(document.selection)
                    document.selection.empty();
                if(window.getSelection)
                    window.getSelection().removeAllRanges();
            }
        </script>

        <style type="text/css">
            #largeImgPanel {
                text-align: center;
                display: none;
                position: fixed;
                z-index: 100;
                top: 0; left: 0; width: 100%; height: 100%;
                background-color: rgba(100,100,100, 0.5);
            }
        </style>
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		<p align="left"><a href="/myweb2/"><IMAGE SRC="/myweb2/resources/spring.jpg"></IMAGE></a>
		&nbsp; <font size="6"><b>글쓰기</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
		
		<table style="width:570px">
			<tr>
				<td style="background-color:#9966FF; width:70px">번호</td>
				<td>${photoBoard.bno}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">제목</td>
				<td>${photoBoard.btitle}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">내용</td>
				<td><pre>${photoBoard.bcontent}</pre></td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">글쓴이</td>
				<td>${photoBoard.bwriter}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">조회수</td>
				<td>${photoBoard.bhitcount}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">날짜</td>
				<td>${photoBoard.bdate}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">사진</td>
				<td><img src="show?savedfile=${photoBoard.savedfile}" style="cursor:pointer" width="500px" onclick="showImage(this.src)" alt="클릭하시면 조금더 커집니다.."/></td>
				
			</tr>				
		</table>
				 <div id="largeImgPanel" onclick="this.style.display='none'">
            			<img id="largeImg"   style="height:100%; margin:0; padding:0;" />
        		</div>		
				<div>
			<c:if test="${login == photoBoard.bwriter}">
				<input type="button"  name="modify" value="수정" onclick="location.href='modify?bno=${photoBoard.bno}' ">
				<input type="button"  name="delete" value="삭제" onclick="location.href='delete?bno=${photoBoard.bno}' ">
			</c:if>
			<input type="button"  name="list"  value="목록" onclick="location.href='list' ">
			
		</div>
				
	</body>
</html>