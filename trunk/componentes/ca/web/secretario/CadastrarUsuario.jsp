<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastrar Usuário</title>
</head>
<body>
<f:view>
	<f:loadBundle basename="messages" var="msg" />
	<table width="598" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center"><h:outputText value="Cadastrar Usuário" /><br>
			</td>
		</tr>
		<tr>
			<td width="598" height="37" align="center" valign="top"
				class="bordamenu"><h:form id="formConsultarPessoa">
				<table width="500" cellpadding="5">
					<tr>
						<td align="right"><h:outputLabel value="N° documento:" for=""></h:outputLabel>
						</td>
						<td><h:inputText value="#{cadastrarUsuario.numeroDocumento}" />&nbsp;
						<h:commandLink
							actionListener="#{cadastrarUsuario.consultarPessoa}">
							<h:graphicImage value="/images/lupa.jpg" style="border: none"
								alt="lupa.gif" title="Consultar Pessoa" />
						</h:commandLink></td>
					</tr>
					<c:if test="${sessionScope.cadastrarUsuario.nomePessoa != null}">
						<tr>
							<td align="right"><h:outputText value="ID:" /></td>
							<td><h:outputText value="#{cadastrarUsuario.idPessoa}" /></td>
						</tr>


						<tr>
							<td align="right"><h:outputText value="Nome:" /></td>
							<td colspan="2"><h:outputText
								value="#{cadastrarUsuario.nomePessoa}" /></td>
						</tr>
						<tr>
							<td align="right"><h:outputLabel value="Usuário:"></h:outputLabel></td>
							<td><h:inputText value="#{cadastrarUsuario.username}"
								required="true" /></td>
						</tr>
						<tr>
							<td align="right"><h:outputLabel value="Validade:" for=""></h:outputLabel></td>
							<td><h:inputText value="#{cadastrarUsuario.validade}">
								<f:converter converterId="converteStringEmData" />
							</h:inputText> &nbsp; <h:graphicImage value="/images/cal.gif"></h:graphicImage></td>
						</tr>
						<tr>
							<td align="right"><h:outputLabel value="Disponível:"></h:outputLabel>
							</td>
							<td><h:selectOneRadio id="radio1" layout="lineDirection"
								converter="converteStringEmBoolean"
								value="#{cadastrarUsuario.disponibilidade}">
								<f:selectItem id="radioSim" itemLabel="Sim" itemValue="true" />
								<f:selectItem id="radioNao" itemLabel="Não" itemValue="false" />
							</h:selectOneRadio></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><h:commandButton id="btnGravar"
								actionListener="#{cadastrarUsuario.gravar}" value="Salvar" /></td>
						</tr>
					</c:if>
					<tr>
						<td><h:commandButton action="#{listarUsuarios.voltar}"
							id="btnVoltar" value="#{msg.back}" immediate="true"/></td>
					</tr>

				</table>
			</h:form> <br>
			<br>
			<h:messages showDetail="false" showSummary="true" /></td>
	</table>

</f:view>
</body>
</html>