<%--
  Created by IntelliJ IDEA.
  User: 12271
  Date: 2020/1/28
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="../css/aside.css">
    <link rel="stylesheet" type="text/css" href="../css/pages.css">


    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap-table-locale-all.min.js"></script>

    <script src="${pageContext.request.contextPath }/js/song-list.js"></script>



</head>
<body>

<!-- 导航侧栏 -->
<jsp:include page="aside.jsp"></jsp:include>


<div class="panel panel-default table-content">

    <jsp:include page="header.jsp"></jsp:include>

    <div class="content-wrapper">
        <img src="${pageContext.request.contextPath}/images/center.jpg"
             width="100%" height="100%" />
    </div>
</div>



<script src="${pageContext.request.contextPath }/js/date.format.js"></script>
<script src="${pageContext.request.contextPath }/js/aside.js"></script>


</body>
</html>
