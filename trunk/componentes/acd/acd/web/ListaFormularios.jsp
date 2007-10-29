<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Listar Formularios de Avaliaçao</title>
	</head>

<body>
	<f:view>
		<h:form>
			Selecione a Turma:  
			<h:selectOneMenu value="#{formAvaliacaoListaBean.turmaId}" >
				<f:selectItems value="#{formAvaliacaoListaBean.turmas}" />
			</h:selectOneMenu>
			&nbsp;&nbsp;&nbsp;

			<h:commandButton value="Selecionar Turma" action="#{formAvaliacaoListaBean.selecionarTurma}" />
			<br /><br />
		</h:form>
		
		<h:form>
			<h:dataTable value="#{formAvaliacaoListaBean.respostas}" var="r" border="1">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Objetiva" />
					</f:facet>
					<h:selectBooleanCheckbox value="#{r.questao.objetiva}" readonly="true" disabled="true" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Pergunta" />
					</f:facet>
					<h:outputText value="#{r.questao.pergunta}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Resposta" />
					</f:facet>
					<h:outputText value="#{r.resposta}" />
				</h:column>
			</h:dataTable>

			<br /><br />
			<h:commandLink value="Anterior" action="#{formAvaliacaoListaBean.anteriorFormAvaliacao}" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<h:commandLink value="Proximo" action="#{formAvaliacaoListaBean.proximoFormAvaliacao}" />
		</h:form>

		<br /><br />
		<a href="menu.jsp" >Menu Principal</a>
	</f:view>
</body>
</html>
