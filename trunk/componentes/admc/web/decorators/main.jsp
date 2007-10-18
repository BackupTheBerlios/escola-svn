<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Escola :: Sistema de Gestão Acadêmica</title>
<link href="<%=request.getContextPath()%>/css/folha_estilo.css" rel="stylesheet" type="text/css" />
</head>
<body >
<f:view>
<table border="0" cellpadding="0" cellspacing="0" width="760" bgcolor="#FFFFFF" align="center">
  <tr>
   <td>
     <jsp:include page="<%=request.getContextPath()%>/decorators/topo.jsp" />
  </td>
  </tr>
  <tr>
   <td ><img name="index_r2_c1" src="<%=request.getContextPath()%>/images/index_r2_c1.gif" width="760" height="26" border="0" id="index_r2_c1" usemap="#m_index_r2_c1" alt="" /></td>
  </tr>
  <tr>
  <td >
    <!--INICIO CONTEUDO -->
    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
	      <td width="156" height="421" valign="top">
		      <!-- INICIO PAINEL USUARIO -->
		       <jsp:include page="<%=request.getContextPath()%>/decorators/usuario_logado.jsp"/>
			   <!-- MENU LATERAL -->
			   <jsp:include page="<%=request.getContextPath()%>/decorators/menu_secretario.jsf"/>
			 </td>
		   <td valign="top">
		    
		   </td>
		
  		  </tr>
  		<tr>		
   			<td height="32" colspan="5" style="background-image:<%=request.getContextPath()%>/images/index_r4_c1.gif " align="center" valign="middle"><div>&copy; 2007 - Todos os direitos reservados - Turma APSI 2006</div>   </td>
  		</tr>
	</table>
</td>
</tr>
</table>

<map name="m_index_r2_c1" id="m_index_r2_c1">
<area shape="rect" coords="697,0,760,25" href="Login.jsp" alt="" />
<area shape="rect" coords="8,1,78,26" href="menuPrincipal.jsp" alt="" />
</map>
</f:view>
</body>
</html>