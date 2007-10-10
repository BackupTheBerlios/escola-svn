<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page"
	prefix="sitemesh-page"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="sitemesh-decorator"%>
<html>
<head>
<title>Pagina de Teste</title>
</head>
<body >
<f:view>
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
				color="#FFFFFF">Cadastrar Aluno </font></strong></td>
			<td><img src="images/spacer.gif" width="1" height="26"
				border="0" alt="" /></td>
		</tr>
		<tr>
			<td width="598" height="377" align="center" valign="top"
				class="bordamenu"><h:form id="cadastroAluno">
					
				<h:panelGrid columns="2">
					
				<h:outputText value="Pessoa Fisica:"/>
				<h:inputText value="#{alunoController.aluno.pessoa}" size="10"/>
				<h:outputText value="Matricula:"/>
				<h:inputText value="#{alunoController.aluno.numeroMatricula}" size="10"/>
				<h:outputText value="Historico:"/>
				<h:inputTextarea value="#{alunoController.aluno.historicoAcademico}" cols="50"/>
				<h:outputText value="Curso:"/>
				<h:inputTextarea value="#{alunoController.aluno.cursoMatriculado.titulo}" cols="50"/>
				
				</h:panelGrid><h:commandButton action="#{alunoController.gravar}" value="Gravar!" />
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
</f:view>
</body>
</html>
