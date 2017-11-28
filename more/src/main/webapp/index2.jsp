<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body {
            background: #fbfcff;
            color: #f8f7ff
        }
    </style>
</head>

<body>
<div align="center">
    <img src="images/lingjun/psb.jpg" alt="">
    <br>
    <img src="images/lingjun/psb2.jpg" alt="">
    <img src="images/lingjun/psb3.jpg" alt="">
    <img src="images/lingjun/psb4.jpg" alt="">
    <br>
    <img src="images/lingjun/psb5.jpg" alt="">
    <img src="images/lingjun/psb6.jpg" alt="">
    <img src="images/lingjun/psb7.jpg" alt="">
    <img src="images/lingjun/psb8.jpg" alt="">
    <img src="images/lingjun/psb10.jpg" alt="">
</div>
</body>
</html>
