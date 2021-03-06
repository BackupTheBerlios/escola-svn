pas<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Escola :: Sistema de Gest�o Acad�mica</title>
<link href="<%=request.getContextPath()%>/css/folha_estilo.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<f:view>
	<h:form>
	<table border="0" cellpadding="0" cellspacing="0" width="760" bgcolor="#FFFFFF" align="center">
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
                        </f:facet>
                        <f:facet name="menu_secretario">
								<!-- MENU LATERAL -->
							
								<c:import url="/decorators/menu_secretario.jsp" />
							
							
						</f:facet></td>
						<td valign="top">
							<!-- CONTEUDO -->
							<table width="598" border="0" cellpadding="0" cellspacing="0"
								class="tbconteudo">

								<tr>
									<td><img
										src="<%=request.getContextPath()%>/images/spacer.gif"
										width="598" height="1" border="0" alt="" /></td>
									<td><img
										src="<%=request.getContextPath()%>/images/spacer.gif"
										width="1" height="1" border="0" alt="" /></td>
								</tr>

								<tr>
									<td width="598" height="26"
										background="<%=request.getContextPath()%>/images/conteudo_r1_c1.gif"
										align="center" valign="top"><strong><font
										color="#FFFFFF">Pagina Inicial </font></strong></td>
									<td><img src="images/spacer.gif" width="1" height="26"
										border="0" alt="" /></td>
								</tr>
								<tr>
									<td width="598" height="377" align="center" valign="top"
										class="bordamenu"><br />
									Bem Vindo ao Sistema Escola. <br />
									Selecione uma das op��es do Menu lateral.
									<br/>
									<br/>
									
									</td>
									<td><img
										src="<%=request.getContextPath()%>/images/spacer.gif"
										width="1" height="377" border="0" alt="" /></td>
								</tr>
								<tr>
									<td width="598" height="10"
										background="<%=request.getContextPath()%>/images/conteudo_r3_c1.gif"></td>
									<td><img
										src="<%=request.getContextPath()%>/images/spacer.gif"
										width="1" height="10" border="0" alt="" /></td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td height="32" colspan="5" style="background-image: &lt;%="
							align="center" valign="middle">
						<div>&copy; 2007 - Todos os direitos reservados - Turma APSI
						2006</div>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</h:form>
	<map name="m_index_r2_c1" id="m_index_r2_c1">
		<area shape="rect" coords="697,0,760,25" href="Login.jsp" alt="" />
		<area shape="rect" coords="8,1,78,26" href="menuPrincipal.jsp" alt="" />
	</map>

</f:view>
</body>
</html>