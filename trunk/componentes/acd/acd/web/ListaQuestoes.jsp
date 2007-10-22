<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Listar Questoes</title>
</head>

<body>
	<f:view>
		<h:form>
			Selecione a Turma:  
			<h:selectOneMenu value="#{avaliacaoBean.turmaId}" >
				<f:selectItems value="#{avaliacaoBean.turmas}" />
			</h:selectOneMenu>
			<br /><br />

			<h:commandButton value="Selecionar Turma" action="#{avaliacaoBean.listarQuestoes}" />
			<br /><br />

			<h:dataTable value="#{avaliacaoBean.questoes}" var="q" border="1">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Objetiva" />
					</f:facet>
					<h:outputText value="#{q.objetiva}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Pergunta" />
					</f:facet>
					<h:outputText value="#{q.pergunta}" />
				</h:column>
			</h:dataTable>

			<br /><br />
			<a href="menu.jsp" >Menu Principal</a>
		</h:form>
	</f:view>
</body>
</html>
