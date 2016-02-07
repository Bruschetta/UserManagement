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
        <h2>Benvenuto,<s:property value="user.username"/></h2>
        <b>Il  tuo menu gestione utenti</b>
       
        <ul>
            <li>
                <a href="insertUsers.jsp">Inserimento Nuovo Utente</a>
            </li>
            <li>
                <a href="<s:url action="search"/>">Lista Utenti</a>
            </li>
        </ul>
    </body>
</html>
