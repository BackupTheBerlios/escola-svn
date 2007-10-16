<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Insert title here</title>
	</head>
	<body>
		<h:form>
			<h:commandButton action="#{configuracaoNota.gravar}" id="btnGravar" style="height: 20px; left: 19px; top: 235px; position: absolute; width: 70px" value="Salvar"/>
		</h:form>
	</body>
</html>
