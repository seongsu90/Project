<%@ page contentType="text/html;charset=UTF-8"%>

<%
String selCity = request.getParameter("selCity");
/* String[] city = {"강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시", "대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "울산광역시", "인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도"}; */
String[] city = {"강원도", "경기도", "서울특별시"};
%>

<%
if ( selCity == "") {
%>
	<option value="선택">선택</option>
<%	
}

for ( int i = 0 ; i < city.length ; i++ ) {
	if ( selCity.equals(city[i]) ) {
%>
		<option value="<%=city[i]%>" selected><%=city[i]%></option>
<% 
	} else {
%>
		<option value="<%=city[i]%>"><%=city[i]%></option>
<%
	}
}
%>

<%-- 
<% if ( selCity.equals("강원도") ) { %>
<option value="강원도" selected>강원도</option>
<% } else { %>
<option value="강원도">강원도</option>
<%}%>

<% if ( selCity.equals("경기도") ) { %>
<option value="경기도" selected>경기도</option>
<% } else { %>
<option value="경기도">경기도</option>
<%}%>

<% if ( selCity.equals("경상남도") ) { %>
<option value="경상남도" selected>경상남도</option>
<% } else { %>
<option value="경상남도">경상남도</option>
<%}%>

<% if ( selCity.equals("경상북도") ) { %>
<option value="경상북도" selected>경상북도</option>
<% } else { %>
<option value="경상북도">경상북도</option>
<%}%>

<% if ( selCity.equals("광주광역시") ) { %>
<option value="광주광역시" selected>광주광역시</option>
<% } else { %>
<option value="광주광역시">광주광역시</option>
<%}%>

<% if ( selCity.equals("대구광역시") ) { %>
<option value="대구광역시" selected>대구광역시</option>
<% } else { %>
<option value="대구광역시">대구광역시</option>
<%}%>

<% if ( selCity.equals("대전광역시") ) { %>
<option value="대전광역시" selected>대전광역시</option>
<% } else { %>
<option value="대전광역시">대전광역시</option>
<%}%>

<% if ( selCity.equals("부산광역시") ) { %>
<option value="부산광역시" selected>부산광역시</option>
<% } else { %>
<option value="부산광역시">부산광역시</option>
<%}%>

<% if ( selCity.equals("서울특별시") ) { %>
<option value="서울특별시" selected>서울특별시</option>
<% } else { %>
<option value="서울특별시">서울특별시</option>
<%}%>

<% if ( selCity.equals("세종특별자치시") ) { %>
<option value="세종특별자치시" selected>세종특별자치시</option>
<% } else { %>
<option value="세종특별자치시">세종특별자치시</option>
<%}%>

<% if ( selCity.equals("울산광역시") ) { %>
<option value="울산광역시" selected>울산광역시</option>
<% } else { %>
<option value="울산광역시">울산광역시</option>
<%}%>

<% if ( selCity.equals("인천광역시") ) { %>
<option value="인천광역시" selected>인천광역시</option>
<% } else { %>
<option value="인천광역시">인천광역시</option>
<%}%>

<% if ( selCity.equals("전라남도") ) { %>
<option value="전라남도" selected>전라남도</option>
<% } else { %>
<option value="전라남도">전라남도</option>
<%}%>

<% if ( selCity.equals("전라북도") ) { %>
<option value="전라북도" selected>전라북도</option>
<% } else { %>
<option value="전라북도">전라북도</option>
<%}%>

<% if ( selCity.equals("제주특별자치도") ) { %>
<option value="제주특별자치도" selected>제주특별자치도</option>
<% } else { %>
<option value="제주특별자치도">제주특별자치도</option>
<%}%>

<% if ( selCity.equals("충청남도") ) { %>
<option value="충청남도" selected>충청남도</option>
<% } else { %>
<option value="충청남도">충청남도</option>
<%}%>

<% if ( selCity.equals("충청북도") ) { %>
<option value="충청북도" selected>충청북도</option>
<% } else { %>
<option value="충청북도">충청북도</option>
<%}%>
 --%>