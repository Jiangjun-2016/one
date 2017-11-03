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
    <!-- 3.添加js代码 -->
    <script type="text/javascript" src="../../pages/upload/js/webupload.js"></script>
</head>
<body>
<!-- 2.创建页面元素 -->
<div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="attach"></div>
        <input type="button" value="上传" id="upload"/>
    </div>
</div>


<div id="uploader1" class="wu-example">
    <!--用来存放文件信息-->
    <div id="thelist1" class="uploader-list"></div>
    <div class="btns">
        <div id="multi"></div>
        <input type="button" value="上传" id="multiUpload"/>
    </div>
</div>
</body>
</html>