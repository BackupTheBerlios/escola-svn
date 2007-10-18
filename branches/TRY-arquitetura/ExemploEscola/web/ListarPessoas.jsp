<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"  %>
<%@ taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
    <head>
        <title>Projeto Exemplo - Listar Pessoas</title>
        <style type="text/css">
            @import url('css/estiloTabela.css');
        </style>
    </head>
    <f:view>
        <f:loadBundle basename="messages" var="msg"/>
        <body>
            <h:form>
                <h:commandButton action="#{listarPessoas.voltar}" id="btnVoltar" style="height: 20px; left: 19px; top: 560px; position: absolute; width: 70px" value="#{msg.back}"/>
                <h:outputLabel id="staticText3" style="height: 20px; left: 260px; top: 105px; position: absolute; text-align: center; width: 260px" value="#{msg.peopleList}"/>
                <h:graphicImage height="80" id="imgTopo3" style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                <h:graphicImage height="80" id="imgTopo2" style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                <h:graphicImage height="25" id="imgTopo5" style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
                <h:graphicImage height="30" id="imgTopo4" style="height: 80px; left: 470px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                <h:graphicImage height="75" id="imgTopo1" style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                
                <h:dataTable var="pessoa" value="#{listarPessoas.pessoasCadastradas}" binding="#{listarPessoas.htmlDataTable}" styleClass="geral" rowClasses="impar,par" footerClass="rodape" headerClass="cabecalho" title="#{msg.peopleList}" rows="13">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Id"/>
                        </f:facet>
                        <h:outputText value="#{pessoa.id}"></h:outputText>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Nome"/>
                        </f:facet>
                        <h:outputText value="#{pessoa.nome}"></h:outputText>
                    </h:column>
                    
                    <f:facet name="footer">
                        <h:panelGroup>
                            <h:commandButton
                                value="<<"
                                action="#{listarPessoas.pageFirst}"
                                disabled="#{listarPessoas.htmlDataTable.first == 0}"
                                styleClass="botao"
                            />
                            <h:commandButton
                                value="<"
                                action="#{listarPessoas.pagePrevious}"
                                disabled="#{myBean.htmlDataTable.first == 0}"
                                styleClass="botao"
                            />
                            <h:commandButton
                                value=">"
                                action="#{listarPessoas.pageNext}"
                                disabled="#{listarPessoas.htmlDataTable.first + listarPessoas.htmlDataTable.rows >= listarPessoas.htmlDataTable.rowCount}"
                                styleClass="botao"
                            />
                            <h:commandButton
                                value=">>"
                                action="#{listarPessoas.pageLast}"
                                disabled="#{listarPessoas.htmlDataTable.first + listarPessoas.htmlDataTable.rows >= listarPessoas.htmlDataTable.rowCount}"
                                styleClass="botao"
                            />
                        </h:panelGroup>
                    </f:facet>
                </h:dataTable>
            </h:form>
        </body>
    </f:view>
</html>