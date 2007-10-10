<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
<!--
body { margin-left:0px; margin-top:0px; margin-right:00px; margin-bottom:0px; }
.style2 { font-family:Verdana, Arial, Helvetica, sans-serif }
.style3 { font-size:10px }
-->
</style>
<link href="css/folha_estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<f:view>
	<h:graphicImage value="./images/fundoTela.gif"
		style="left: 0px; top: 0px; position: absolute;"/>

		<h:outputText value="CADASTRO DO SECRETÁRIO"
			style="left: 170px; top: 108px; position: absolute; color: white; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; font-weight:bold; z-index:auto"></h:outputText>

		<h:outputText value="SECRETÁRIO"
			style="left: 30px; top: 108px; position: absolute; color: white; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; font-weight:bold; z-index:auto"></h:outputText>

		<h:outputText value="NOME DO USUÁRIO"
			style="left: 20px; top: 218px; position: absolute; color: #000000; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>

		<h:outputText value="MENU"
			style="left: 30px; top: 248px; position: absolute; color: white; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; font-weight:bold; z-index:auto"></h:outputText>

		<h:outputText value="CPF N.:"
			style="left: 170px; top: 140px; position: absolute; color: black; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>
		<h:inputText maxlength="14"
			style="width: 100px; height:20px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; left: 220px; top: 135px; position:absolute;"></h:inputText>

		<h:outputText value="Nome:"
			style="left: 170px; top: 170px; position: absolute; color: black; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>
		<h:inputText maxlength="100"
			style="width: 300px; height:20px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; left: 220px; top: 165px; position:absolute;"></h:inputText>

		<h:outputText value="Sexo:"
			style="left: 170px; top: 200px; position: absolute; color: black; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>
		<h:selectOneMenu maxlength="100"
			style="width: 150px; height:20px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; left: 220px; top: 195px; position:absolute;">
			<f:selectItem itemValue="MASCULINO" itemLabel="MASCULINO"></f:selectItem>
			<f:selectItem itemValue="FEMININO" itemLabel="FEMININO"></f:selectItem>
		</h:selectOneMenu>

		<h:outputText value="Data Nascimento:"
			style="left: 170px; top: 230px; position: absolute; color: black; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>
		<h:inputText maxlength="10"
			style="width: 90px; height:20px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; left: 278px; top: 225px; position:absolute;"></h:inputText>

		<h:outputText value="RG N.:"
			style="left: 170px; top: 260px; position: absolute; color: black; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>
		<h:inputText maxlength="30"
			style="width: 90px; height:20px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; left: 220px; top: 255px; position:absolute;"></h:inputText>
		<h:outputText value="Data Emissão:"
			style="left: 330px; top: 260px; position: absolute; color: black; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>
		<h:inputText maxlength="10"
			style="width: 90px; height:20px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; left: 415px; top: 255px; position:absolute;"></h:inputText>
		<h:inputText maxlength="30"
			style="width: 90px; height:20px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; left: 625px; top: 255px; position:absolute;"></h:inputText>
		<h:outputText value="Órgão Expedidor:"
			style="left: 520px; top: 260px; position: absolute; color: black; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; z-index:auto"></h:outputText>
</f:view>
</body>
</html>
