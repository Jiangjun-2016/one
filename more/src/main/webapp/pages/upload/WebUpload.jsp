<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="ja"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>使用webuploader上传</title>
    <!-- 1.引入文件 -->
    <link href="../../js/webuploader-0.1.5/dist/webuploader.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../js/webuploader-0.1.5/dist/webuploader.js"></script>
    <script type="text/javascript" src="../../js/jquery-2.1.4/jquery.min.js"></script>
</head>
<body>
<!-- 2.创建页面元素 -->
<div id="upload">
    <div id="filePicker">文件上传</div>
</div>


<!-- 3.添加js代码 -->
<script type="text/javascript">
    var uploader = WebUploader.create(
            {
                swf:"../js/webuploader-0.1.5/dist/Uploader.swf",
                server:"${pageContext.request.contextPath }/FileUploadServlet",
                pick:"#filePicker",
                auto:true
            }
    );
</script>
</body>
</html>