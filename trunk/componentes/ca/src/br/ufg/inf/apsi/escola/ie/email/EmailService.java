package br.ufg.inf.apsi.escola.ie.email;

/**
 * Interface utilizada como apoio nos teste com o Tomcat
 * 
 * @author leandro
 * 
 */
public interface EmailService {

	public void enviarEmailTexto(String emailDestino, String emailRemetente,
			String nomeRemetente, String assunto, String mensagem);

	public void enviarEmailHTML(String emailDestino, String nomeDestino,
			String emailRemetente, String nomeRemetente, String assunto,
			String cabecalho, String corpo, String rodape,
			String enderecoImagem, String tituloImagem);

}
