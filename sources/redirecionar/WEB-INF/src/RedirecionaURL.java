
import java.io.IOException;
import java.io.PrintWriter;
import java.util.prefs.Preferences;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Fábio Nogueira de Lucena Quando o browser requisita http:// <algum
 *         host>/redirecionar/url há um redirecionamento para o URL fornecido
 *         anteriormente. Por exemplo, http:// <algum
 *         host>/redirecionar/set?ip=200.100.40.3 faz com que futuras chamadas
 *         como a primeira seram redirecionadas para http://200.100.40.3. Se o
 *         URL é http:// <algum host>/redirecionar/set, então o endereço do qual
 *         esta URL é requisitada é empregado para o redirecionamento.
 */
public class RedirecionaURL extends HttpServlet {

	private Preferences prefs = null;

	public void setRemoteAddr(String remote) {
		prefs.put("DESTINO", "http://" + remote);
		try {
			prefs.flush();
		} catch (Exception e) {
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String ip = req.getParameter("ip");
		if (ip != null) {
			setRemoteAddr(ip);
		} else if (req.getRequestURI().endsWith("set")) {
			setRemoteAddr(req.getRemoteAddr());
		} else if (req.getRequestURI().endsWith("help")) {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<p><a href=\"http://localhost:8080/redirecionar/url\"><b>/redirecionar/url</b></a> para redirecionar");
			out.println("<p><b>/redirecionar/set</b> para definir destino como origem da requisição");
			out.println("<p><b>/redirecionar/set?ip=end-ip</b> para definir destino conforme fornecido");
			out.println("<p><b>/redirecionar/help</b> para exibir estas mensagens");
			out.println("</body>");
			out.println("</html>");
			out.close();
			return;
		}
		
		String destino = prefs.get("DESTINO", "http://www.inf.ufg.br");
		res.sendRedirect(destino);
	}
    
	public void init() throws ServletException {
		super.init();
		prefs = Preferences.userNodeForPackage(RedirecionaURL.class);
	}
}