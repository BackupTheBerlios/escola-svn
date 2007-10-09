<%-- 
    Document   : Login2
    Created on : 27/09/2007, 10:58:32
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"  %>
<%@ taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
    <head>
        <title>Projeto Exemplo - Menu Principal</title>
    </head>
    <f:view>
        <f:loadBundle basename="messages" var="msg"/>
        <body>
            <h:form>
                <h:commandLink action="#{principal.cadastrarPessoa}" id="hypCadastrarPessoa" style="height: 20px; left: 20px; top: 170px; position: absolute; width: 180px" value="#{msg.registerPerson}"/>
                <h:commandLink action="#{principal.listarPessoas}" id="hypListarPessoa" style="height: 20px; left: 20px; top: 200px; position: absolute; width: 180px" value="#{msg.toListPeople}"/>
                <h:commandButton actionListener="#{principal.sair}" action="sair" id="btnSair" style="height: 20px; left: 19px; top: 565px; position: absolute; width: 70px" value="#{msg.exit}"/>
                <h:graphicImage height="25" id="image1" style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
                <h:graphicImage height="75" id="imgTopo1" style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                <h:graphicImage height="30" id="image2" style="height: 80px; left: 471px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                <h:graphicImage height="80" id="imgTopo2" style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                <h:graphicImage height="80" id="image3" style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                <h:outputLabel id="label1" style="height: 25px; left: 285px; top: 115px; position: absolute; text-align: center; width: 190px" value="#{msg.mainMenu}"/>
            </h:form>
        </body>
    </f:view>
</html>