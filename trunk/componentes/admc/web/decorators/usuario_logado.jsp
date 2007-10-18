<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:subview id="usuario_logado">
	<table width="150" border="0" cellpadding="0" cellspacing="0"
		class="tbmenu">

		<tr>
			<td width="150" height="27"
				background="<%=request.getContextPath()%>/images/menu_r1_c1.gif"
				valign="top" align="center"><strong><font
				color="#FFFFFF">SECRET&Aacute;RIO</font></strong></td>
		</tr>
		<tr>
			<td class="bordamenu">
			<div align="center"><img name="img_login"
				src="<%=request.getContextPath()%>/images/img_usuario.gif"
				width="54" height="54" border="0" /></div>
			<p align="center">USUARIO&nbsp;NAO&nbsp;<br />
			ENCONTRAD</p>
			</td>
		</tr>
		<tr>
			<td width="150" height="11"
				background="<%=request.getContextPath()%>/images/menu_r3_c1.gif"><img
				name="menu_r3_c1"
				src="<%=request.getContextPath()%>/images/menu_r3_c1.gif"
				width="150" height="11" border="0" id="menu_r3_c1" alt="" /></td>
		</tr>
	</table>
</f:subview>
