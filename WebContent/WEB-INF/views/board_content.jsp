<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${board.bno }</td>
			
			<td width="20%">조회수</td>
			<td width="30%">${board.hit }</td>
		</tr>
		<tr>
			<td width="20%">작성자</td>
			<td width="30%">${board.writer }</td>
			
			<td width="20%">작성일</td>
			<td width="30%"><fmt:formatDate value="${board.regdate }" pattern="yyyy년MM월dd일" /></td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3" width="30%">${board.title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" width="30%" height="120px">${board.content }</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='list.board'">&nbsp;&nbsp;
				<input type="button" value="수정" onclick="location.href='modify.board?bno=${board.bno}'">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='delete.board?bno=${board.bno}'">&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
</div>
</body>
</html>