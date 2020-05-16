<%--
  Created by IntelliJ IDEA.
  User: 12271
  Date: 2020/5/15
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<aside class="content">
    <div>
        <ul class="first-bar ">
            <li class="first-menu">
                <a href="${pageContext.request.contextPath}/pages/main.jsp">
                    <i>
                        <img src="../images/home.png" class="main-bar-icon">
                    </i>
                    <span>首页</span>
                </a>
            </li>
            <li class="first-menu">
                <a href="#">
                    <i>
                        <img src="../images/main-bar-icon3.png" class="main-bar-icon">
                    </i>
                    <span>榜单管理</span>
                </a>
                <ul class="second-bar not-active">
                    <a href="${pageContext.request.contextPath}/pages/song-list.jsp">

                        <li>
                            <i>
                                <img src="../images/child-icon.png" class="main-bar-icon">
                            </i>
                            <span>歌单</span>
                        </li>
                    </a>
                    <a href="#">
                        <li>
                            <i>
                                <img src="../images/child-icon.png" class="main-bar-icon">
                            </i>
                            <span>设备音乐管理</span>
                        </li>
                    </a>
                </ul>

            </li>
            <li class="first-menu">
                <a href="#">
                    <i>
                        <img src="../images/main-bar-icon2.png" class="main-bar-icon">
                    </i>
                    <span>设备管理</span>
                </a>
                <ul class="second-bar not-active">
                    <a href="${pageContext.request.contextPath}/pages/device-list.jsp">

                        <li>
                            <i>
                                <img src="../images/child-icon.png" class="main-bar-icon">
                            </i>
                            <span>设备详情</span>
                        </li>
                    </a>
                    <a href="#">
                        <li>
                            <i>
                                <img src="../images/child-icon.png" class="main-bar-icon">
                            </i>
                            <span>设备广告</span>
                        </li>
                    </a>
                </ul>

            </li>

            <li class="first-menu">
            <a href="#">
                <i>
                    <img src="../images/main-bar-icon1.png" class="main-bar-icon">
                </i>
                <span>用户管理</span>
            </a>
                <ul class="second-bar not-active">
                    <a href="#">

                        <li>
                            <i>
                                <img src="../images/child-icon.png" class="main-bar-icon">
                            </i>
                            <span>用户管理</span>
                        </li>
                    </a>
                    <a href="#">
                        <li>
                            <i>
                                <img src="../images/child-icon.png" class="main-bar-icon">
                            </i>
                            <span>角色管理</span>
                        </li>
                    </a>
                    <a href="#">
                        <li>
                            <i>
                                <img src="../images/child-icon.png" class="main-bar-icon">
                            </i>
                            <span>访问日志</span>
                        </li>
                    </a>
                </ul>

        </li>
        </ul>
    </div>
</aside>

