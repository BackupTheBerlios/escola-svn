<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ page import="org.acegisecurity.context.SecurityContextHolder"%>
<%@ page import="org.acegisecurity.Authentication"%>
<%@ page import="org.acegisecurity.ui.AccessDeniedHandlerImpl"%>

<SCRIPT LANGUAGE="JavaScript1.3">
            function voltar() {
                window.location.href = "/ControleAcesso/faces/Login.jsp";
            }
        </SCRIPT>
<html>

<f:view>


<body>
<h1><h:outputText value="Acesso Negado"/></h1>


<p><%=request.getAttribute(AccessDeniedHandlerImpl.ACEGI_SECURITY_ACCESS_DENIED_EXCEPTION_KEY)%>
<p>
<%
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null) {
%> <h:outputText  value="Autenticado como: "/> <%= auth.getAuthorities()[0]%><BR>
<BR>
<%
}
%>
<button onClick="javascript:voltar();" id="btnVoltar">Voltar</button>
</body>
</f:view>
</html>