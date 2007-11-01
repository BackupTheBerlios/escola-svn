package br.ufg.inf.apsi.escola.componentes.pfj.servico.local;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;

/**
 * Classe utilizada como apoio nos testes
 * 
 * @author leandro
 * 
 */
class LocalPessoaService implements PessoaService {

	private Long idPessoa1 = 1L;
	private Long idPessoa2 = 2L;
	private String email1 = "romario@especializacao.info";
	private String email2 = "robinho@especializacao.info";
	private String numeroDocumento1 = "123456";
	private String nomePessoa1 = "Romario de Sousa";
	private String numeroDocumento2 = "987654";
	private String nomePessoa2 = "Robinho da Silva";

	@Override
	public String consultaPessoaDocumento(String numeroDocumento)
			throws EscolaException {
		String retorno = "Pessoa Nao Encontrada!";

		if (numeroDocumento.equalsIgnoreCase(numeroDocumento1))
			retorno = nomePessoa1;
		if (numeroDocumento.equalsIgnoreCase(numeroDocumento2))
			retorno = nomePessoa2;

		return retorno;
	}

	@Override
	public String consultaPessoaId(Long pessoaId) throws EscolaException {
		String retorno = "Pessoa Nao Encontrada!";

		if (pessoaId == idPessoa1)
			retorno = nomePessoa1;
		if (pessoaId == idPessoa2)
			retorno = nomePessoa2;

		return retorno;

	}

	@Override
	public Map<Long, String> consultaPessoaPorDocumento(String numeroDocumento)
			throws EscolaException {
		Map<Long, String> mapaDePessoas = new HashMap<Long, String>();

		if (numeroDocumento.equalsIgnoreCase(numeroDocumento1))
			mapaDePessoas.put(idPessoa1, nomePessoa1);

		if (numeroDocumento.equalsIgnoreCase(numeroDocumento2))
			mapaDePessoas.put(idPessoa2, nomePessoa2);

		return mapaDePessoas;

	}

	@Override
	public List<String> listaEmailsPessoa(Long pessoaId) throws EscolaException {

		List<String> listaDeEmails = new LinkedList<String>();

		System.out.println("Passou por SERVICEIMPL'");

		if (pessoaId == idPessoa1)
			listaDeEmails.add(email1);
		if (pessoaId == idPessoa2)
			listaDeEmails.add(email2);

		return listaDeEmails;

	}

	@Override
	public void adicionaDocumento(Long pessoaId, String numero,
			Date dataEmissao, String orgaoExpedidor) throws EscolaException {

	}

	@Override
	public void adicionaEmail(Long pessoaId, String email)
			throws EscolaException {

	}

	@Override
	public void adicionaEndereco(Long pessoaId, String tipoEndereco,
			String tipoLogradouro, String nomeLogradouro, String numero,
			String complemento, Integer cep, String nomeBairro,
			String nomeCidade, String nomeEstado, String nomePais)
			throws EscolaException {

	}

	@Override
	public void adicionaTelefone(Long pessoaId, short ddd, long numero,
			String tipo) throws EscolaException {

	}

	@Override
	public void alteraEmail(Long pessoaId, String emailAtual, String novoEmail)
			throws EscolaException {

	}

	@Override
	public void alteraEndereco(Long pessoaId, String complementoAtual,
			String novoComplemento, String numeroAtual, String novoNumero,
			Integer cepAtual, Integer novoCep, String tipoEnderecoAtual,
			String novoTipoEndereco) throws EscolaException {

	}

	@Override
	public void alteraTelefone(Long pessoaId, long numeroAtual, short novoDDD,
			long novoNumero, String novoTipo) throws EscolaException {

	}

	@Override
	public Endereco cadastraEndereco(String tipoEndereco,
			String tipoLogradouro, String nomeLogradouro, String numero,
			String complemento, Integer cep, String nomeBairro,
			String nomeCidade, String nomeEstado, String nomePais)
			throws EscolaException {
		return null;
	}

	@Override
	public void cadastraPessoa(String nomePessoa, String sexo,
			Date dataNascimento, String nacionalidade, String naturalidade,
			String nomeFantasia, String tipoEndereco, String tipoLogradouro,
			String nomeLogradouro, String numeroEndereco, String complemento,
			Integer cep, String nomeBairro, String nomeCidade,
			String nomeEstado, String nomePais, String mail, short dddTelefone,
			long numeroTelefone, String tipoTelefone, String numeroDoc1,
			Date dataEmissaoDoc1, String orgaoExpedidorDoc1, String numeroDoc2,
			Date dataEmissaoDoc2, String orgaoExpedidorDoc2)
			throws EscolaException {

	}

	@Override
	public Telefone cadastraTelefone(short ddd, long numero, String tipo)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaDocumentosPessoa(Long pessoaId)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaEnderecosPessoa(Long pessoaId)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoas() throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasBairro(String nomeBairro)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasCidade(String nomeCidade)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasEndereco(String nomeRua,
			String complemento, String numero) throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasIdade(Date dataNascimento)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasIdadeSexo(Date dataNascimento, String sexo)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasNome(String nome) throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasSexo(String sexo) throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaPessoasTelefone(long numTelefone)
			throws EscolaException {
		return null;
	}

	@Override
	public List<String> listaTelefonesPessoa(Long pessoaId)
			throws EscolaException {
		return null;
	}

	@Override
	public void removeDocumento(String numero) throws EscolaException {

	}

	@Override
	public void removeEmail(String email) throws EscolaException {

	}

	@Override
	public void removeEnderecoListaPessoa(Long pessoaId, String nomeLogradouro)
			throws EscolaException {

	}

	@Override
	public void removePessoa(Long pessoaId) throws EscolaException {

	}

	@Override
	public void removeTelefoneListaPessoa(Long pessoaId, long numero)
			throws EscolaException {

	}

	@Override
	public boolean verificaAdicaoDocumentoLista(Pessoa p, Documento d) {
		return false;
	}

	@Override
	public boolean verificaDocumentoUnicoLista(Pessoa p, Documento d) {
		return false;
	}

}
