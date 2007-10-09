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
        <title>Projeto Exemplo - Cadastrar Pessoas</title>
    </head>
    <f:view>
        <f:loadBundle basename="messages" var="msg"/>
        <body>
            <h:form>
                <h:outputLabel id="lblNome" style="height: 18px; left: 20px; top: 185px; position: absolute; width: 90px" value="#{msg.name}"/>
                <h:inputText value="#{cadastrarPessoa.nome}" required="true" id="txtNome" style="height: 20px; left: 20px; top: 205px; position: absolute; width: 240px">
                    <f:validateLength maximum="50" minimum="1"/>
                </h:inputText>
                <h:message showSummary="true" showDetail="false" style="color:red; font-weight:bold; left:280px; top:205px; width:400; position: absolute;" for="txtNome" />
                <h:commandButton action="#{cadastrarPessoa.gravar}" id="btnGravar" style="height: 20px; left: 19px; top: 235px; position: absolute; width: 70px" value="#{msg.save}"/>
            </h:form>
            <h:form>                
                <h:commandButton action="#{cadastrarPessoa.voltar}" id="btnVoltar" style="height: 20px; left: 19px; top: 565px; position: absolute; width: 70px" value="#{msg.back}"/>
                <h:outputLabel id="lblCadastrarPessoa" style="height: 20px; left: 210px; top: 110px; position: absolute; text-align: center; vertical-align: baseline; width: 300px" value="#{msg.registerPerson}"/>
                <h:graphicImage height="75" id="imgTopo1" style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                <h:graphicImage height="80" id="imgTopo2" style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                <h:graphicImage height="30" id="imgTopo4" style="height: 80px; left: 470px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                <h:graphicImage height="80" id="imgTopo3" style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                <h:graphicImage height="25" id="imgTopo5" style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
            </h:form>
        </body>
    </f:view>
</html>