<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Cadastro de Questao</title>
</head>

<body>
	<f:view>
		<h:form>
			Selecione a Turma:  
			<h:selectOneMenu value="#{avaliacao.turmaId}" >
				<f:selectItems value="#{avaliacao.turmas}" />
			</h:selectOneMenu>
			<br /><br />

			<h:selectBooleanCheckbox value="#{avaliacao.objetiva}" >Objetiva:&nbsp;&nbsp;&nbsp;</h:selectBooleanCheckbox>
			<br /><br />
			<h:inputText id="Pergunta" value="#{avaliacao.pergunta}" required="true" size="30">Pergunta:&nbsp;&nbsp;&nbsp;</h:inputText>

			<br /><br />
			<h:message for="Pergunta" />

			<br /><br />
			<h:commandButton value="Cadastrar" action="#{avaliacao.cadastrarQuestao}" />

			<br /><br />
			<a href="menu.jsp" >Menu Principal</a>
		</h:form>
	</f:view>
</body>
</html>
