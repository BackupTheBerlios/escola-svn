<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<title></title>
</head>
<body>
<f:view>
	<table width="598" border="0" cellpadding="0" cellspacing="0"
		class="tbconteudo">
		<tr>
			<td><img src="/images/spacer.gif" width="598" height="1"
				border="0" alt="" /></td>

			<td><img src="/images/spacer.gif" width="1" height="1"
				border="0" alt="" /></td>
		</tr>
		<tr>
			<td width="598" height="26" background="/images/conteudo_r1_c1.gif"
				align="center" valign="top"><strong><font
				color="#FFFFFF">Cadastrar Usuário </font></strong></td>
			<td><img src="../images/spacer.gif" width="1" height="26"
				border="0" alt="" /></td>
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
					<td><h:selectOneRadio>
						<f:selectItems value="true" /> Sim
				</h:selectOneRadio></td>
					<td><h:selectOneRadio value="false">
						<f:selectItems value="false" />Não
				</h:selectOneRadio></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><h:commandButton action="0" value="Salvar"></h:commandButton>
					</td>
				</tr>
			</table>
		</h:form>
		</td>
		<td><img src="/images/spacer.gif" width="1" height="377"
			border="0" alt="" /></td>
		</tr>
		<tr>
			<td width="598" height="10" background="/images/conteudo_r3_c1.gif"></td>
			<td><img src="/images/spacer.gif" width="1" height="10"
				border="0" alt="" /></td>
		</tr>
		</table>
</f:view>
</body>
</html>
