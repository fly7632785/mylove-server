<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>

<c:forEach items="${userlist}" var="item">
    userId:<c:out value="${item.id}"/>
    <br>
    username:<c:out value="${item.username}"/>
    password:<c:out value="${item.password}"/>
    <br>
</c:forEach>

<c:forEach items="${userlist}" var="item">
    username:
    <c:out value="${item.username}"/>
    username:
    <c:out value="${item.username}"/>

</c:forEach>

</body>
</html>
