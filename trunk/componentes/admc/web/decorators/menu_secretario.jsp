<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:subview id="menu_secretario">
<f:verbatim>

<table width="150" border="0" cellpadding="0" cellspacing="0"
	class="tbmenu">
	<tr>
		<td width="150" height="27"
			background="<%=request.getContextPath()%>/images/menu_r1_c1.gif"
			valign="top" align="center"><strong><font
			color="#FFFFFF">MENU</font></strong></td>
	</tr>


 <tr>
		<td class="bordamenu"><a href="modeloAvaliacao.xhtml"></f:verbatim> <h:commandLink value="Modelo Avaliacao" action="#{disciplinaController.novo}"/> <f:verbatim></td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Cadastrar Usuario" action="#{usuarioController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Cadastrar Aluno" action="#{alunoController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Cadastrar Docente" action="#{docenteController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Cadastrar Secretario" action="#{secretarioController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Cadastrar Disciplinas" action="#{disciplinaController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Cadastrar Curso" action="#{cursoController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Criar Turma" action="#{turmaController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Efetivar Matricula" action="#{preMatriculaController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td class="bordamenu"></f:verbatim> <h:commandLink value="Matricula em Curso" action="#{cursoController.novo}"/> <f:verbatim> </td>
	</tr>
	<tr>
		<td width="150" height="11"
			background="<%=request.getContextPath()%>/images/menu_r3_c1.gif"><img
			name="menu_r3_c1"
			src="<%=request.getContextPath()%>/images/menu_r3_c1.gif" width="150"
			height="11" border="0" id="menu_r3_c1" alt="" /></td>
	</tr>
</table>

</f:verbatim>

</f:subview>