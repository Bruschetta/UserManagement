<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>User Management</title>
    </head>
    <body>

        <h1>Creazione nuovo utente</h1>
        <hr>

        <s:set name="type" value="actiontipe"/>
        <s:actionerror />
        <s:form action="add" method="post">
            <s:hidden name="id" value="%{user.id}"/>
            <s:textfield name="user.nome" maxlength="44" value="%{user.nome}" label="Nome"/>
            <s:textfield name="user.cognome" maxlength="44" value="%{user.cognome}" label="Cognome"/>
            <s:textfield name="user.username" maxlength="44" value="%{user.username}" label="Username"/>
            <s:password name="user.password" maxlength="44" value="%{user.password}" label="Password"/>
            <s:textfield name="user.email" maxlength="59" value="%{user.email}" label="Email"/>
            <s:submit style="margin-left:35px" value="Inserisci utente" align="center"/>
        </s:form>
        <s:if test="hasActionMessages()">
            <s:actionmessage />
            <ul>
                <li>
                    <a href="insertUsers.jsp">Inserisci nuovo utente</a>
                </li>
                <li>
                    <a href="<s:url action="search"/>">Lista Utenti</a>
                </li>
                <li>
                    <a href="menu.jsp">Torna al menu</a>
                </li>
            </ul>
        </s:if>
        <hr>
    </body>
</html>