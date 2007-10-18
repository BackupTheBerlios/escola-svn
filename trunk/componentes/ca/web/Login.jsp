<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<title>Login</title>
</head>
<f:view>
	<f:loadBundle basename="messages" var="msg" />
	<body>
	<h:form>
		<p>&nbsp;</p>
		<table width="391" height="229" border="0" align="center"
			bordercolor="#D7DDE5">
			<tr>
				<td width="385" height="225" bgcolor="#D7DDE5"><h:graphicImage
					value="/images/index_r1_c1.gif" /> <h:graphicImage
					value="/images/index_r1_c3.gif" />
				<table width="283" border="0" align="center" bgcolor="#D7DDE5">
					<tr>
						<td width="130" align="right"><h:outputLabel
							id="labelUsuario" value="#{msg.userName}:" /></td>
						<td align="right" width="143"><h:inputText
							value="#{login.usuario}" id="inputUsuario" required="true">
							<f:validateLength maximum="50" minimum="1" />
						</h:inputText></td>
						<td><h:message showSummary="true" showDetail="false"
							for="inputUsuario" /></td>
					</tr>
					<tr>
						<td align="right"><h:outputLabel id="labelSenha"
							value="#{msg.password}:" /></td>
						<td><h:inputSecret value="#{login.senha}" id="inputSenha"
							required="true">
							<f:validateLength maximum="50" minimum="1" />
						</h:inputSecret></td>
						<td><h:message showSummary="true" showDetail="false"
							for="inputSenha" /></td>
					</tr>
					<tr>
						<td height="21">&nbsp;</td>
						<td height="21"><h:commandButton
							action="#{login.efetuarLogin}" id="btnLogin" value="#{msg.login}" />
						&nbsp; <h:commandButton type="reset" value="#{msg.clean}" /></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<p align="center"><a href="RecuperarSenha.jsp" class="style5">Esqueci
		a senha!</a></p>
	</h:form>
	</body>
</f:view>

</html>