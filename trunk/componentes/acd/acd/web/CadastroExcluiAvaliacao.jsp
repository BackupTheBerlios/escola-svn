<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Cadastro de Avaliaçao</title>
</head>

<body>
	<f:view>
		<h:form>
			Selecione a Turma:  
			<h:selectOneMenu value="#{avaliacao.turmaId}" >
				<f:selectItems value="#{avaliacao.turmas}" />
			</h:selectOneMenu>
			<br /><br />

			<h:commandButton value="Cadastrar Avaliaçao" action="#{avaliacao.cadastrarAvaliacao}" />
			&nbsp;&nbsp;&nbsp;
			<h:commandButton value="Excluir Avaliacao" action="#{avaliacao.excluirAvaliacao}" />

			<br /><br />
			<a href="menu.jsp" >Menu Principal</a>
		</h:form>
	</f:view>
</body>
</html>
