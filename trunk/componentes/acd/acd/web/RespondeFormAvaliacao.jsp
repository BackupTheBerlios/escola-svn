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
			<br /><br />

			<h:commandButton value="Selecionar Turma" action="#{formAvaliacaoBean.criarFormAvaliacao}" />
			<br /><br />

			<h:dataTable value="#{formAvaliacaoBean.respostas}" var="r" border="1">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Objetiva" />
					</f:facet>
					<h:outputText value="#{r.questao.objetiva}" />
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
					<h:inputText value="#{r.resposta}" size="30" />
				</h:column>
			</h:dataTable>

			<br /><br />
			<h:commandButton value="Salvar" action="#{formAvaliacaoBean.salvarFormAvaliacao}" />

			<br /><br />
			<a href="menu.jsp" >Menu Principal</a>
		</h:form>
	</f:view>
</body>
</html>
