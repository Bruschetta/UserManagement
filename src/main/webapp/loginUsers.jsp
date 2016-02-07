<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Management</title>
    </head>
    <body>

        <h1>Login utente</h1>
        <hr>
        <s:actionerror/>
        <s:form action="login">
            <s:textfield name="user.username" maxlength="44"label="Username"/>
            <s:password name="user.password" maxlength="44" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>