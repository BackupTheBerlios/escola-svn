package br.ufg.inf.apsi.escola.componentes.pessoa.negocio;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository;

/**
 * Interface definida para disponibilizar as operações do componente pfj acessíveis externamente ao mesmo. 
 * @author gilmar
 *
 */

public interface PessoaService {
	
	/**
	 * Operação definida para adicionar documentos à lista de documentos de uma pessoa física.
	 * @param pessoaId
	 * @param numero
	 * @param dataEmissao
	 * @param orgaoExpedidor
	 * @throws EscolaException
	 */
	void adicionaDocumento(Long pessoaId,String numero,Date dataEmissao,String orgaoExpedidor) throws EscolaException;
	/**
	 * Operação definida para adicionar emails à lista de emails de uma pessoa.
	 * @param pessoaId
	 * @param email
	 * @throws EscolaException
	 */
	void adicionaEmail(Long pessoaId, String email) throws EscolaException;
	/**
	 * Operação definida para adicionar endere�os à lista de endereços de uma pessoa.
	 * @param pessoaId
	 * @param tipoEndereco
	 * @param tipoLogradouro
	 * @param nomeLogradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param nomeBairro
	 * @param nomeCidade
	 * @param nomeEstado
	 * @param nomePais
	 * @throws EscolaException
	 */
	void adicionaEndereco(Long pessoaId, String tipoEndereco, String tipoLogradouro, String nomeLogradouro, 
						  String numero, String complemento, Integer cep, String nomeBairro, String nomeCidade, 
						  String nomeEstado, String nomePais) throws EscolaException;

	/**
	 * operação definida para adicionar telefones à lista de telefones de uma pessoa.
	 * @param pessoaId
	 * @param ddd
	 * @param numero
	 * @param tipo
	 * @throws EscolaException
	 */
	void adicionaTelefone(Long pessoaId, short ddd, long numero, String tipo)throws EscolaException;
	
	/**
	 * Operação definida para alterar o email de uma pessoa, eventualmente se este tiver sido cadastrado errado.
	 * @param pessoaId
	 * @param emailAtual
	 * @param novoEmail
	 * @throws EscolaException
	 */
	void alteraEmail(Long pessoaId, String emailAtual, String novoEmail) throws EscolaException;
	
	/**
	 * operação definida para alterar os dados do endereço de uma determinada pessoa. 
	 * @param pessoaId
	 * @param complementoAtual
	 * @param novoComplemento
	 * @param numeroAtual
	 * @param novoNumero
	 * @param cepAtual
	 * @param novoCep
	 * @param tipoEnderecoAtual
	 * @param novoTipoEndereco
	 * @throws EscolaException
	 */
	void alteraEndereco(Long pessoaId, 
			String complementoAtual, String novoComplemento,
			String numeroAtual, String novoNumero,
			Integer cepAtual, Integer novoCep,
			String tipoEnderecoAtual, String novoTipoEndereco) throws EscolaException;
	
