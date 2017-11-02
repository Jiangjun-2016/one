<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function() {
		
	});
	

	function fun() {
		alert("查询");
		$.ajax({
			type : "GET",
			url : "doSolrService/searchSolrInfo.do",
			success : function(data) {
				alert('success');
			}
		}); 
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="doFTPService/upload/uploadfile.do" name="" class="" id="" method="post" enctype="multipart/form-data" >
	     请选择上传的文件：<input type="file" id="" name="file"><br>
     <input type="submit" value="提交"><br>
     <input type="hidden" name="fileUploadUrl" value="dafgafaga">
   </form>	
   <button onclick="fun()">查询</button>
</body>
</html>