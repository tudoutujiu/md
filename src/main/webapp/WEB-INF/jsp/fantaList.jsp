<%--
  Created by IntelliJ IDEA.
  User: 17827
  Date: 2019/11/24
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="init">
        <span>饮料序号:</span>${init.id}<br/>
        <span>饮料名字:</span>${init.name}<br/>
        <span>饮料价格:</span>${init.price}<br/>
        <span>饮料存量:</span>${init.stock}<br/>
        <span>饮料详情:</span>${init.details}<br/>
    </c:forEach>
</body>
</html>