	/**
	 * Operação definida para alterar os dados de um dos telefones de uma pessoa.
	 * @param pessoaId
	 * @param numeroAtual
	 * @param novoDDD
	 * @param novoNumero
	 * @param novoTipo
	 * @throws EscolaException
	 */
	void alteraTelefone(Long pessoaId, long numeroAtual, short novoDDD, long novoNumero, String novoTipo) throws EscolaException;
	/**
	 * Operação definida para cadastrar um endereço.
	 * @param tipoEndereco
	 * @param tipoLogradouro
	 * @param nomeLogradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param nomeBairro
	 * @param nomeCidade
	 * @param nomeEstado
	 * @param nomePais 
	 * @return
	 * @throws EscolaException
	 */
	Endereco cadastraEndereco(String tipoEndereco, String tipoLogradouro, String nomeLogradouro, String numero, 
			  String complemento, Integer cep, String nomeBairro, String nomeCidade, String nomeEstado,
			  String nomePais) throws EscolaException;
	/**
	 * Operação definida para cadastrar uma pessoa.
	 * @param nomePessoa
	 * @param tipoEndereco
	 * @param tipoLogradouro
	 * @param nomeLogradouro
	 * @param numeroEndereco
	 * @param complemento
	 * @param cep
	 * @param nomeBairro
	 * @param nomeCidade
	 * @param nomeEstado
	 * @param nomePais
	 * @param mail
	 * @param dddTelefone
	 * @param numeroTelefone
	 * @param tipoTelefone
	 * @param numeroDoc1
	 * @param dataEmissaoDoc1
	 * @param orgaoExpedidorDoc1
	 * @param numeroDoc2
	 * @param dataEmissaoDoc2
	 * @param orgaoExpedidorDoc2
	 * @param sexo
	 * @param dataNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param nomeFantasia
	 * @throws EscolaException
	 */
	void cadastraPessoa(//atributos da pessoa
			String nomePessoa, String sexo, Date dataNascimento,String nacionalidade,String naturalidade,String nomeFantasia,
			//Endereço
			String  tipoEndereco, String tipoLogradouro, String nomeLogradouro, String numeroEndereco, String complemento, Integer cep, 
			String nomeBairro, String nomeCidade, String nomeEstado, String nomePais,
			//mail
			String mail,
			short dddTelefone, long numeroTelefone, String tipoTelefone,
			//Documentos
			String numeroDoc1, Date dataEmissaoDoc1, String orgaoExpedidorDoc1,
			String numeroDoc2, Date dataEmissaoDoc2, String orgaoExpedidorDoc2) throws EscolaException;
	/**
	 * Operação definida para cadastrar um telefone.
	 * @param ddd
	 * @param numero
	 * @param tipo
	 * @return
	 * @throws EscolaException
	 */
	Telefone cadastraTelefone(short ddd, long numero, String tipo) throws EscolaException;
	/**
	 * Operação definida para consultar uma pessoa a partir do número de um de seus documentos.
	 * @param numeroDocumento
	 * @return
	 * @throws EscolaException
	 */
	String consultaPessoaDocumento(String numeroDocumento) throws EscolaException;
	/**
	 * Operação definida para consulta os dados de uma pessoa (id e nome) a partir do número de um
	 * dos seus documentos
	 * @return
	 * @throws EscolaException
	 */
	Map<Long, String> consultaPessoaPorDocumento(String numeroDocumento) throws EscolaException;
	/**
	 * Operação definida para obter o repositório de bairros.
	 * @return
	 */
	BairroRepository getBairroRepository();
	/**
	 * Operação definida para obter o repositório de cidades.
	 * @return
	 */
	CidadeRepository getCidadeRepository();
	/**
	 * Operação definida para obter o repositório de Documentos. 
	 * @return
	 */
	DocumentoRepository getDocumentoRepository();
	/**
	 * Operação definida para obter o repositório de emails.
	 * @return
	 */
	EmailRepository getEmailRepository();
	/**
	 * Operação definida para obter o repositório de endereços.
	 * @return
	 */
	EnderecoRepository getEnderecoRepository();
	/**
	 * Operação definida para obter o repositório de estados.
	 * @return
	 */
	EstadoRepository getEstadoRepository();
	/**
	 * Operação definida para obter o repositório de logradouros.
	 * @return
	 */
	LogradouroRepository getLogradouroRepository();
	/**
	 * Operação definida para obter o repositório de países.
	 * @return
	 */
	PaisRepository getPaisRepository();
	/**
	 * Operação definida para obter o respositório de cidades.
	 * @return
	 */
	PessoaRepository getPessoaRepository();
	/**
	 * Operação definida para obter o repositório de telefones.
	 * @return
	 */
	TelefoneRepository getTelefoneRepository();
	/**
	 * Operação definida para listar os documentos de uma pessoa.
	 * @param pessoaId
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaDocumentosPessoa(Long pessoaId) throws EscolaException;

	/**
	 * Operação definida para listar os emails de uma pessoa.
	 * @param pessoaId
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaEmailsPessoa(Long pessoaId) throws EscolaException;
	/**
	 * Operação definida para listar os endereços de uma pessoa.
	 * @param pessoaId
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaEnderecosPessoa(Long pessoaId) throws EscolaException;
	/**
	 * Operação definida para listar o nome das pessoas relacionadas a um mesmo endereço.
	 * @param nomeRua
	 * @param complemento
	 * @param numero
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasEndereco(String nomeRua, String complemento, String numero) throws EscolaException;
	
	/**
	 * Operação definida para listar os nomes de todas as pessoas cadastradas no sistema
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoas() throws EscolaException;

	/**
	 * Operação definida para listar os nomes da pessoas que moram num determinado bairro.
	 * @param nomeBairro
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasBairro(String nomeBairro) throws EscolaException;

	/**
	 * Operação definida para listar os nomes da pessoas que moram numa determinada cidade.
	 * @param nomeCidade
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasCidade(String nomeCidade) throws EscolaException;

	/**
	 * Método definido para listar os nomes de pessoas pesquisadas por nome.
	 * @param nome
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasNome(String nome) throws EscolaException;
	/**
	 * Operação definida para listar as pessoas nascidas a partir de uma determinada data. 
	 * @param dataNascimento
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasIdade(Date dataNascimento) throws EscolaException; 
	/**
	 * Operação definida para listar todas as pessoas de um determinado sexo.
	 * @param sexo
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasSexo(String sexo) throws EscolaException;
	/**
	 * Operação definida para listar todas as pessoas de um sexo nascidas a partir de uma data.
	 * @param dataNascimento
	 * @param sexo
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasIdadeSexo(Date dataNascimento, String sexo) throws EscolaException;
	/**
	 * Operação definida para listar as pessoas relacionadas a um determinado telefone.
	 * @param numTelefone
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaPessoasTelefone(long numTelefone) throws EscolaException;
	/**
	 * Operação definida para listar os telefones de uma pessoa.
	 * @param pessoaId
	 * @return
	 * @throws EscolaException
	 */
	List<String> listaTelefonesPessoa(Long pessoaId) throws EscolaException;

