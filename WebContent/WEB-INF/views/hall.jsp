<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-03-16
  Time: 오전 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
<title>Title</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<!-- 게시글 보기에 카운터링을 설정하기위한 변수들을 선언  -->
	
	<div class="container" style="width: 80%">
		<h1>홈화면</h1>
		${username} hello! <br>
		<%
			if (request.getSession().getAttribute("username") == null) {
			out.write("<a href=\"login\">로그인</a>");
		} else {
			out.write("<a href=\"logout\">로그아웃</a>");
		}
		%>
		
		<br> <img src="images/homeimg.jpg" alt="지도 이미지"> <br>
		<h2>리스트</h2>
		<div>
			<select onchange="change(this)">
				<option value="10" ${PageVO.amount eq 10 ? 'selected' : '' }>10개씩 보기</option>
				<option value="20" ${PageVO.amount eq 20 ? 'selected' : '' }>20개씩 보기</option>
				<option value="50" ${PageVO.amount eq 50 ? 'selected' : '' }>50개씩 보기</option>
				<option value="100" ${PageVO.amount eq 100 ? 'selected' : '' }>100개씩 보기</option>
			</select>
		</div>
		<table class="table table-striped">
			<caption>공연장 리스트</caption>
			<thead>
				<tr>
					<th>번호</th>
					<th>공연장명</th>
					<th>주소(클릭 시 지도)</th>
					<th>시</th>
					<th>군</th>
					<th>개관일</th>
					<th>수용인원</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${halls}" var="hall">
					<tr>
						<td>${hall.hallID}</td>
						<td>${hall.hallName}</td>
						<td><a class="btn btn-primary"
							href="map?address=${hall.address}">${hall.address}</a></td>
						<td>${hall.city}</td>
						<td>${hall.country}</td>
						<td>${hall.openDate}</td>
						<td>${hall.num}</td>
					</tr>
				</c:forEach>
			</tbody>

			<tbody>
				<tr>
					<td colspan="5" align="center">
						<ul class="pagination">
	               				<c:if test="${PageVO.prev }">
                        			<li class="paginate_button prev">
                        			<a href="hall?pageNum=${PageVO.startPage -1 }&amount=${PageVO.amount}">이전</a></li>
								</c:if>
								 
                        		<c:forEach var="num" begin="${PageVO.startPage }" end="${PageVO.endPage }">
	                        		<li class=" ${PageVO.pageNum == num ? 'active' : '' }">
	                        		<a href="hall?pageNum=${num }&amount=${PageVO.amount}">${num }
	                        		</a></li>
                        		</c:forEach>
                        		
                        		<c:if test="${PageVO.next }">
                        			<li class="paginate_button next">
                        			<a href="hall?pageNum=${PageVO.endPage + 1 }&amount=${PageVO.amount}">다음</a></li>
                        		</c:if>
                    			</ul>
					<input type="button" value="글 작성" class="btn btn-default pull-right" onclick="location.href='BoardList.jsp'">
					
					</td>
				</tr>
				
			</tbody>

		</table>


	</div>
<footer class="footer"> </footer>
<script>
	function change(a){
		location.href="hall?pageNum=1&amount="+a.value;
	}
</script>
</body>


</html>
