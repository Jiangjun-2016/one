<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="ja"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>使用webuploader上传</title>
    <link href="../../css/stream-v1.css" rel="stylesheet" type="text/css"/>
    <link href="../../js/webuploader-0.1.5/dist/webuploader.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../js/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="../../js/jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../js/jquery/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap/bootstrap-datepicker.ja.min.js"></script>
    <script type="text/javascript" src="../../js/webuploader-0.1.5/dist/webuploader.js"></script>
    <script type="text/javascript" src="../../js/webuploader-0.1.5/dist/webuploader.min.js"></script>
    <script type="text/javascript" src="../../pages/upload/js/webupload.js"></script>
</head>
<body>
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