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
			<h:selectOneMenu value="#{avaliacaoBean.turmaId}" >
				<f:selectItems value="#{avaliacaoBean.turmas}" />
			</h:selectOneMenu>
			<br /><br />

			<h:commandButton value="Cadastrar Avaliaçao" action="#{avaliacaoBean.cadastrarAvaliacao}" />
			&nbsp;&nbsp;&nbsp;
			<h:commandButton value="Excluir Avaliacao" action="#{avaliacaoBean.excluirAvaliacao}" />

			<br /><br />
			<a href="menu.jsp" >Menu Principal</a>
		</h:form>
	</f:view>
</body>
</html>
