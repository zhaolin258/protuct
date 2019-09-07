<%--
  Created by IntelliJ IDEA.
  User: zhaolin
  Date: 2019/9/4
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <form action="/Add.html" role="form">
                <div class="form-group">
                    <label for="exampleInputPassword1">供应商编码</label><input type="text" class="form-control" id="exampleInputPassword1" name="proCode"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">供应商编码名称</label><input type="text" class="form-control" id="exampleInputPassword2" name="proName"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">供应商联系人</label><input type="text" class="form-control" id="exampleInputPassword3" name="name"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">联系电话</label><input type="text" class="form-control" id="exampleInputPassword4" name="phone"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">地址</label><input type="text" class="form-control" id="exampleInputPassword5" name="address"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">创建时间</label><input type="text" class="form-control" id="exampleInputPassword6" name="date"/>
                </div>
                <button type="submit" class="btn btn-danger">提交</button>
                <button type="reset" class="btn btn-info">取消</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
