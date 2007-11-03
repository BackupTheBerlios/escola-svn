<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title></title>
</head>
<body>
<f:view>
<h:form id="teste"> 
<h:inputText value="#{relatorioController.idTurma}"/>
<br >
<h:commandButton value="NF-PDF" action="#{relatorioController.geraRelatorioPDF}"/>
<h:commandButton value="NF-HTML" action="#{relatorioController.geraRelatorioHTML}"/>
<br >
<h:commandButton value="ACD-PDF" action="#{relatorioController.geraRelatorioAvaliacaoDocenteTurmaPDF}"/>
<h:commandButton value="ACD-HTML" action="#{relatorioController.geraRelatorioAvaliacaoDocenteTurmaHTML}"/>
<br >
<br >
</h:form>
</f:view>

</body>
</html>