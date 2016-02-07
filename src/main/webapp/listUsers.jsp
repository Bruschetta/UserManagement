<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
    </head>
    <body>
        <h1>Lista Utenti</h1>
        <hr>
        <s:actionerror/>
        <s:form action="search" method="post">
            <s:textfield name="user.username" label="Username"/>
            <s:textfield name="user.email" label="Email"/>
            <s:submit value="Ricerca Utenti" align="center" style="margin-left:27px"/>
            <s:submit value="Clear" action="myClearAction"/>
        </s:form>
        <hr>
        <s:actionerror/>
        <div class="content">
            <table class="userTable" cellpadding="5px">
                <tr class="even">
                    <th>id</th>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Data Creazione</th>
                    <th>Data Modifica</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <s:iterator value="userList" status="stat">  
                    <tr >
                        <td><s:property value="id" /></td>
                        <td><s:property value="nome" /></td>
                        <td><s:property value="cognome" /></td>
                        <td><s:property value="username" /></td>
                        <td><s:property value="email" /></td>
                        <td><s:property value="datacreazione" /></td>
                        <td><s:property value="datamodifica" /></td>
                        <td>
                            <s:url id="findURL" action="findUser">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{findURL}">Edit</s:a>
                            </td>
                            <td>
                            <s:url id="deleteURL" action="deleteUser">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{deleteURL}">Delete</s:a>
                            </td>
                        </tr>
                </s:iterator>
            </table>
        </div>
    </body>
</html>
