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
			<h:selectOneMenu value="#{avaliacao.turmaId}">
				<f:selectItems value="#{avaliacao.turmas}" />
			</h:selectOneMenu>
			<br/><br/>
	
			<h:commandButton value="Selecionar Turma" action="#{avaliacao.buscarQuestoes}" />
			<br/><br/>
	
			<h:selectBooleanCheckbox value="#{avaliacao.objetiva}">Objetiva:&nbsp;&nbsp;&nbsp;</h:selectBooleanCheckbox>
			<br/><br/>
			<h:inputText value="#{avaliacao.pergunta}" size="30">Pergunta:&nbsp;&nbsp;&nbsp;</h:inputText>
	
			<br/><br/>
			<h:commandButton value="Alterar" action="#{avaliacao.alterarQuestao}" />
			&nbsp;&nbsp;&nbsp;
			<h:commandButton value="Excluir" action="#{avaliacao.excluirQuestao}" />
	
			<br/><br/>
			<h:commandLink value="Anterior" action="#{avaliacao.anteriorQuestao}" />
			&nbsp;&nbsp;&nbsp;
			<h:commandLink value="Proximo" action="#{avaliacao.proximaQuestao}" />

			<br /><br />
			<a href="menu.jsp" >Menu Principal</a>
		</h:form>
	</f:view>
</body>
</html>

