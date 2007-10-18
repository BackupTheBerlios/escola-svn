<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.acegisecurity.context.SecurityContextHolder"%>
<html>
<head>
<title>Listar Usuarios</title>
<style type="text/css">
@import url('css/tabelas.css');
</style>
</head>
Usuário logado como:
<%=SecurityContextHolder.getContext().getAuthentication()
							.getName()%>
<f:view>
	<f:loadBundle basename="messages" var="msg" />
	<body>
	<h:form>
	<br>
		<table>
			<tr>
				<td><h:outputLabel id="staticText3" value="#{msg.userList}" />
				</td>
			</tr>
			<tr>
				<td><h:dataTable id="tabela1"
					value="#{listarUsuarios.usuariosCadastrados}" var="item"
					binding="#{listarUsuarios.htmlDataTable}" styleClass="geral"
					rowClasses="impar,par" footerClass="rodape" headerClass="cabecalho"
					title="#{msg.userList}" rows="5">

					<h:column>
						<f:facet name="header">
							<h:outputText value="Usuario" />
						</f:facet>
						<h:outputText value="#{item}"></h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="Operação" />
						</f:facet>
						<h:commandButton actionListener="#{listarUsuarios.excluir}" value="Excluir" />
					</h:column>

					<f:facet name="footer">
						<h:panelGroup>
							<h:commandButton value="primeira"
								action="#{listarUsuarios.pageFirst}"
								disabled="#{listarUsuarios.htmlDataTable.first == 0}"
								styleClass="botao" />
							<h:commandButton value="anterior"
								action="#{listarUsuarios.pagePrevious}"
								disabled="#{listarUsuarios.htmlDataTable.first == 0}"
								styleClass="botao" />
							<h:commandButton value="próxima"
								action="#{listarUsuarios.pageNext}"
								disabled="#{listarUsuarios.htmlDataTable.first + listarUsuarios.htmlDataTable.rows >= listarUsuarios.htmlDataTable.rowCount}"
								styleClass="botao" />
							<h:commandButton value="última"
								action="#{listarUsuarios.pageLast}"
								disabled="#{listarUsuarios.htmlDataTable.first + listarUsuarios.htmlDataTable.rows >= listarUsuarios.htmlDataTable.rowCount}"
								styleClass="botao" />
						</h:panelGroup>
					</f:facet>
				</h:dataTable></td>
			<tr>
				<td><h:commandButton action="#{listarUsuarios.voltar}"
					id="btnVoltar" value="#{msg.back}" /></td>
			</tr>
		</table>
		<h:messages showDetail="false" showSummary="true" />
	</h:form>
	</body>
</f:view>
</html>