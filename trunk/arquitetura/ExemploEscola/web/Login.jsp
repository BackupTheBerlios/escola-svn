<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{Login.page1}" id="page1">
            <ui:html binding="#{Login.html1}" id="html1">
                <ui:head binding="#{Login.head1}" id="head1">
                    <ui:link binding="#{Login.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{Login.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{Login.form1}" id="form1">
                        <ui:textField binding="#{Login.txtUsuario}" id="txtUsuario" required="true" style="height: 20px; left: 20px; top: 165px; position: absolute; width: 260px"/>
                        <ui:passwordField binding="#{Login.pwdSenha}" id="pwdSenha" required="true" style="height: 20px; left: 20px; top: 215px; position: absolute; width: 260px"/>
                        <ui:button action="#{Login.btnLogin_action}" binding="#{Login.btnLogin}" id="btnLogin"
                            style="height: 20px; left: 19px; top: 255px; position: absolute; width: 70px" text="Login"/>
                        <ui:staticText binding="#{Login.staticText1}" id="staticText1"
                            style="height: 20px; left: 20px; top: 140px; position: absolute; vertical-align: sub; width: 90px" text="Nome"/>
                        <ui:staticText binding="#{Login.staticText2}" id="staticText2"
                            style="height: 15px; left: 20px; top: 195px; position: absolute; vertical-align: sub; width: 100px" text="Senha"/>
                        <ui:staticText binding="#{Login.staticText3}" id="staticText3"
                            style="height: 20px; left: 260px; top: 105px; position: absolute; text-align: center; width: 260px" text="Projeto Exemplo - Arquitetura Escola"/>
                        <ui:image binding="#{Login.imgTopo1}" height="75" id="imgTopo1"
                            style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                        <ui:image binding="#{Login.imgTopo2}" height="80" id="imgTopo2"
                            style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                        <ui:image binding="#{Login.imgTopo3}" height="80" id="imgTopo3"
                            style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                        <ui:image binding="#{Login.imgTopo4}" height="30" id="imgTopo4"
                            style="height: 80px; left: 471px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                        <ui:image binding="#{Login.imgTopo5}" height="25" id="imgTopo5"
                            style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
