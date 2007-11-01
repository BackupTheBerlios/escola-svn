package br.ufg.inf.apsi.escola.ie.email;

import javax.mail.Session;

/**
 * Classe utilizada como apoio nos testes com o Tomcat
 * 
 * @author leandro
 * 
 */
public class EmailServiceImpl implements EmailService {

	Session session = null;

	@Override
	public void enviarEmailTexto(String emailDestino, String emailRemetente,
			String nomeRemetente, String assunto, String mensagem) {

		System.out.println("E-mail enviado com sucesso!");
	}

	@Override
	public void enviarEmailHTML(String emailDestino, String nomeDestino,
			String emailRemetente, String nomeRemetente, String assunto,
			String cabecalho, String corpo, String rodape,
			String enderecoImagem, String tituloImagem) {

	}
}