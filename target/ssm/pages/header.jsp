<%--
  Created by IntelliJ IDEA.
  User: 12271
  Date: 2020/5/15
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="panel-heading header-dec">
        用户信息管理
        <%
            if (session.getAttribute("user") != null) {
        %>
        ---欢迎<%=session.getAttribute("user")%>登录本系统---<a href="login.jsp" onclick="logout()">退出登录</a>
        <%
        } else {
        %>
        ---请先<a href="login.jsp">登录</a>本系统
        <%
            }
        %>
    </div>
</header>
