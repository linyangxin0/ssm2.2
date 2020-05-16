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

    <script src="${pageContext.request.contextPath }/js/device-list.js"></script>



</head>
<body>

<!-- 导航侧栏 -->
<jsp:include page="aside.jsp"></jsp:include>


<div class="panel panel-default table-content">

    <jsp:include page="header.jsp"></jsp:include>

    <div id="toolbar">
        <button id="add" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            添加
        </button>
        <button id="del_user_btn" class="btn btn-primary" onclick="delSong()">
            删除
        </button>
    </div>

    <table class="table table-hover" id="userTable"
           data-toolbar="toolbar"
           data-show-refresh="true"
           data-show-toggle="true"
           data-show-columns="ture">
        <thead>
        <tr>
            <th></th>
            <th>ID</th>
            <th>名称</th>
            <th>设备类型</th>
            <th>状态</th>
        </tr>
        </thead>
        <%--        <tbody>--%>
        <%--        </tbody>--%>
    </table>
</div>

<%--添加--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">
                    设备信息
                </h4>

            </div>
            <form>
                <div class="modal-body">

                    <div class="row">
                        <label for="device_id" class="col-sm-4 control-label">
                            设备ID:
                        </label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="device_id" placeholder="请输入11位MAC码"/>
                        </div>
                    </div>

                    <div class="row">
                        <label for="name" class="col-sm-4 control-label">
                            设备名称:
                        </label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="name" placeholder="请输入设备名称"/>
                        </div>
                    </div>

                    <div class="row">
                        <label for="type" class="col-sm-4 control-label">
                            状态:
                        </label>
                        <div class="col-sm-8">
                            <select id="type" class="form-control">
                                <option value="0">Android设备</option>
                                <option value="1">开发板设备</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label for="status" class="col-sm-4 control-label">
                            状态:
                        </label>
                        <div class="col-sm-8">
                            <select id="status" class="form-control">
                                <option value="0">在线</option>
                                <option value="1">离线</option>
                            </select>
                        </div>
                    </div>

                </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="addUser_btn" onclick="addSong()">
                    添加
                </button>
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                    关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<%--编辑按键模态框--%>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel2">
                    编辑歌曲信息
                </h4>
            </div>
            <form>
                <div class="modal-body">

                    <div class="row">
                        <label for="edit_device_id" class="col-sm-4 control-label">
                            设备ID:
                        </label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="edit_device_id" placeholder="请输入11位MAC码" disabled/>
                        </div>
                    </div>

                    <div class="row">
                        <label for="edit_name" class="col-sm-4 control-label">
                            设备名称:
                        </label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="edit_name" placeholder="请输入设备名称"/>
                        </div>
                    </div>

                    <div class="row">
                        <label for="edit_type" class="col-sm-4 control-label">
                            状态:
                        </label>
                        <div class="col-sm-8">
                            <select id="edit_type" class="form-control">
                                <option value="0">Android设备</option>
                                <option value="1">开发板设备</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label for="edit_status" class="col-sm-4 control-label">
                            状态:
                        </label>
                        <div class="col-sm-8">
                            <select id="edit_status" class="form-control">
                                <option value="0">离线</option>
                                <option value="1">在线</option>
                            </select>
                        </div>
                    </div>

                </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="edit_user_btn" onclick="editSong()">
                    修改
                </button>
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                    关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="${pageContext.request.contextPath }/js/date.format.js"></script>
<script src="${pageContext.request.contextPath }/js/aside.js"></script>


</body>
</html>
