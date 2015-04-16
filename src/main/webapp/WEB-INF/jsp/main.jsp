
<html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head></head>
<body>
    <h1>Student Data Form</h1>

    <br/>
    ${message}<br/>
    <s:form commandName="student" method="post" action="student">
    <table border="1">
        <tr>
            <td>Id</td>
            <td><s:input type="text" path="id" /></td>
        </tr>
         <tr>
            <td>User Name</td>
            <td><s:input type="text" path="name" /></td>
        </tr>
         <tr>
            <td>E-mail</td>
            <td><s:input type="text" path="pword" /></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" name="action" value="Add" />
                <input type="submit" name="action" value="Edit" />
                <input type="submit" name="action" value="Delete"/>
                <input type="submit" name="action" value="Search"/>
            </td>
        </tr>
    </table>
    </s:form>
    <br/>
      <table border="1">
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <c:forEach items="${studentList}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.pword}</td>
                    </tr>
                </c:forEach>
            </table>
</body>
</html>