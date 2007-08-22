package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EnderecoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EnderecoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoEndereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoLogradouro;


/**
 * Classe definida para testar a interface EnderecoRepository
 * @author Gilmar
 *
 */
public class EnderecoRepositoryTeste extends MockObjectTestCase {

	private Endereco end = new Endereco();
	private Mock endMock = new Mock(EnderecoRepository.class);
	private EnderecoRepository er = (EnderecoRepository) endMock.proxy();
	/**
	 * 
	 */
	public void testaInlcuir(){
		
		endMock.expects(once()).method("incluir").with(eq(end)).will(returnValue(true));

		boolean esperado = true;

		try {
			assertEquals(esperado, er.incluir(end));
		} catch (EnderecoCadastradoException e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 */
	public void testaRemover(){
		
		endMock.expects(once()).method("remover").with(eq(end.getId())).will(returnValue(true));
		
		boolean esperado = true;
		
		try{
			assertEquals(esperado, er.remover(end.getId()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		
		endMock.expects(once()).method("salvar").with(eq(end)).will(returnValue(true));

		boolean esperado = true;

		try {
			assertEquals(esperado, er.salvar(end));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultarNomeRua(){
		List<Endereco> listaEnderecosRua = new ArrayList<Endereco>();
		Logradouro log = new Logradouro("Avenida Republica do Libano");
		
		end.setLogradouro(log);
		
		endMock.expects(once()).method("consultarNomeRua").with(eq(end.getLogradouro().getNome())).will(returnValue(new ArrayList<Endereco>()));
		
		try{
			assertEquals(listaEnderecosRua, er.consultarNomeRua(end.getLogradouro().getNome()));
		}catch (Exception e){
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}	
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		end.setCep(74093140);
		
		endMock.expects(once()).method("carregar").with(eq(end.getId())).will(returnValue(end));
		
		Integer cep = new Integer(74093140);
		
		try {
			assertEquals(cep, er.carregar(end.getId()).getCep());
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		
		endMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Endereco>()));
		
		try {
			assertEquals(listaEnderecos, er.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultaCep(){
		
		List<Endereco> listaEnderecosCep = new ArrayList<Endereco>();
		
		end.setCep(74393580);
		
		endMock.expects(once()).method("consultaCep").with(eq(end.getCep())).will(returnValue(new ArrayList<Endereco>()));
		
		try {
			assertEquals(listaEnderecosCep, er.consultaCep(end.getCep()));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultarDiversos(){
		Endereco end = new Endereco();
		end.setTipo(TipoEndereco.COMERCIAL);
		Logradouro log = new Logradouro();
		log.setTipo(TipoLogradouro.RUA);
		Bairro bairro = new Bairro("Setor Oeste");
		Cidade cidade = new Cidade("Goiânia");
		Estado estado = new Estado("Goiás");
		Pais pais = new Pais("Brasil");
		log.setNome("Rua A");
		end.setLogradouro(log);
		bairro.setCidade(cidade);
		cidade.setEstado(estado);
		estado.setPais(pais);
		end.setBairro(bairro);
		end.setNumero("25");
		end.setComplemento("Apartamento 15");
		end.setCep(74093140);
		
		endMock.expects(once()).method("consultarDiversos").will(returnValue(end));
		
		String esperado =
			"Tipo do Endereço.....: " + end.getTipo() + "\n" +
			"Logradouro...........: " + end.getLogradouro().getTipo() + " " + end.getLogradouro().getNome() + "\n" +
			"Número...............: " + end.getNumero() + "\n" +
			"Complemento..........: " + end.getComplemento() + "\n" +
			"Cep..................: " + end.getCep() + "\n" +
			"Bairro...............: " + end.getBairro().getNome() + "\n" +
			"Cidade...............: " + end.getBairro().getCidade().getNome() + "\n" +
			"Estado...............: " + end.getBairro().getCidade().getEstado().getNome() + "(" + end.getBairro().getCidade().getEstado().getSigla() + ")" + "\n" +
			"País.................: " + end.getBairro().getCidade().getEstado().getPais().getNome() + "\n";
		
		try {
			assertEquals(esperado, er.consultarDiversos("Rua A", "25", "Apartamento 15").toString());
		} catch (EnderecoNaoEncontradoException e) {
			e.getMessage();
		}
	}
}
