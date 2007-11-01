<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Alterar Senha</title>
</head>
<f:view>
	<f:loadBundle basename="messages" var="msg" />
	<body>
	<h:form>
		<table>
			<tr>
				<td><h:outputLabel id="labelUsername" value="#{msg.userName}:" />
				</td>
				<td><h:outputLabel id="labelUsuario"
					value="#{alterarSenha.usuarioLogado}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel id="labelOldPassword"
					value="#{msg.oldPassword}" /></td>
				<td><h:inputSecret value="#{alterarSenha.senhaAtual}"
					id="pwdSenhaAtual" required="true">
					<f:validateLength maximum="50" minimum="1" />
				</h:inputSecret></td>
			<tr>
				<td><h:outputLabel id="labelNewPassword"
					value="#{msg.newPassword}" /></td>
				<td><h:inputSecret value="#{alterarSenha.senhaNova}"
					id="pwdSenhaNova" required="true">
					<f:validateLength maximum="50" minimum="1" />
				</h:inputSecret></td>
			<tr>
				<td><h:commandButton
					actionListener="#{alterarSenha.alterarSenhaAction}" id="btnLogin"
					action="alterarSenha" value="#{msg.ok}" /></td>
			</tr>
		</table>
		<br>
		<h:messages showDetail="false" showSummary="true" />
		<br>
		<p><a href="Principal.jsp">Voltar</a>
	</h:form>
	</body>
</f:view>
</html>