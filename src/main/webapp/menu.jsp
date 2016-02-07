<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>User Management</title>
    </head>
    <body>
        <hr>
        <h1>Menu Gestione Utenti</h1>
        <hr>
        <ul>
            <li>
                <a href="insertUsers.jsp">Inserimento Nuovo Utente</a>
            </li>
            <li>
                <a href="<s:url action="search"/>">Lista Utenti</a>
            </li>
            <li> 
                <a href="loginUsers.jsp">Login Utente</a>
            </li>
        </ul>





    </body>
</html>
