<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
<head>
<title>Recuperar Senha</title>
</head>
<f:view>
	<f:loadBundle basename="messages" var="msg" />
	<body>
	<h:form>
		<h:outputLabel
			value="Entre com o seu nome de usuário, clique em OK e a senha será enviada para seu endereço de e-mail." />
			<br><br>
		<table>
			<tr>
				<td><h:outputLabel id="labelUsuario" value="#{msg.userName}:" />
				</td>
				<td><h:inputText value="#{recuperarSenha.usuario}"
					id="inputUsuario" required="true">
					<f:validateLength maximum="50" minimum="1" />
				</h:inputText></td>
				<td><h:message showSummary="true" showDetail="false"
							for="inputUsuario" /></td>
			</tr>
		</table>
		<br>
		<br>
		<h:commandButton action="#{recuperarSenha.recuperar}" id="btnOK"
			value="#{msg.ok}" />
	</h:form>
	<h:messages showDetail="false" showSummary="true" />
	</body>
</f:view>
</html>