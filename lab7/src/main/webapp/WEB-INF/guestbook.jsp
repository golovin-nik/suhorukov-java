<%--
  Created by IntelliJ IDEA.
  User: n1k1t4
  Date: 04.07.19
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=US-ASCII"  language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Guest Book</title>
</head>
<body>
    <form method="post">
        <label>Enter your message</label>
        <input type="text" name="message" title="message">
        <input type="submit" value="Submit message">
    </form>
    <table border="1">
        <thead>
            <tr>
                <td>ID</td><td>POST DATE</td><td>POST MESSAGE</td>
            </tr>
        </thead>
        <tbody>
            <%--@elvariable id="records" type="java.util.List"--%>
            <c:forEach var="r" items="${records}">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.postDate}</td>
                    <td>${r.postMessage}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
