<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="div_center">
	<h3>게시판 글 수정 페이지</h3>
	<hr>
	
	<form action="update.board" method="post">
	
		<!-- form안에서 화면에 보이지는 않지만, 반드시 넘겨줘야 되는 값을 숨겨서 보낼 때는 인풋태그의 hidden을 사용합니다. -->
		<input type="hidden" name="bno" value="${board.bno }">
		<input type="hidden" name="writer" value="${board.writer }">
				
		<table border="1" width="500">
			
			<tr>
				<td>글 번호</td>
				<td>${board.bno }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.writer }</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="title" value="${board.title }">
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="content">${board.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" >&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='list.board'">        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>
</body>
</html>