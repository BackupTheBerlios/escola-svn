<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://acegisecurity.org/authz" prefix="authz"%>
<%@ page import="org.acegisecurity.context.SecurityContextHolder"%>
<%@page import="br.ufg.inf.apsi.escola.ie.acegi.MyUserDetails"%>
<html>
<head>
<title>Menu Principal</title>
</head>
<f:view>
	<f:loadBundle basename="messages" var="msg" />
	<body>
	<h1><h:outputLabel id="label1" value="#{msg.mainMenu}" /></h1>
	<authz:authorize ifAnyGranted="SECRETARIO">
		Seja bem-vindo: <% MyUserDetails u = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); %>
		<%= u.getNomePessoa() %>
		<br><br>
		<h:form>
			<table>
				<tr>
					<td><h:commandLink action="#{principal.cadastrarUsuario}"
						id="hypCadastrarUsuario" value="Cadastrar Usuario" /></td>
				</tr>
				<tr>
					<td><h:commandLink action="#{principal.listarUsuarios}"
						id="hypListarUsuarios" value="Listar Usuarios" /></td>
				</tr>
				<tr>
					<td><h:commandLink action="#{principal.alterarSenha}"
						id="hypAlterarSenha" value="Alterar Senha" /></td>
				</tr>
			</table>
			<br><br>
			<h:commandButton actionListener="#{principal.sair}"
						action="sair" id="btnSair" value="#{msg.exit}"/>
		</h:form>
	</authz:authorize>
	</body>
</f:view>
</html>