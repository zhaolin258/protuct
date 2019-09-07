<%--
  Created by IntelliJ IDEA.
  User: zhaolin
  Date: 2019/9/6
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>单文件上传</h2>
<form action="/f/one.html" method="post" enctype="multipart/form-data">
        <input type="file" name="file" id="attach" onchange="changepic(this)" accept="application/pdf">
    <input type="submit"  value="上传">
    <div style="width: 100px;height: 100px">
        <img src="" id="show" width="100px" height="100px">
    </div>
</form>
<h2>多文件上传</h2>
<form action="/f/two.html" method="post" enctype="multipart/form-data">
    <input type="file" name="files" multiple="multiple">
    <input type="submit"  value="上传">
</form>
<h3>文件下载</h3>
<<a href="#"></a>
<<a href="#"></a>
<script src="/static/js/jquery-1.8.3.min.js"></script>
<script>
    function changepic() {
        var reads= new FileReader();
        var f=document.getElementById('attach').files[0];
        reads.readAsDataURL(f);
        reads.onload=function (e) {
            document.getElementById('show').src=this.result;
        };
    }
</script>
</body>
</html>
