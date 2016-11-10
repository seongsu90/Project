<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
		<link href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascrpt" src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/js/bootstrap.min.js"></script>
		<script type="text/javascript">

(function ()
{
    function k(a, b, c)
    {
        if (a.addEventListener) {
            a.addEventListener(b, c, false);
        }
        else {
            a.attachEvent && a.attachEvent("on" + b, c);
        }
    }
    function g(a)
    {
        if (typeof window.onload != "function")
        {
            window.onload = a;
        }
        else {
            var b = window.onload;
            window.onload = function ()
            {
                b();
                a()
            }
        }
    }
    function h()
    {
        var a = {};
        for (type in {
            Top : "", Left : ""
        })
        {
            var b = type == "Top" ? "Y" : "X";
            if (typeof window["page" + b + "Offset"] != "undefined") {
                a[type.toLowerCase()] = window["page" + b + "Offset"];
            }
            else
            {
                b = document.documentElement.clientHeight ? document.documentElement : document.body;
                a[type.toLowerCase()] = b["scroll" + type];
            }
        }
        return a
    }
    function l()
    {
        var a = document.body, b;
        if (window.innerHeight) {
            b = window.innerHeight;
        }
        else if (a.parentElement.clientHeight) {
            b = a.parentElement.clientHeight;
        }
        else if (a && a.clientHeight) {
            b = a.clientHeight;
        }
        return b
    }
    function i(a)
    {
        this.parent = document.body;
        this.createEl(this.parent, a);
        this.size = Math.random() * 4 + 4;
        this.el.style.width = Math.round(this.size) + "px";
        this.el.style.height = Math.round(this.size) + "px";
        this.maxLeft = document.body.offsetWidth - this.size;
        this.maxTop = document.body.offsetHeight - this.size;
        this.left = Math.random() * this.maxLeft;
        this.top = h().top + 1;
        this.angle = 1.4 + 0.2 * Math.random();
        this.minAngle = 1.4;
        this.maxAngle = 1.6;
        this.angleDelta = 0.01 * Math.random();
        this.speed = 4 + Math.random()
    }
    var j = false;
    g(function ()
    {
        j = true;
    });
    var f = true;
    window.createSnow = function (a, b)
    {
        if (j)
        {
            var c = [], m = setInterval(function ()
            {
                f && b > c.length && Math.random() < b * 0.0025 && c.push(new i(a));
                !f && !c.length && clearInterval(m);
                for (var e = h().top, n = l(), d = c.length - 1; d >= 0; d--) if (c[d]) if (c[d].top < e || c[d].top + c[d].size + 1 > e + n) {
                    c[d].remove();
                    c[d] = null;
                    c.splice(d, 1)
                }
                else {
                    c[d].move();
                    c[d].draw()
                }
            }, 40);
            k(window, "scroll", function ()
            {
                for (var e = c.length - 1; e >= 0; e--) {
                    c[e].draw();
                }
            })
        }
        else {
            g(function () 
            {
                createSnow(a, b) 
            });
        }
    };
    window.removeSnow = function ()
    {
        f = false;
    };
    i.prototype = 
    {
        createEl : function (a, b)
        {
            this.el = document.createElement("img");
            this.el.setAttribute("src", b + "resources/img/snow" + Math.floor(Math.random() * 4) + ".gif");
            this.el.style.position = "absolute";
            this.el.style.display = "block";
            this.el.style.zIndex = "99999";
            this.parent.appendChild(this.el)
        },
        move : function ()
        {
            if (this.angle < this.minAngle || this.angle > this.maxAngle) {
                this.angleDelta =- this.angleDelta;
            }
            this.angle += this.angleDelta;
            this.left += this.speed * Math.cos(this.angle * Math.PI);
            this.top -= this.speed * Math.sin(this.angle * Math.PI);
            if (this.left < 0) {
                this.left = this.maxLeft;
            }
            else if (this.left > this.maxLeft) {
                this.left = 0;
            }
        },
        draw : function ()
        {
            this.el.style.top = Math.round(this.top) + "px";
            this.el.style.left = Math.round(this.left) + "px";
        },
        remove : function ()
        {
            this.parent.removeChild(this.el);
            this.parent = this.el = null;
        }
    }
})
();
</script>
<script>
    createSnow('./', 2000);
	//------------ ./는 이미지 경로, 1000는 눈 갯수(숫자가 크면 클수록 폭설이 내립니다.)
</script>

 </head>
	
	<body bgcolor="black"> <!-- 브라우저에 나오는 부분 -->
	
	<div class="jumbotron">
        <h1>Spring Final Programming</h1>
        <p class="lead">Java, SQL, JDBC, HTML5, CSS3, JavaScript, jQuery, AJAX, JSP, Spring</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">많이 배웠네</a></p>
      </div>
		
		<%-- <p align="left"><a href="/myweb/"><IMAGE SRC="/myweb/resources/spring.jpg"></IMAGE></a>
		<embed src="http://www.clocklink.com/clocks/5012-pink.swf?TimeZone=KoreaRepublicof_Seoul" width="227" height="75" wmode="transparent" type="application/x-shockwave-flash">
		&nbsp; <font size="6" color=#FFFFFF><b><marquee behavior=alternate>■■ SpringFinalProgramming ■■</marquee></b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
				1.<c:if test="${login==null}">
					<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login"><font color=#FFFFFF>로그인</font></a><br/> <!-- 표현식 -->
				  </c:if> 
				  
				  <c:if test="${login!=null}">
					<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout"><font color=#FFFFFF>로그아웃</font></a><br/> <!-- 표현식 -->
				  </c:if>
				2. <a href="${pageContext.servletContext.contextPath}/freeboard/list"><font color=#FFFFFF>자유 게시판</font></a><br/> <!-- 표현 언어라고 한다. -->
				3. <a href="${pageContext.servletContext.contextPath}/photoboard/list"><font color=#FFFFFF>포토 게시판</font></a><br/> --%>
	</body>
</html>
