package test.br.ufg.inf.apsi.escola.componentes.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.br.ufg.inf.apsi.escola.componentes.servico.EmailService;

/**
 * Classe para testar a classe Email
 * 
 * @author Gerson Rodrigues Pereira
 * 
 */

public class EmailServiceTeste {

	/**
	 * Testa metodos...
	 * {@link br.ufg.inf.apsi.escola.componentes.servico.enviarEmailTexto()}
	 */

	@Test
	public void testValidar() {
		try {
			EmailService email = new EmailService();
			String emailDest = "gerson@especializacao.info";
			String nomeDest = "Gerson";
			String emailEnv = "fabio@inf.ufg.br";
			String nomeEnv = "Fabio";
			String assunto = "Teste de email";
			String conteudo = "Especializacao - Fazendo testes de unidade...";

			assertEquals(emailDest, "gerson@especializacao.info");
			assertEquals(nomeDest, "Gerson");
			assertEquals(emailEnv, "fabio@inf.ufg.br");
			assertEquals(nomeEnv, "Fabio");
			assertEquals(assunto, "Teste de email");
			assertEquals(conteudo,
					"Especializacao - Fazendo testes de unidade...");

			assertEquals(email.enviarEmailTexto("gerson@especializacao.info",
					"Gerson", "fabio@inf.ufg.br", "Fabio", "Teste de email",
					"Especializacao - Fazendo testes de unidade..."), "E-mail Enviado com Sucesso!");
			
			assertEquals(email.enviarEmailHTML("gerson@especializacao.info",
					"Gerson", "fabio@inf.ufg.br", "Fabio", "Teste de email HTML",
					"Especializacao - Fazendo testes de unidade eMail HTML...","A procedure estava pegando um mês de referência anterior ao mês do bloqueio.","Atenciosamente,","http://www.ufg.br/uploads/topo/topo.gif","Logo Inf."), "E-mail Enviado com Sucesso!");

			assertEquals(email.enviarEmailTemplate("gerson@especializacao.info",
					"Gerson", "fabio@inf.ufg.br", "Fabio", "Teste de email com Template",
					"C:\\template.htm","C:\\Documentos/Fotos/Foto.jpg","Empresa Testes - CAB",
					"Este é o corpo do email...", "Atenciosamente, Gerson "), "E-mail Enviado com Sucesso!");

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
