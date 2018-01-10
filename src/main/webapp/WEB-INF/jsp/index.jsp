<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shreya
  Date: 28/11/17
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$ ABCD
  <br/>
  <c:forEach items="${userList}" var="user" >
     ${user.userName}
    <br/>
  </c:forEach>

  </body>
</html>
