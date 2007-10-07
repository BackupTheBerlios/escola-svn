package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.teste;

import java.util.Date;

import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaServiceImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.BairroRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.CidadeRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.CriaPersistenciaGeral;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.DocumentoRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.EmailRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.EnderecoRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.EstadoRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.LogradouroRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.PaisRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.PessoaRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.TelefoneRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;



import static br.ufg.inf.apsi.escola.componentes.pessoa.util.Util.formataData;

/**
 * Classe definida para testar o cadastramento de pessoas.
 */
public class CadastraPessoa {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CriaPersistenciaGeral cpg = new CriaPersistenciaGeral();
		PessoaService ps = new PessoaServiceImpl();
		ps.setBairroRepository(new BairroRepositoryImpl());
		ps.setCidadeRepository(new CidadeRepositoryImpl());
		ps.setDocumentoRepository(new DocumentoRepositoryImpl());
		ps.setEmailRepository(new EmailRepositoryImpl());
		ps.setEnderecoRepository(new EnderecoRepositoryImpl());
		ps.setEstadoRepository(new EstadoRepositoryImpl());
		ps.setLogradouroRepository(new LogradouroRepositoryImpl());
		ps.setPaisRepository(new PaisRepositoryImpl());
		ps.setPessoaRepository(new PessoaRepositoryImpl());
		ps.setTelefoneRepository(new TelefoneRepositoryImpl());
		
		//Dados da pessoa 1 para teste
		String nomePessoa = "Pessoa0";
		String tipoEndereco = "RESIDENCIAL";
		String tipoLogradouro = "RUA";
		String nomeLogradouro = "SR 17";
		String numeroEndereco = "S/N";
		String complemento = "qd. 34 lt. 13A";
		Integer cep = 74393580;
		String nomeBairro = "Parque Santa Rita";
		String nomeCidade = "Goiânia";
		String nomeEstado = "Goiás";
		String nomePais = "Brasil";
		String email = "pessoa0@provedor0.com.br";
		short dddTelefone = 62;
		long numeroTelefone = 32968122;
		String tipoTelefone = "FIXO";
		String numeroDoc1 = "33462461168";
		Date dataEmissaoDoc1 = null;
		String orgaoExpedidorDoc1 = null;
		String numeroDoc2 = "2215357";
		Date dataEmissaoDoc2 = formataData("26/05/1984");
		String orgaoExpedidorDoc2 = "SSP/GO";
		String sexo = "M";
		Date dataNascimento = formataData("27/06/1967");
		String nacionalidade = "Brasileira";
		String naturalidade = "Buriti Alegre";
		String nomeFantasia = "";
		
//		Dados da pessoa 1 para teste
		String nomePessoa1 = "Pessoa 1";
		String tipoEndereco1 = "RESIDENCIAL";
		String tipoLogradouro1 = "RUA";
		String nomeLogradouro1 = "SR 17";
		String numeroEndereco1 = "S/N";
		String complemento1 = "qd. 34 lt. 13A";
		Integer cep1 = 74393580;
		String nomeBairro1 = "Parque Santa Rita";
		String nomeCidade1 = "Goiânia";
		String nomeEstado1 = "Goiás";
		String nomePais1 = "Brasil";
		String email1 = "pessoa1@provedor1.com.br";
		short dddTelefone1 = 62;
		long numeroTelefone1 = 32968122;
		String tipoTelefone1 = "FIXO";
		String numeroDoc11 = "92226558187";
		Date dataEmissaoDoc11 = null;
		String orgaoExpedidorDoc11 = null;
		String numeroDoc21 = "4000066";
		Date dataEmissaoDoc21 = formataData("25/09/97");
		String orgaoExpedidorDoc21 = "DGPC/GO";
		String sexo1 = "F";
		Date dataNascimento1 = formataData("11/01/1981");
		String nacionalidade1 = "Brasileira";
		String naturalidade1 = "Goiânia";
		String nomeFantasia1 = "";
		
//		Dados da pessoa 2 para teste
		String nomePessoa2 = "Pessoa 2";
		String tipoEndereco2 = "RESIDENCIAL";
		String tipoLogradouro2 = "RUA";
		String nomeLogradouro2 = "40 E";
		String numeroEndereco2 = "S/N";
		String complemento2 = "qd. 45 lt. 25";
		Integer cep2 = 75430021;
		String nomeBairro2 = "Garavelo Residencial Parque";
		String nomeCidade2 = "Aparecida de Goiânia";
		String nomeEstado2 = "Goiás";
		String nomePais2 = "Brasil";
		String email2 = "pessoa2@provedor2.com";
		short dddTelefone2 = 62;
		long numeroTelefone2 = 35884739;
		String tipoTelefone2 = "FIXO";
		String numeroDoc12 = "43430759153";
		Date dataEmissaoDoc12 = null;
		String orgaoExpedidorDoc12 = null;
		String numeroDoc22 = "123456";
		Date dataEmissaoDoc22 = formataData("25/05/87");
		String orgaoExpedidorDoc22 = "SSP/GO";
		String sexo2 = "M";
		Date dataNascimento2 = formataData("09/05/1969");
		String nacionalidade2 = "Brasileira";
		String naturalidade2 = "Buriti Alegre";
		String nomeFantasia2 = "";
//		Dados da pessoa 3 para teste
		String nomePessoa3 = "Pessoa 3";
		String tipoEndereco3 = "RESIDENCIAL";
		String tipoLogradouro3 = "RUA";
		String nomeLogradouro3 = "40 E";
		String numeroEndereco3 = "S/N";
		String complemento3 = "qd. 45 lt. 25";
		Integer cep3 = 75430021;
		String nomeBairro3 = "Garavelo Residencial Parque";
		String nomeCidade3 = "Aparecida de Goiânia";
		String nomeEstado3 = "Goiás";
		String nomePais3 = "Brasil";
		String email3 = "pessoa3@provedor3.go.gov.br";
		short dddTelefone3 = 62;
		long numeroTelefone3 = 35884739;
		String tipoTelefone3 = "FIXO";
		String numeroDoc13 = "80330606115";
		Date dataEmissaoDoc13 = null;
		String orgaoExpedidorDoc13 = null;
		String numeroDoc23 = "654321";
		Date dataEmissaoDoc23 = formataData("18/12/80");
		String orgaoExpedidorDoc23 = "SSP/GO";
		String sexo3 = "F";
		Date dataNascimento3 = formataData("13/01/1962");
		String nacionalidade3 = "Brasileira";
		String naturalidade3 = "Jatai";
		String nomeFantasia3 = "";
		
