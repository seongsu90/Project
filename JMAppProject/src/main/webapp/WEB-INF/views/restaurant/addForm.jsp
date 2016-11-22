<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	<body> 
	Restaurant 추가
		<hr/>		
		

		<form method="post" enctype="multipart/form-data">
			식당 이름 : <input type="text" name="resname" value="${restaurant.resname}"/><br/>
			식당 위치 :
						<select name="reslocation">
						<option value="${restaurant.reslocation}">-- 지역을 선택하세요 --</option>
			  			 <optgroup label = "서울시">
                            <option value ="송파구">송파구</option>
                            <option value = "강남구">강남구</option>
                            <option value = "서초구">서초구</option>
                            <option value = "중구">중구</option>
                            
                        </optgroup>
                        </select><br/>
			식당 테이블 수 : <input type="number" name="restotaltable" value="${restaurant.restotaltable}"/><br/>
			식당 정보 : <input type="text" name="resinfo" value="${restaurant.resinfo}"/><br/>
			식당 전화번호 : <input type="tel" name="restel" value="${restaurant.restel}"/><br/>
			식당 OPEN TIME : <input type="time" name="resopen" value="${restaurant.resopen}"/><br/>
			식당 CLOSE TIME : <input type="time" name="resclose" value="${restaurant.resclose}"/><br/>			
		    식당 사진 :<input type="file" name="resphoto"/><br/>   
					

			식당 휴일:<input type="checkbox" name="closeday" value="월요일" >월요일
			          <input type="checkbox" name="closeday" value="화요일" >화요일
			          <input type="checkbox" name="closeday" value="수요일" >수요일
			          <input type="checkbox" name="closeday" value="목요일" >목요일
			          <input type="checkbox" name="closeday" value="금요일" >금요일
			          <input type="checkbox" name="closeday" value="토요일" >토요일
			          <input type="checkbox" name="closeday" value="일요일" >일요일 
			          <input type="checkbox" name="closeday" value="휴일 없음" >휴일 없음<br/> 
									
		
			<input type="submit" value="식당 추가 완료"/><br/>		
		</form>
	</body>
</html>