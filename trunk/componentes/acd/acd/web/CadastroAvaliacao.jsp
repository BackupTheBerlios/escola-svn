<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Cadastro de Avaliacao</title>
</head>

<body>
	<f:view>
		<h:form>
			Selecione a Turma:  
			<h:selectOneMenu value="#{avaliacaoBean.turmaId}" >
				<f:selectItems value="#{avaliacaoBean.turmas}" />
			</h:selectOneMenu>
			&nbsp;&nbsp;&nbsp;

			<h:commandButton value="Selecionar Turma" action="#{avaliacaoBean.selecionarTurma}" />
			<br /><br />
		</h:form>
		
		<h:form>
			<h:selectBooleanCheckbox value="#{avaliacaoBean.objetiva}" >Objetiva:&nbsp;&nbsp;&nbsp;</h:selectBooleanCheckbox>
			<br /><br />

			<h:inputText id="Pergunta" value="#{avaliacaoBean.pergunta}" required="true" size="45">Pergunta:&nbsp;&nbsp;&nbsp;</h:inputText>
			<br />
			<h:message for="Pergunta" />

			<br /><br />
			<h:commandButton value="Salvar" action="#{avaliacaoBean.salvarQuestao}" />
			<br /><br />
		</h:form>
		
		<h:form>
			<h:dataTable value="#{avaliacaoBean.questoes}" var="q" border="1">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Objetiva" />
					</f:facet>
					<h:selectBooleanCheckbox value="#{q.objetiva}" readonly="true" disabled="true" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Pergunta" />
					</f:facet>
					<h:outputText value="#{q.pergunta}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Açao" />
					</f:facet>
					<h:commandLink value="Alterar" actionListener="#{avaliacaoBean.alterarQuestao}">
						<f:attribute name="idA" value="#{q.id}" />
					</h:commandLink>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Açao" />
					</f:facet>
					<h:commandLink value="Excluir" actionListener="#{avaliacaoBean.excluirQuestao}">
						<f:attribute name="idE" value="#{q.id}" />
					</h:commandLink>
				</h:column>
			</h:dataTable>
		</h:form>

		<br /><br />
		<a href="menu.jsp" >Menu Principal</a>
	</f:view>
</body>
</html>