		//Dados da pessoa 4 para teste
		String nomePessoa4 = "Empresa 1";
		String tipoEndereco4 = "COMERCIAL";
		String tipoLogradouro4 = "AVENIDA";
		String nomeLogradouro4 = "ANHANGUERA";
		String numeroEndereco4 = "5932";
		String complemento4 = "";
		Integer cep4 = 74095621;
		String nomeBairro4 = "Campinas";
		String nomeCidade4 = "Goiânia";
		String nomeEstado4 = "Goiás";
		String nomePais4 = "Brasil";
		String email4 = "empresa1@provedorcomercial1.com.br";
		short dddTelefone4 = 62;
		long numeroTelefone4 = 30954387;
		String tipoTelefone4 = "FIXO";
		String numeroDoc14 = "03314200000107";
		Date dataEmissaoDoc14 = null;
		String orgaoExpedidorDoc14 = null;
		String numeroDoc24 = "";
		Date dataEmissaoDoc24 = null;
		String orgaoExpedidorDoc24 = null;
		String sexo4 = null;
		Date dataNascimento4 = null;
		String nacionalidade4 = null;
		String naturalidade4 = null;
		String nomeFantasia4 = "Empresa Comercial 1";

		//Dados da pessoa 5 para teste
		String nomePessoa5 = "Vitoria Equipamentos Ltda.";
		String tipoEndereco5 = "COMERCIAL";
		String tipoLogradouro5 = "AVENIDA";
		String nomeLogradouro5 = "Jamel Cecilio";
		String numeroEndereco5 = "2511";
		String complemento5 = "qd. B 16 lt. 16/19";
		Integer cep5 = 74810100;
		String nomeBairro5 = "Jardim Goiás";
		String nomeCidade5 = "Goiânia";
		String nomeEstado5 = "Goiás";
		String nomePais5 = "Brasil";
		String email5 = "prime@primetek.com.br";
		short dddTelefone5 = 62;
		long numeroTelefone5 = 30956900;
		String tipoTelefone5 = "FIXO";
		String numeroDoc15 = "04732837000186";
		Date dataEmissaoDoc15 = null;
		String orgaoExpedidorDoc15 = null;
		String numeroDoc25 = "";
		Date dataEmissaoDoc25 = null;
		String orgaoExpedidorDoc25 = null;
		String sexo5 = null;
		Date dataNascimento5 = null;
		String nacionalidade5 = null;
		String naturalidade5 = null;
		String nomeFantasia5 = "Prime-Tek Computadores";
		//Cadastra Pessoa
		
