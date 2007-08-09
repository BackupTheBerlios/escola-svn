<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{AcessoNegado.page1}" id="page1">
            <ui:html binding="#{AcessoNegado.html1}" id="html1">
                <ui:head binding="#{AcessoNegado.head1}" id="head1">
                    <ui:link binding="#{AcessoNegado.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{AcessoNegado.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{AcessoNegado.form1}" id="form1">
                        <ui:image binding="#{AcessoNegado.image1}" height="70" id="image1" style="left: 285px; top: 260px; position: absolute"
                            url="/resources/stop.png" width="90"/>
                        <ui:button action="#{AcessoNegado.btnOk_action}" binding="#{AcessoNegado.btnOk}" id="btnOk"
                            style="height: 20px; left: 19px; top: 565px; position: absolute; width: 70px" text="Ok"/>
                        <ui:label binding="#{AcessoNegado.label1}" id="label1" style="height: 20px; left: 385px; top: 280px; position: absolute; width: 118px" text="Acesso Negado!"/>
                        <ui:image binding="#{AcessoNegado.imgTopo3}" height="80" id="imgTopo3"
                            style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                        <ui:image binding="#{AcessoNegado.imgTopo2}" height="80" id="imgTopo2"
                            style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                        <ui:image binding="#{AcessoNegado.imgTopo5}" height="25" id="imgTopo5"
                            style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
                        <ui:image binding="#{AcessoNegado.imgTopo4}" height="30" id="imgTopo4"
                            style="height: 80px; left: 470px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                        <ui:image binding="#{AcessoNegado.imgTopo1}" height="75" id="imgTopo1"
                            style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
