<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Content-Language" content="ja"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>验证码</title>
    <!-- 触发JS刷新-->
    <script type="text/javascript">
        function changeImg() {
            var img = document.getElementById("img");
            img.src = "doValidateService/getValidateCode.do?date=" + new Date();
        }
    </script>
</head>
<body>
<table>
    <tr>
        <td nowrap width="437"></td>
        <td>
            <img id="img" src="doValidateService/getValidateCode.do"/>
            <a href='#' onclick="javascript:changeImg()" style="color:white;"><label
                    style="color:white;">看不清？</label></a>
        </td>
    </tr>
</table>
</body>
</html>