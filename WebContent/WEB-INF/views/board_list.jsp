<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/header.jspf"%>
<style>
        .btn {
          
            border: 0; 
            border-radius: 0; /*윤곽 0*/
            padding: 5px 10px; 
            margin: 20px 0px;
        }
	</style>
</head>
<body>

	<div class="container">
		<h3>My Web게시판</h3>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${board.bno }</td>
						<td>${board.writer}</td>
						<td><a href="getContent.board?bno=${board.bno }">${board.title }</a></td>
						<td><fmt:formatDate value="${board.regdate }" pattern="yyyy년 MM월dd일 HH시 mm분 ss초" /></td>
						<td>${board.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="5" align="center">
	               			<ul class="pagination pagination-sm">
                        		<li><a href="#">이전</a></li>
                        		<li  class="active"><a href="#">1</a></li>
                        		<li><a href="#">2</a></li>
                        		<li><a href="#">3</a></li>
                        		<li><a href="#">4</a></li>
                        		<li><a href="#">5</a></li>
                        		<li><a href="#">다음</a></li>
                    			</ul>
					<input type="button" value="글 작성" class="btn btn-default pull-right" onclick="location.href='write.board'">
					
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>
</body>