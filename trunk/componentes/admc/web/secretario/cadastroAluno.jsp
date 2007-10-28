<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Escola :: Sistema de Gestão Acadêmica</title>
<link href="<%=request.getContextPath()%>/css/folha_estilo.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<f:view>
	<h:form id="cadastroDisciplina">
		<table border="0" cellpadding="0" cellspacing="0" width="760"
			bgcolor="#FFFFFF" align="center">
			<tr>
				<td><f:facet name="topo">
					<c:import url="/decorators/topo.jsp" />
				</f:facet></td>
			</tr>
			<tr>
				<td><img name="index_r2_c1"
					src="<%=request.getContextPath()%>/images/index_r2_c1.gif"
					width="760" height="26" border="0" id="index_r2_c1"
					usemap="#m_index_r2_c1" alt="" /></td>
			</tr>
			<tr>
				<td><!--INICIO CONTEUDO -->
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="156" height="421" valign="top"><!-- INICIO PAINEL USUARIO -->
						<f:facet name="usuario_logado">

							<c:import url="/decorators/usuario_logado.jsp" />
						</f:facet> <f:facet name="menu_secretario">
							<!-- MENU LATERAL -->

							<c:import url="/decorators/menu_secretario.jsp" />


						</f:facet></td>
						<td valign="top"><!-- CONTEUDO -->
						<table width="598" border="0" cellpadding="0" cellspacing="0"
							class="tbconteudo">

							<tr>
								<td><img
									src="<%=request.getContextPath()%>/images/spacer.gif"
									width="598" height="1" border="0" alt="" /></td>
								<td><img
									src="<%=request.getContextPath()%>/images/spacer.gif" width="1"
									height="1" border="0" alt="" /></td>
							</tr>



							<tr>
								<td width="598" height="26"
									background="<%=request.getContextPath()%>/images/conteudo_r1_c1.gif"
									align="center" valign="top"><strong><font
									color="#FFFFFF">Cadastro Aluno </font></strong></td>
								<td><img src="images/spacer.gif" width="1" height="26"
									border="0" alt="" /></td>
							</tr>
							<tr>
								<td width="598" height="377" align="center" valign="top"
									class="bordamenu"><br />
								 <h:messages />
								 <h:panelGrid columns="2" width="590">
									<h:outputText value="Matricula:" />
									<h:inputText  value="#{alunoController.matricula}" size="15" disabled="true"/>
									<h:outputText  value="Nome:" />
									<h:inputText id="nome" value="#{alunoController.nome}" size="50" required="true">
									   <f:validateLength minimum="2" maximum="200"/>
									   <h:message for="nome" showDetail="true"/>
									</h:inputText>
									<h:outputText value="Sexo:" />
									<h:selectOneMenu value="#{alunoController.sexo}" >
										<f:selectItem itemValue="M" itemLabel="Masculino" />
										<f:selectItem itemValue="F" itemLabel="Feminino" />
									</h:selectOneMenu>
									<h:outputText value="Data Nascimento:" />
									<h:inputText id="datanascimento" value="#{alunoController.dataNascimento}"
										size="12" >
										 <f:validator validatorId="dataValidate"/>
										 <h:message for="datanascimento"/>
									</h:inputText>	
									<h:outputText value="Telefone Fixo:" />
									<h:panelGrid columns="2">
										<h:inputText value="#{alunoController.dddf1}" size="3">
										    
										</h:inputText>
										<h:inputText value="#{alunoController.telefone1}" size="15" >
										     
										</h:inputText>
									</h:panelGrid>
								    <h:outputText value="Telefone Celular:" />
									<h:panelGrid columns="2">
										<h:inputText value="#{alunoController.dddf2}" size="3" >
										  
										 </h:inputText> 
										<h:inputText value="#{alunoController.telefone2}" size="15" >
										
										</h:inputText>
									</h:panelGrid>
									<h:outputText value="CPF:" />
									<h:inputText id="cpf" value="#{alunoController.cpf}" size="15" required="true">
									    <f:validator validatorId="cpfValidate"/>
									    <h:message for="cpf" showDetail="true"/>
									      
									</h:inputText>
									<h:outputText value="RG:" />
									<h:inputText value="#{alunoController.rg}" size="15" />
									<h:outputText value="Data Emissão:" />
									<h:inputText value="#{alunoController.dataEmissao}" size="12" >
									    <f:validator validatorId="dataValidate"/>
									</h:inputText>
									<h:outputText value="Órgão Expedidor:" />
									<h:inputText value="#{alunoController.orgaoExpedidor}" size="6" />
									<h:outputText value="E-mail:" />
									<h:inputText value="#{alunoController.email}" size="40" />
									<h:outputText value="Endereco Residencial:" />
									<h:inputText value="#{alunoController.endereco}" size="60" />
									<h:outputText value="Numero:" />
									<h:inputText value="#{alunoController.numero}" size="4" />
									<h:outputText value="Complemento:" />
									<h:inputText value="#{alunoController.complemento}" size="50" />
									<h:outputText value="CEP:" />
									<h:inputText value="#{alunoController.cep}" size="12" >
									    
									</h:inputText>
									<h:outputText value="Bairro:" />
									<h:inputText value="#{alunoController.bairro}" size="50" />
									<h:outputText value="Cidade:" />
									<h:inputText value="#{alunoController.cidade}" size="50" />
									<h:outputText value="Estado:" />
									<h:inputText value="#{alunoController.estado}" size="3" />
									<h:outputText value="Pais:" />
									<h:inputText value="#{alunoController.pais}" size="50" />
									<h:commandButton action="#{alunoController.gravar}"
										value="Gravar" />
									
								</h:panelGrid></td>
								<td><img
									src="<%=request.getContextPath()%>/images/spacer.gif" width="1"
									height="377" border="0" alt="" /></td>
							</tr>
							<tr>
								<td width="598" height="10"
									background="<%=request.getContextPath()%>/images/conteudo_r3_c1.gif"></td>
								<td><img
									src="<%=request.getContextPath()%>/images/spacer.gif" width="1"
									height="10" border="0" alt="" /></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</h:form>

</f:view>
<map name="m_index_r2_c1" id="m_index_r2_c1">
	<area shape="rect" coords="697,0,760,25" href="Login.jsp" alt="" />
	<area shape="rect" coords="8,1,78,26" href="menuPrincipal.jsp" alt="" />
</body>
</html>