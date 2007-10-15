<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="sitemesh-page" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="sitemesh-decorator" %>
<html>
<head>
<title>Cadastro Disciplinas</title>
</head>
<body >
<f:view>
	<h:form>
	<!-- CONTEUDO -->
	<table width="598" border="0" cellpadding="0" cellspacing="0"
		class="tbconteudo">

		<tr>
			<td><img src="images/spacer.gif" width="598" height="1"
				border="0" alt="" /></td>
			<td><img src="images/spacer.gif" width="1" height="1" border="0"
				alt="" /></td>
		</tr>

		<tr>
			<td width="598" height="26" background="images/conteudo_r1_c1.gif"
				align="center" valign="top"><strong><font
				color="#FFFFFF">Cadastro Disciplinas </font></strong></td>
			<td><img src="images/spacer.gif" width="1" height="26"
				border="0" alt="" /></td>
		</tr>
		<tr>
			<td width="598" height="377" align="center" valign="top"
				class="bordamenu"><h:form id="cadastroAluno">
					
				<h:panelGrid columns="2">
					
				<h:outputText value="Curso:"/>
				
				<h:selectOneMenu id="cursos" value="#{disciplinaController.cursoItem}">
						<f:selectItems value="#{disciplinaController.cursosItens}" />			
				</h:selectOneMenu>
				
				<h:outputText value="Codigo:"/>
				<h:inputText value="#{disciplinaController.codigo}" size="10"/>
				<h:outputText value="Nome:"/>
				<h:inputText value="#{disciplinaController.nome}" />
				<h:outputText value="Carga Horaria"/>
				<h:inputText value="#{disciplinaController.cargaHoraria}" />
				
				</h:panelGrid><h:commandButton action="#{disciplinaController.gravar}" value="Inserir!" />
				
				</h:form>
				<br />


			</td>
			<td><img src="images/spacer.gif" width="1" height="377"
				border="0" alt="" /></td>
		</tr>
		<tr>
			<td width="598" height="10" background="images/conteudo_r3_c1.gif"></td>
			<td><img src="images/spacer.gif" width="1" height="10"
				border="0" alt="" /></td>
		</tr>
	</table>
   </h:form>	
</f:view>
</body>
</html>
