<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="30%" color="gray">
			<h3>파일 업로드 폼 페이지</h3>
		<hr width="30%" color="gray">
		<br><br>
			
	<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/upload_ok.go"> <!-- 첨부파일은 반드시 post -->
			
			<table border="1" width="400">
				<tr>
					<th>첨부파일_1</th>
					<td>
						<input type="file" name="file1">
					</td>
				</tr>
				
				<tr>
					<th>첨부파일_2</th>
					<td>
						<input type="file" name="file2">
					</td>
				</tr>
				
				<tr>
					<th>첨부파일_3</th>
					<td>
						<input type="file" name="file3">
					</td>
				</tr>
			
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="파일전송">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					 </td>
				</tr>
			</table>
		</form>
			
			
			</div>

</body>
</html>