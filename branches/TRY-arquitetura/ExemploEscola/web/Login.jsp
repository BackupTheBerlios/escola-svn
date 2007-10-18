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
    <title>Projeto Exemplo - Arquitetura Escola</title>
</head>
<f:view>
<f:loadBundle basename="messages" var="msg"/>        
<body>
<h:form>
    <h:inputText value="#{login.usuario}" id="txtUsuario" required="true" style="height: 20px; left: 20px; top: 165px; position: absolute; width: 260px">
        <f:validateLength maximum="50" minimum="1"/>
    </h:inputText>
    <h:message showSummary="true" showDetail="false" style="color:red; font-weight:bold; left:290px; top:165px; width:400; position: absolute;" for="txtUsuario"/>
    
    <h:inputSecret value="#{login.senha}" id="pwdSenha" required="true" style="height: 20px; left: 20px; top: 215px; position: absolute; width: 260px">
        <f:validateLength maximum="50" minimum="1"/>
    </h:inputSecret>
    <h:message showSummary="true" showDetail="false" style="color:red; font-weight:bold; left:290px; top:215px; width:400; position: absolute;" for="pwdSenha"/>
    
    <h:commandButton action="#{login.efetuarLogin}" id="btnLogin" style="height: 20px; left: 19px; top: 255px; position: absolute; width: 70px" value="#{msg.login}"/>
    <h:outputLabel id="staticText1" style="height: 20px; left: 20px; top: 145px; position: absolute; vertical-align: sub; width: 90px" value="#{msg.name}"/>
    <h:outputLabel id="staticText2" style="height: 15px; left: 20px; top: 195px; position: absolute; vertical-align: sub; width: 100px" value="#{msg.password}"/>
    <h:outputLabel id="staticText3" style="height: 20px; left: 260px; top: 105px; position: absolute; text-align: center; width: 260px" value="#{msg.project} - #{msg.projectName}"/>
    <h:graphicImage height="75" id="imgTopo1" style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
    <h:graphicImage height="80" id="imgTopo2" style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
    <h:graphicImage height="80" id="imgTopo3" style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
    <h:graphicImage height="30" id="imgTopo4" style="height: 80px; left: 471px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
    <h:graphicImage height="25" id="imgTopo5" style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
</h:form>
</body>
</f:view>
</html>