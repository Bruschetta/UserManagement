<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>User Management</title>
    </head>
    <body>

        <h1>Modifica utente <s:property value="user.username"/></h1>
        <hr>

        <s:set name="type" value="actiontipe"/>
        <s:actionerror/>
        <s:form action="edit" method="post">
            <s:hidden name="user.id" value="%{user.id}"/>
            <s:hidden name="user.username" value="%{user.username}" /> 
            <s:hidden name="user.email" value="%{user.email}" /> 
            <s:hidden name="user.datacreazione" value="%{user.datacreazione}" /> 
            <s:textfield name="user.nome" value="%{user.nome}" label="Nome"/>
            <s:textfield name="user.cognome" value="%{user.cognome}" label="Cognome"/>
            <s:password name="user.password" value="%{user.password}" label="Password"/>
            <s:submit style="margin-left:35px" value="Modifica utente" align="center"/>
        </s:form>     
        <s:if test="hasActionMessages()">
            <s:actionmessage/>
            <ul >
                <li>
                    <a href="insertUsers.jsp">Inserisci nuovo utente</a>
                </li>
                <li>
                    <a href="<s:url action="search"/>">Lista Utenti</a>
                </li>
            </ul>
        </s:if>
        <hr>
    </body>
</html>