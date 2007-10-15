<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page"
	prefix="sitemesh-page"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="sitemesh-decorator"%>
<html>
<head>
<title>Escola - Cadastro de Curso</title>
</head>
<body>
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
				color="#FFFFFF">Cadastrar Curso </font></strong></td>
			<td><img src="images/spacer.gif" width="1" height="26"
				border="0" alt="" /></td>
		</tr>
		<tr>
			<td width="598" height="377" align="center" valign="top"
				class="bordamenu"><h:form id="cadastroDeCurso">

				<h:panelGrid columns="2">

					<h:outputText value="C&oacute;digo&nbsp;do&nbsp;Curso:" />
					<h:inputText value="#{cursoController.curso.codigo}" size="10" />
					<h:outputText value="Nome&nbsp;do&nbsp;Curso:" />
					<h:inputText value="#{cursoController.curso.nome}"
						size="10" style=" width : 369px;" />
					<h:outputText value="Carga Hor&aacute;ria:" />
					<h:inputText value="#{cursoController.curso.cargaHoraria}"
						style=" width : 52px;" />
					<br/>
				</h:panelGrid>
				<h:commandButton action="#{cursoController.gravar}" value="Inserir" />
				<br/>
				<br/>
					<h:outputText value="#{cursoController.mensagem}" style=" width : 369px;" />
				<br/>
				<br/>
				<h:dataTable value="cursoController.consultar" var="item" style="font-Size: 10px; font-family: Arial;">
					<h:column>
						<f:facet name="header">
							<h:outputText value="C&oacute;digo" />
						</f:facet>
						<h:outputText value="#{item.codigo}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Nome do Curso" />
						</f:facet>
						<h:outputText value="#{item.nome}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Carga Hor&aacute;ria" />
						</f:facet>
						<h:outputText value="#{item.cargaHoraria}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Altera&ccedil;&atilde;o" />
						</f:facet>
						<h:commandLink action="#{cursoController.alterar}" value="Alterar"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Remo&ccedil;&aacute;o" />
						</f:facet>
						<h:commandLink action="#{cursoController.exluir}" value="Excluir"/>
					</h:column>
				</h:dataTable>
			</h:form> <br />


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
