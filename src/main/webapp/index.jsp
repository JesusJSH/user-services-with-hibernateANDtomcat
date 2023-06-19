<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
    <form action="hello-servlet" method="get">
        <h1>Please, enter id to find user</h1>
        <input name="id">
    </form>
<br>
    <form action="hello-servlet" method="post">
        <h1>Please, enter your user parameters</h1>
        <h3>Name</h3>
        <input name="name">
        <h3>Surname</h3>
        <input name="surname">
        <h3>Age</h3>
        <input name="age">
        <button type="submit" value="submit">Save</button>
    </form>
<br>
<br>

<%--    <form action="hello-servlet" method="post">--%>
<%--        <h1>UserParameters</h1>--%>
<%--        <input name="id">--%>
<%--        <input name="name">--%>
<%--        <input name="surname">--%>
<%--        <input name="age">--%>
<%--        <button type="submit" value="submit">Update</button>--%>
<%--    </form>--%>
</body>
</html>