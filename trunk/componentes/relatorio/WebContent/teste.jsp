<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title></title>
</head>
<body>
<f:view>
<h:form id="teste"> 
<h:commandButton value="consulta" action="#{relatorioNFAlunosUmaTurmaController.consultaTurmasAluno}"/>
<br >
<br >
<br >
<h:inputText value="#{relatorioNFAlunosUmaTurmaController.s}"/>
</h:form>
</f:view>
</body>
</html>