	/**
	 * Operação definida para remover documentos da lista de documentos de uma pessoa.
	 * CNPJ ou CPF não poderão ser removidos, estão modelados como documentos obrigatórios.
	 * Esta verificação foi contemplada no método que implementa esta operação.
	 * @param numero
	 * @return
	 * @throws EscolaException
	 */
	
	void removeDocumento(String numero) throws EscolaException;
	/**
	 * Operação definida para remover emails da lista de emails de uma pessoa, ou mesmo removê-los definitivamento do cadastro.
	 * @param email
	 * @throws EscolaException
	 */
	void removeEmail(String email) throws EscolaException;

	/**
	 * Operação definida para remover endereços da lista de endereços de uma pessoa.
	 * @param pessoaId
	 * @param nomeLogradouro
	 * @throws EscolaException
	 */
	void removeEnderecoListaPessoa(Long pessoaId, String nomeLogradouro) throws EscolaException;
	
	/**
	 * Operação definido para remover o cadastro de uma pessoa.
	 * @param pessoaId
	 * @return
	 * @throws EscolaException
	 */
	void removePessoa(Long pessoaId) throws EscolaException;
	
	/**
	 * Operação definida para remover telefones da lista de telefones de uma pessoa.
	 * @param pessoaId
	 * @param numero
	 * @throws EscolaException
	 */
	void removeTelefoneListaPessoa(Long pessoaId, long numero) throws EscolaException;
	
	/**
	 * Operação definida para configurar o repositório de bairros.
	 * @param br
	 */
	void setBairroRepository(BairroRepository br);
	/**
	 * Operação definida para configurar o repositório de cidades.
	 * @param cr
	 */
	void setCidadeRepository(CidadeRepository cr);
	/**
	 * Operação definida para configurar o repositório de documentos.
	 * @param dr
	 */
	void setDocumentoRepository(DocumentoRepository dr);
	/**
	 * Operação definida para configurar o repositório de emails.
	 * @param er
	 */
	void setEmailRepository(EmailRepository er);
	/**
	 * Operação definida para configurar o repositório de endereços
	 * @param endRep
	 */
	void setEnderecoRepository(EnderecoRepository endRep);
	/**
	 * Operação definida para configurar o repositório de estados.
	 * @param er
	 */
	void setEstadoRepository(EstadoRepository er);
	/**
	 * Operação definida para configurar o repositório de logradouros.
	 * @param lr
	 */
	void setLogradouroRepository(LogradouroRepository lr);
	/**
	 * Operação definida para configurar o repositório de países.
	 * @param pr
	 */
	void setPaisRepository(PaisRepository pr);
	/**
	 * Operação definida para configurar o repositório de pessoas.
	 * @param pr
	 */
	void setPessoaRepository(PessoaRepository pr);
	/**
	 * Operação definida para configurar o repositório de telefones.
	 * @param tr
	 */
	void setTelefoneRepository(TelefoneRepository tr);
	/**
	 * Operação definida para verificar a exatidão da adição de documentos à lista de documentos de uma pessoa.
	 * Por exemplo, um CNPJ não poderá ser adicionado à lista de documentos de uma pessoa física, da mesma forma,
	 * um CPF ou RG não poderão ser adicionados à lista de documentos de uma Pessoa Jurídica. 
	 * @param p
	 * @param d
	 * @return
	 */
	boolean verificaAdicaoDocumentoLista(Pessoa p, Documento d);
	/**
	 * Operação definida para verificar se um documento, por exemplo CNPJ ou CPF, que devem ser únicos na lista de documentos de uma pessoa.
	 * @param p
	 * @param d
	 * @return
	 */
	boolean verificaDocumentoUnicoLista(Pessoa p, Documento d);
	
}
