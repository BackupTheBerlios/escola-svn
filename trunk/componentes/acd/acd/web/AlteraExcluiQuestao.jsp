<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Alteraçao ou Exclusao de Questoes</title>
	</head>

<body>
	<f:view>
		<h:form>
			Selecione a Turma:  
			<h:selectOneMenu value="#{avaliacaoBean.turmaId}">
				<f:selectItems value="#{avaliacaoBean.turmas}" />
			</h:selectOneMenu>
			<br/><br/>

			<h:commandButton value="Selecionar Turma" action="#{avaliacaoBean.buscarQuestoes}" />
			<br/><br/>

			<h:selectBooleanCheckbox value="#{avaliacaoBean.objetiva}">Objetiva:&nbsp;&nbsp;&nbsp;</h:selectBooleanCheckbox>
			<br/><br/>
			<h:inputText value="#{avaliacaoBean.pergunta}" size="30">Pergunta:&nbsp;&nbsp;&nbsp;</h:inputText>

			<br/><br/>
			<h:commandButton value="Alterar" action="#{avaliacaoBean.alterarQuestao}" />
			&nbsp;&nbsp;&nbsp;
			<h:commandButton value="Excluir" action="#{avaliacaoBean.excluirQuestao}" />

			<br/><br/>
			<h:commandLink value="Anterior" action="#{avaliacaoBean.anteriorQuestao}" />
			&nbsp;&nbsp;&nbsp;
			<h:commandLink value="Proximo" action="#{avaliacaoBean.proximaQuestao}" />

			<br /><br />
			<a href="menu.jsp" >Menu Principal</a>
		</h:form>
	</f:view>
</body>
</html>
