package br.ufg.inf.apsi.escola.componentes.servico;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.mail.HtmlEmail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class EmailService {

	Session session = null;
	/*
	 * Método construtor que carrega a seção com o arquivo de propriedades, 
	 * utilizado para configurar o servidor de e-mail. 
	 */
	public EmailService() throws IOException{
		session = Session.getInstance(carregarProriedade("mail.properties"), null);		
	}
	
	/*
	 * Método que enviar e-mail do tipo texto simples.
	 */
	public String enviarEmailTexto(String emailDestino, String nomeDestino, String emailRemetente,
			String nomeRemetente, String assunto, String mensagem)
			throws Exception {
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(emailRemetente, nomeRemetente));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				emailDestino,nomeDestino));
		message.setSubject(assunto);
		message.setContent(mensagem, "text/plain");
		
		try {
			Transport.send(message);
		} catch (Exception e) {
			e = new Exception("Erro ao enviar o e-mail!");
			throw e;
		}
		return "E-mail Enviado com Sucesso!";
	}

	/*
	 * Método que envia e-mail do tipo html, com ou sem imagem (deve ser remota)
	 */
	public String enviarEmailHTML(String emailDestino, String nomeDestino,
			String emailRemetente, String nomeRemetente, String assunto,
			String cabecalho, String corpo, String rodape,
			String enderecoImagem, String tituloImagem) throws Exception {

		HtmlEmail email = new HtmlEmail();
		email.setHostName(session.getProperties().getProperty("mail.smtp.host"));
		email.addTo(emailDestino, nomeDestino);
		email.setFrom(emailRemetente, nomeRemetente);
		email.setSubject(assunto);

		// Adiciona uma imagem ao corpo da mensagem e retorna seu id - imagem remota
		URL url = null;
		String id = null;
		if (enderecoImagem != null) {
			url = new URL(enderecoImagem);
			id = email.embed(url, tituloImagem);
		}
		
		// Configura a mensagem para o formato HTML
		if (id != null) {
			email.setHtmlMsg("<html><header><center>"+"<img src=\"cid:"
					+ id
					+ "\"></center><br>"
					+ "<font face='arial,helvetica,sans-serif',<h4><p align='left'><em>Sr(a)."
					+ nomeDestino + "</em></p></h4><br>" + "<h2><center>"
					+ cabecalho + "</center></h2></header>"
					+ "<body><h3><br>" + corpo + "</h3></body>"
					+ "<h3><br><br>" + rodape + "<br><br></h3></font>"
					+ "---------------------------------------------"
					+ "<br><h4><em>" + nomeRemetente + "<br>"
					+ emailRemetente + "</em></h4>" + "</html>");
		} else {
			email.setHtmlMsg("<html><header><br>"
					+ "<font face='arial,helvetica,sans-serif',<h4><p align='left'><em>Sr(a)."
					+ nomeDestino + "</em></p></h4><br>" + "<h2><center>"
					+ cabecalho + "</center></h2></header>"
					+ "<body><h3><br>" + corpo + "</h3></body>"
					+ "<h3><br><br>" + rodape + "<br><br></h3></font>"
					+ "---------------------------------------------"
					+ "<br><h4><em>" + nomeRemetente + "<br>"
					+ emailRemetente + "</em></h4>" + "</html>");
		}
		
		try {
			email.send();
		} catch (Exception e) {
			e = new Exception("Erro ao enviar o e-mail!");
			throw e;
		}
		return "E-mail Enviado com Sucesso!";
	}

	/*
	 * Método que envia e-mail com através de um template, previamente definido.
	 */
	public String enviarEmailTemplate(String emailDestino, String nomeDestino,
			String emailRemetente, String nomeRemetente, String assunto, String localTemplate, String localImagem, String cabecalho, String corpo, String rodape)
			throws Exception{

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(emailRemetente, nomeRemetente));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				emailDestino,nomeDestino));
		message.setSubject(assunto);
		message.setContent(lerTemplate(localTemplate, localImagem, cabecalho, corpo, rodape));

		try {
			Transport.send(message);
		} catch (Exception e) {
			e = new Exception("Erro ao enviar o e-mail!");
			throw e;
		}
		return "E-mail Enviado com Sucesso!";
	}

	/*
	 * Método privado, que carrega o arquivo de propriedades, com informações
	 * do servidor de e-mail para a seção.
	 */
	private Properties carregarProriedade(String arquivo) throws IOException {
		Properties prop = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(arquivo);
		try {
			prop.load(is);
			is.close();
		} catch (IOException e) {
			e = new IOException("Erro ao carregar o arquivo de propriedade!");
			throw e;
		}
		return prop;
	}

	/*
	 * Método privado, que monta as partes do e-mail no tipo de envio com template.
	 */
	private MimeMultipart lerTemplate(String localTemplate, String localImagem, String cabecalho, String corpo, String rodape) {
		String conteudo = lerArquivoTemplate(localTemplate);
		MimeMultipart mp = new MimeMultipart();
		try {
			mp.setSubType("related");
			MimeBodyPart mbp1 = new MimeBodyPart();
			conteudo = substituirInformacoes(conteudo,cabecalho, corpo, rodape);
			mbp1.setContent(conteudo, "text/html");
			mp.addBodyPart(mbp1);
			MimeBodyPart mbp2 = new MimeBodyPart();
			if (localImagem != null && !localImagem.equals("")) {
				FileDataSource fds = new FileDataSource(localImagem);
				mbp2.setFileName(fds.getName());
				mbp2.setDataHandler(new DataHandler(fds));
				mbp2.setHeader("Content-ID", "image1");
				mp.addBodyPart(mbp2);
			}
			return mp;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Método privado que substitui as palavras-chaves do template pelos valores
	 * informados pelo usuário do serviço. 
	 */
	private String substituirInformacoes(String conteudo, String cabecalho, String corpo, String rodape){
		conteudo = conteudo.replaceAll("#cabecalho", cabecalho);
		conteudo = conteudo.replaceAll("#corpo", corpo);
		conteudo = conteudo.replaceAll("#rodape", rodape);

		return conteudo;		
	}

	/*
	 * Método privado, que lê o template. 
	 */
	private String lerArquivoTemplate(String localTemplate) {
		try {
			FileReader reader = new FileReader(localTemplate);
			BufferedReader leitor = new BufferedReader(reader,1*1024*1024);			
			String linha = "";
			while ((leitor.ready())) {				
				linha = linha + "\n"+leitor.readLine();
			}
			leitor.close();
			reader.close();
			return linha;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io){
			io.printStackTrace();
		}
		return "";
	}
}
