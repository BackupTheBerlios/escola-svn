<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{ListarPessoas.page1}" id="page1">
            <ui:html binding="#{ListarPessoas.html1}" id="html1">
                <ui:head binding="#{ListarPessoas.head1}" id="head1">
                    <ui:link binding="#{ListarPessoas.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{ListarPessoas.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{ListarPessoas.form1}" id="form1">
                        <ui:button action="#{ListarPessoas.btnVoltar_action}" binding="#{ListarPessoas.btnVoltar}" id="btnVoltar"
                            style="height: 20px; left: 19px; top: 540px; position: absolute; width: 70px" text="Voltar"/>
                        <ui:image binding="#{ListarPessoas.imgTopo3}" height="80" id="imgTopo3"
                            style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                        <ui:image binding="#{ListarPessoas.imgTopo1}" height="75" id="imgTopo1"
                            style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                        <ui:image binding="#{ListarPessoas.imgTopo4}" height="30" id="imgTopo4"
                            style="height: 80px; left: 470px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                        <ui:image binding="#{ListarPessoas.imgTopo2}" height="80" id="imgTopo2"
                            style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                        <ui:image binding="#{ListarPessoas.imgTopo5}" height="25" id="imgTopo5"
                            style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
                        <ui:table augmentTitle="false" binding="#{ListarPessoas.tblListaPessoas}" id="tblListaPessoas" paginateButton="true"
                            paginationControls="true" style="height: 285px; left: 20px; top: 120px; position: absolute; width: 400px"
                            title="Lista de Pessoas Cadastradas" width="401">
                            <ui:tableRowGroup binding="#{ListarPessoas.trGPessoas}" emptyDataMsg=" " id="trGPessoas" rows="15"
                                sourceData="#{ListarPessoas.objectListDataProvider}" sourceVar="currentRow">
                                <ui:tableColumn binding="#{ListarPessoas.tblCCodigo}" headerText="Código" id="tblCCodigo" sort="id" width="70">
                                    <ui:staticText binding="#{ListarPessoas.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn binding="#{ListarPessoas.tblCNome}" headerText="Nome" id="tblCNome" sort="nome" width="330">
                                    <ui:staticText binding="#{ListarPessoas.staticText2}" id="staticText2" text="#{currentRow.value['nome']}"/>
                                </ui:tableColumn>
                            </ui:tableRowGroup>
                        </ui:table>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
