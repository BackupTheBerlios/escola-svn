package br.ufg.inf.apsi.escola.componentes.pfj.servico;

import java.util.List;
import java.util.Date;
import java.util.Map;

import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.Telefone;

/**
 * Interface do componente Pessoa Fisica e Juridica
 * 
 * @author leandro
 * 
 */
public interface PessoaService {

	void adicionaDocumento(Long pessoaId, String numero, Date dataEmissao,
			String orgaoExpedidor) throws EscolaException;

	void adicionaEmail(Long pessoaId, String email) throws EscolaException;

	void adicionaEndereco(Long pessoaId, String tipoEndereco,
			String tipoLogradouro, String nomeLogradouro, String numero,
			String complemento, Integer cep, String nomeBairro,
			String nomeCidade, String nomeEstado, String nomePais)
			throws EscolaException;

	void adicionaTelefone(Long pessoaId, short ddd, long numero, String tipo)
			throws EscolaException;

	void alteraEmail(Long pessoaId, String emailAtual, String novoEmail)
			throws EscolaException;

	void alteraEndereco(Long pessoaId, String complementoAtual,
			String novoComplemento, String numeroAtual, String novoNumero,
			Integer cepAtual, Integer novoCep, String tipoEnderecoAtual,
			String novoTipoEndereco) throws EscolaException;

	void alteraTelefone(Long pessoaId, long numeroAtual, short novoDDD,
			long novoNumero, String novoTipo) throws EscolaException;

	Endereco cadastraEndereco(String tipoEndereco, String tipoLogradouro,
			String nomeLogradouro, String numero, String complemento,
			Integer cep, String nomeBairro, String nomeCidade,
			String nomeEstado, String nomePais) throws EscolaException;

	void cadastraPessoa(
			// atributos da pessoa
			String nomePessoa,
			String sexo,
			Date dataNascimento,
			String nacionalidade,
			String naturalidade,
			String nomeFantasia,
			// Endereço
			String tipoEndereco, String tipoLogradouro, String nomeLogradouro,
			String numeroEndereco, String complemento, Integer cep,
			String nomeBairro, String nomeCidade,
			String nomeEstado,
			String nomePais,
			// mail
			String mail, short dddTelefone, long numeroTelefone,
			String tipoTelefone,
			// Documentos
			String numeroDoc1, Date dataEmissaoDoc1, String orgaoExpedidorDoc1,
			String numeroDoc2, Date dataEmissaoDoc2, String orgaoExpedidorDoc2)
			throws EscolaException;

	Telefone cadastraTelefone(short ddd, long numero, String tipo)
			throws EscolaException;

	String consultaPessoaDocumento(String numeroDocumento)
			throws EscolaException;

	List<String> listaDocumentosPessoa(Long pessoaId) throws EscolaException;

	List<String> listaEmailsPessoa(Long pessoaId) throws EscolaException;

	List<String> listaEnderecosPessoa(Long pessoaId) throws EscolaException;

	List<String> listaPessoasEndereco(String nomeRua, String complemento,
			String numero) throws EscolaException;

	List<String> listaPessoas() throws EscolaException;

	List<String> listaPessoasBairro(String nomeBairro) throws EscolaException;

	List<String> listaPessoasCidade(String nomeCidade) throws EscolaException;

	List<String> listaPessoasNome(String nome) throws EscolaException;

	List<String> listaPessoasIdade(Date dataNascimento) throws EscolaException;

	List<String> listaPessoasSexo(String sexo) throws EscolaException;

	List<String> listaPessoasIdadeSexo(Date dataNascimento, String sexo)
			throws EscolaException;

	List<String> listaPessoasTelefone(long numTelefone) throws EscolaException;

	List<String> listaTelefonesPessoa(Long pessoaId) throws EscolaException;

	void removeDocumento(String numero) throws EscolaException;

	void removeEmail(String email) throws EscolaException;

	void removeEnderecoListaPessoa(Long pessoaId, String nomeLogradouro)
			throws EscolaException;

	void removePessoa(Long pessoaId) throws EscolaException;

	void removeTelefoneListaPessoa(Long pessoaId, long numero)
			throws EscolaException;

	boolean verificaAdicaoDocumentoLista(Pessoa p, Documento d);

	boolean verificaDocumentoUnicoLista(Pessoa p, Documento d);

	String consultaPessoaId(Long pessoaId) throws EscolaException;

	Map<Long, String> consultaPessoaPorDocumento(String numeroDocumento)
			throws EscolaException;

}
