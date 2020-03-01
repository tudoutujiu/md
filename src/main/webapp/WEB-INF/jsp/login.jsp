<%--
  Created by IntelliJ IDEA.
  User: 17827
  Date: 2019/11/24
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Laugh, and the world laughs with you</title>
    <script src="${pageContext.request.contextPath}/public/script/js/jquery-2.1.4.min.js"></script>
    <script>
        $("#zc").onclick(function () {

        })
    </script>
</head>
<body>
    <form action="/login" method="post">
        <label>用户名:</label><input type="text" id="username" name="username"/><br/>
        <label>密码:</label><input type="password" id="password" name="password"/><br/>
        <input type="submit" value="登录"/>
        <input type="button" value="注册" id="zc"/>
    </form>
</body>
</html>
