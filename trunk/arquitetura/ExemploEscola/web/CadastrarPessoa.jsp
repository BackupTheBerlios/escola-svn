<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{CadastrarPessoa.page1}" id="page1">
            <ui:html binding="#{CadastrarPessoa.html1}" id="html1">
                <ui:head binding="#{CadastrarPessoa.head1}" id="head1">
                    <ui:link binding="#{CadastrarPessoa.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{CadastrarPessoa.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{CadastrarPessoa.form1}" id="form1">
                        <ui:textField binding="#{CadastrarPessoa.txtNome}" id="txtNome" style="height: 20px; left: 20px; top: 205px; position: absolute; width: 240px"/>
                        <ui:label binding="#{CadastrarPessoa.lblNome}" id="lblNome"
                            style="height: 18px; left: 20px; top: 185px; position: absolute; width: 90px" text="Nome"/>
                        <ui:button action="#{CadastrarPessoa.btnGravar_action}" binding="#{CadastrarPessoa.btnGravar}" id="btnGravar"
                            style="height: 20px; left: 19px; top: 235px; position: absolute; width: 70px" text="Gravar"/>
                        <ui:button action="#{CadastrarPessoa.btnVoltar_action}" binding="#{CadastrarPessoa.btnVoltar}" id="btnVoltar"
                            style="height: 20px; left: 19px; top: 565px; position: absolute; width: 70px" text="Voltar"/>
                        <ui:label binding="#{CadastrarPessoa.lblCadastrarPessoa}" id="lblCadastrarPessoa"
                            style="height: 20px; left: 210px; top: 110px; position: absolute; text-align: center; vertical-align: baseline; width: 300px" text="Cadastrar Pessoa"/>
                        <ui:image binding="#{CadastrarPessoa.imgTopo1}" height="75" id="imgTopo1"
                            style="height: 80px; left: 20px; top: 15px; position: absolute; width: 151px" url="/resources/topo1.jpg" width="140"/>
                        <ui:image binding="#{CadastrarPessoa.imgTopo2}" height="80" id="imgTopo2"
                            style="height: 80px; left: 170px; top: 15px; position: absolute; width: 151px" url="/resources/topo2.jpg" width="75"/>
                        <ui:image binding="#{CadastrarPessoa.imgTopo4}" height="30" id="imgTopo4"
                            style="height: 80px; left: 470px; top: 15px; position: absolute; width: 151px" url="/resources/topo4.jpg" width="105"/>
                        <ui:image binding="#{CadastrarPessoa.imgTopo3}" height="80" id="imgTopo3"
                            style="height: 80px; left: 320px; top: 15px; position: absolute; width: 151px" url="/resources/topo3.jpg" width="75"/>
                        <ui:image binding="#{CadastrarPessoa.imgTopo5}" height="25" id="imgTopo5"
                            style="height: 80px; left: 621px; top: 15px; position: absolute; width: 151px" url="/resources/topo5.jpg" width="85"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
