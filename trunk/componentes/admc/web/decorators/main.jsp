<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title default="Mysterious page..." /></title>
<link href="css/folha_estilo.css" rel="stylesheet" type="text/css" />
<decorator:head />
</head>
<body >

<table border="0" cellpadding="0" cellspacing="0" width="760" bgcolor="#FFFFFF" align="center">
  <tr>
   <td>
     <jsp:include page="/decorators/topo.html" />
  </td>
  </tr>
  <tr>
   <td ><img name="index_r2_c1" src="images/index_r2_c1.gif" width="760" height="26" border="0" id="index_r2_c1" usemap="#m_index_r2_c1" alt="" /></td>
  </tr>
  <tr>
  <td >
    <!--INICIO CONTEUDO -->
    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
	      <td width="156" height="421" valign="top">
		      <!-- INICIO PAINEL USUARIO -->
		       <page:applyDecorator  name="login" page="/decorators/usuario_logado.html"/>
			   <!-- MENU LATERAL -->
			   <page:applyDecorator  name="menu" page="/decorators/menu_secretario.jsp"/>
			 </td>
		   <td valign="top">
		    <decorator:body/>
		   </td>
		
  		  </tr>
  		<tr>		
   			<td height="32" colspan="5" style="background-image:images/index_r4_c1.gif " align="center" valign="middle"><div>&copy; 2007 - Todos os direitos reservados - Turma APSI 2006</div>   </td>
  		</tr>
	</table>
</td>
</tr>
</table>

<map name="m_index_r2_c1" id="m_index_r2_c1">
<area shape="rect" coords="697,0,760,25" href="login.xhtml" alt="" />
<area shape="rect" coords="8,1,78,26" href="menuPrincipal.xhtml" alt="" />
</map>
</body>
</html>