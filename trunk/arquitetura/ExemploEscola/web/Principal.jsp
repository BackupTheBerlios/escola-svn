<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{Principal.page1}" id="page1">
            <ui:html binding="#{Principal.html1}" id="html1">
                <ui:head binding="#{Principal.head1}" id="head1">
                    <ui:link binding="#{Principal.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{Principal.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{Principal.form1}" id="form1">
                        <ui:hyperlink action="#{Principal.hypCadastrarPessoa_action}" binding="#{Principal.hypCadastrarPessoa}" id="hypCadastrarPessoa"
                            style="height: 20px; left: 20px; top: 170px; position: absolute; width: 180px" text="Cadastrar Pessoa"/>
                        <ui:hyperlink action="#{Principal.hypListarPessoa_action}" binding="#{Principal.hypListarPessoa}" id="hypListarPessoa"
                            style="height: 20px; left: 20px; top: 200px; position: absolute; width: 180px" text="Listar"/>
                        <ui:button action="#{Principal.btnSair_action}" binding="#{Principal.btnSair}" id="btnSair"
                            style="height: 20px; left: 19px; top: 565px; position: absolute; width: 70px" text="Sair"/>
                        <ui:image binding="#{Principal.image1}" height="25" id="image1"
                            style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
                        <ui:image binding="#{Principal.imgTopo1}" height="75" id="imgTopo1"
                            style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                        <ui:image binding="#{Principal.image2}" height="30" id="image2"
                            style="height: 80px; left: 471px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                        <ui:image binding="#{Principal.imgTopo2}" height="80" id="imgTopo2"
                            style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                        <ui:image binding="#{Principal.image3}" height="80" id="image3"
                            style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                        <ui:label binding="#{Principal.label1}" id="label1"
                            style="height: 25px; left: 285px; top: 115px; position: absolute; text-align: center; width: 190px" text="Menu Principal"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
