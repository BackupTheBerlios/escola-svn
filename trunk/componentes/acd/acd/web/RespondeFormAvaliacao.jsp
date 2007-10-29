<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Preencher Formulario de Avaliaçao</title>
</head>

<body>
	<f:view>
		<h:form>
			Selecione a Turma:  
			<h:selectOneMenu value="#{formAvaliacaoBean.turmaId}" >
				<f:selectItems value="#{formAvaliacaoBean.turmas}" />
			</h:selectOneMenu>
			&nbsp;&nbsp;&nbsp;

			<h:commandButton value="Selecionar Turma" action="#{formAvaliacaoBean.selecionarTurma}" />
			<br /><br />
		</h:form>
		
		<h:form>
			<h:outputText value="OBS: Questoes Objetivas deve-se responder informando uma nota de valor inteiro na faixa: (0 - 10)" />
			<br />
			<h:dataTable value="#{formAvaliacaoBean.respostas}" var="r" border="1">
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
					<h:outputText value="#{r.questao.pergunta}" /> <br />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Resposta" />
					</f:facet>
					<h:inputText value="#{r.resposta}" size="50" />
				</h:column>
			</h:dataTable>

			<br /><br />
			<h:commandButton value="Salvar" action="#{formAvaliacaoBean.salvarFormAvaliacao}" />
		</h:form>

		<br /><br />
		<a href="menu.jsp" >Menu Principal</a>
	</f:view>
</body>
</html>
