<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<title></title>
</head>
<body>
<f:view>
	<table width="598" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center"><h:outputText value="Cadastrar Usuário" /><br>
			</td>
		</tr>
		<tr>
			<td width="598" height="37" align="center" valign="top"
				class="bordamenu"><h:form id="formCadastroUsuario">
				<table width="500" cellpadding="5">
					<tr>
						<td align="right"><h:outputLabel value="N° documento:" for=""></h:outputLabel>
						</td>
						<td><h:inputText value="documento"></h:inputText>&nbsp;<h:graphicImage
							value="/images/lupa.jpg"></h:graphicImage></td>
					</tr>
					<tr>
						<td align="right"><h:outputLabel value="Usuário:"></h:outputLabel></td>
						<td><h:inputText value="usuario"></h:inputText></td>
						<td></td>
					</tr>
					<tr>
						<td align="right"><h:outputLabel value="Validade:" for=""></h:outputLabel></td>
						<td><h:inputText value="validade"></h:inputText>&nbsp; <h:graphicImage
							value="/images/cal.gif"></h:graphicImage></td>
						<td></td>
					</tr>
					<tr>
						<td align="right"><h:outputLabel value="Disponível:" for=""></h:outputLabel>
						</td>
						<td><h:selectOneRadio id="radio1" layout="lineDirection">
							<f:selectItem id="Sim" itemLabel="Sim" itemValue="true" />
						</h:selectOneRadio></td>
						<td><h:selectOneRadio id="radio2" layout="lineDirection">
							<f:selectItem id="Nao" itemLabel="Não" itemValue="false" />
						</h:selectOneRadio></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><h:commandButton id="btngravar"
							actionListener="#{cadastrarUsuario.gravar}" value="Salvar" /></td>
					</tr>
				</table>
				<br>
				<br>
				<h:messages showDetail="false" showSummary="true" />
			</h:form></td>
	</table>

</f:view>
</body>
</html>