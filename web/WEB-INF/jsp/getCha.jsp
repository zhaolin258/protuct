<%@ page import="cn.bdqn.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhaolin
  Date: 2019/9/4
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        form {
            display: inline-block;
        }
        *{
         font-size: 5px;
        }
        #s{
            position: absolute;
            left: 1300px;
            margin-top: 10px;
        }
        #ss tr th{
           font-size: 5px;
        }
    </style>
</head>
<body>
<%
    List<User> users =(List<User>) request.getAttribute("userList");
%>
<div class="container">
    <div class="row clearfix">
        <div class="row clearfix">
            <div class="col-md-2 column">
                <form action="/getCha.html">
                    <div col-md-2>
                        <label for="proCode">供应商编码:</label>
                        <input type="text" id="proCode" name="proCode">
                        <label for="proName">供应商编码名称:</label>
                        <input type="text" id="proName" name="proName">
                        <input class="btn btn-success" type="submit" value="查询">
                    </div>
                </form>
                <form action="/Add1.html">
                    <input class="btn btn-danger" type="submit" value="添加">
                </form>

            </div>
            <div class="col-md-9 column" id="ss">
                <table class="table">
                    <thead>
                    <tr>
                        <th>
                            id
                        </th>
                        <th>
                            供应商编码
                        </th>
                        <th>
                            供应商名称
                        </th>
                        <th>
                            供应商联系人
                        </th>
                        <th>
                            联系电话
                        </th>
                        <th>
                            地址
                        </th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.proCode}</td>
                            <td>${u.proName}</td>
                            <td>${u.proContact}</td>
                            <td>${u.proPhone}</td>
                            <td>${u.proAddress}</td>
                            <td>${u.creationDate}</td>
                            <td>
                                <a href="javascript:;" class="viewUser" userId=${u.id}>查看</a>
                                <a href="/getId.html?id=${u.id}">修改</a>
                                <a href="/del/${u.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="container" id="s">
                <div class="row clearfix">
                    <div class="col-md-3 column">
                        <div class="form-group">
                            <label for="exampleInputPassword1">id</label><input type="text" class="form-control" id="exampleInputPassword0" name="id" value="${user.id}"/>
                        </div>
            <div class="form-group">
                <label for="exampleInputPassword1">供应商编码</label><input type="text" class="form-control" id="exampleInputPassword1" name="proCode" />
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">供应商名称</label><input type="text" class="form-control" id="exampleInputPassword2" name="proName" />
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">供应商联系人</label><input type="text" class="form-control" id="exampleInputPassword3" name="name" />
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">联系电话</label><input type="text" class="form-control" id="exampleInputPassword4" name="phone"/>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">地址</label><input type="text" class="form-control" id="exampleInputPassword5" name="address" />
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">创建时间</label><input type="text" class="form-control" id="exampleInputPassword6" name="date" />
            </div>
        </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/jquery-1.8.3.min.js"></script>
<script>
    $(".viewUser").on("click", function () {
        var obj = $(this);
        $.getJSON("/t/user",{id:obj.attr("userId")},function (result) {
            $("#exampleInputPassword0").val(result.id);
            $("#exampleInputPassword1").val(result.proCode);
            $("#exampleInputPassword2").val(result.proName);
            $("#exampleInputPassword3").val(result.proContact);
            $("#exampleInputPassword4").val(result.proPhone);
            $("#exampleInputPassword5").val(result.proAddress);
            $("#exampleInputPassword6").val(result.creationDate);
        })
    })
    // $(".viewUser").on("click", function () {
    //     var obj = $(this);
    //     $.ajax({
    //         type: "get",
    //         url: "/t/user",
    //         data: {id: obj.attr("userId")},
    //         dataType: "json",
    //         success: function (result) {
    //             if ("failed" == result) {
    //                 alert("操作超时！");
    //             }
    //             else if ("nodata" == result) {
    //                 alert("没有数据！");
    //             }
    //             else {
    //                 $("#exampleInputPassword0").val(result.id);
    //                 $("#exampleInputPassword1").val(result.proCode);
    //                 $("#exampleInputPassword2").val(result.proName);
    //                 $("#exampleInputPassword3").val(result.proContact);
    //                 $("#exampleInputPassword4").val(result.proPhone);
    //                 $("#exampleInputPassword5").val(result.proAddress);
    //                 $("#exampleInputPassword6").val(result.creationDate);
    //             }
    //         },
    //         error: function (data) {
    //             alert("error");
    //         }
    //     });
    // });
</script>
</body>
</html>
