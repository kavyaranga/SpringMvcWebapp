
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<h1>Welcome to the website</h1>
${message}<br/>
  <s:form action="login" commandName="account" method="post">
          User Name: <s:input type="text" path="username" /><br/>
           Password: <s:input type="password" path="password" /><br/>
          <input type="submit" value="Login"/>
    </s:form>
    </body>
</html>