		try {	
			ps.cadastraPessoa(
					nomePessoa, sexo, dataNascimento, nacionalidade, naturalidade, nomeFantasia, tipoEndereco, tipoLogradouro, nomeLogradouro, 
					numeroEndereco, complemento, cep, nomeBairro, nomeCidade, nomeEstado, nomePais, email, dddTelefone, numeroTelefone, tipoTelefone, 
					numeroDoc1, dataEmissaoDoc1, orgaoExpedidorDoc1, numeroDoc2, dataEmissaoDoc2, orgaoExpedidorDoc2);
		} catch (EscolaException ee) {
			ee.getMessage();
		}	
		//Cadastra Pessoa 1	
		
		try{	
			ps.cadastraPessoa(
					nomePessoa1, sexo1, dataNascimento1, nacionalidade1, naturalidade1, nomeFantasia1, tipoEndereco1, tipoLogradouro1, nomeLogradouro1, 
					numeroEndereco1, complemento1, cep1, nomeBairro1, nomeCidade1, nomeEstado1, nomePais1, email1, dddTelefone1, numeroTelefone1, 
					tipoTelefone1, numeroDoc11, dataEmissaoDoc11, orgaoExpedidorDoc11, numeroDoc21, dataEmissaoDoc21, orgaoExpedidorDoc21);
		} catch (EscolaException ee) {
			ee.getMessage();
		}			
		//Cadastra Pessoa 2
		try{
			ps.cadastraPessoa(
					nomePessoa2, sexo2, dataNascimento2, nacionalidade2, naturalidade2, nomeFantasia2, tipoEndereco2, tipoLogradouro2, nomeLogradouro2, 
					numeroEndereco2, complemento2, cep2, nomeBairro2, nomeCidade2, nomeEstado2, nomePais2, email2, dddTelefone2, numeroTelefone2, 
					tipoTelefone2, numeroDoc12, dataEmissaoDoc12, orgaoExpedidorDoc12, numeroDoc22, dataEmissaoDoc22, orgaoExpedidorDoc22);
		} catch (EscolaException ee) {
			ee.getMessage();
		}
		//Cadastra Pessoa 3
		try{
			ps.cadastraPessoa(
					nomePessoa3, sexo3, dataNascimento3, nacionalidade3, naturalidade3, nomeFantasia3, tipoEndereco3, tipoLogradouro3, nomeLogradouro3, 
					numeroEndereco3, complemento3, cep3, nomeBairro3, nomeCidade3, nomeEstado3, nomePais3, email3, dddTelefone3, numeroTelefone3, 
					tipoTelefone3, numeroDoc13, dataEmissaoDoc13, orgaoExpedidorDoc13, numeroDoc23, dataEmissaoDoc23, orgaoExpedidorDoc23);
		} catch (EscolaException ee) {
			ee.getMessage();
		}
		
		//Cadastra Pessoa 4
		try{
			ps.cadastraPessoa(
					nomePessoa4, sexo4, dataNascimento4, nacionalidade4, naturalidade4, nomeFantasia4, tipoEndereco4, tipoLogradouro4, nomeLogradouro4, 
					numeroEndereco4, complemento4, cep4, nomeBairro4, nomeCidade4, nomeEstado4, nomePais4, email4, dddTelefone4, numeroTelefone4, 
					tipoTelefone4, numeroDoc14, dataEmissaoDoc14, orgaoExpedidorDoc14, numeroDoc24, dataEmissaoDoc24, orgaoExpedidorDoc24);
		} catch (EscolaException ee) {
			ee.getMessage();
		}
		//Cadastra Pessoa 5
		try{
			ps.cadastraPessoa(
					nomePessoa5, sexo5, dataNascimento5, nacionalidade5, naturalidade5, nomeFantasia5, tipoEndereco5, tipoLogradouro5, nomeLogradouro5, 
					numeroEndereco5, complemento5, cep5, nomeBairro5, nomeCidade5, nomeEstado5, nomePais5, email5, dddTelefone5, numeroTelefone5, 
					tipoTelefone5, numeroDoc15, dataEmissaoDoc15, orgaoExpedidorDoc15, numeroDoc25, dataEmissaoDoc25, orgaoExpedidorDoc25);
		} catch (EscolaException ee) {
			ee.getMessage();
		}
		
		//finaliza a sessão com o banco de dados
		cpg.finaliza();
	}

}
