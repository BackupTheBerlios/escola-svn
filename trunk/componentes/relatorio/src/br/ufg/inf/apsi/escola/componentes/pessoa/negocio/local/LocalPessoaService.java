package br.ufg.inf.apsi.escola.componentes.pessoa.negocio.local;

import java.util.Date;
import java.util.List;
import java.util.Map;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
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

public class LocalPessoaService implements PessoaService {

	public void adicionaDocumento(Long pessoaId, String numero,
			Date dataEmissao, String orgaoExpedidor) throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void adicionaEmail(Long pessoaId, String email)
			throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void adicionaEndereco(Long pessoaId, String tipoEndereco,
			String tipoLogradouro, String nomeLogradouro, String numero,
			String complemento, Integer cep, String nomeBairro,
			String nomeCidade, String nomeEstado, String nomePais)
			throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void adicionaTelefone(Long pessoaId, short ddd, long numero,
			String tipo) throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void alteraEmail(Long pessoaId, String emailAtual, String novoEmail)
			throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void alteraEndereco(Long pessoaId, String complementoAtual,
			String novoComplemento, String numeroAtual, String novoNumero,
			Integer cepAtual, Integer novoCep, String tipoEnderecoAtual,
			String novoTipoEndereco) throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void alteraTelefone(Long pessoaId, long numeroAtual, short novoDDD,
			long novoNumero, String novoTipo) throws EscolaException {
		// TODO Auto-generated method stub

	}

	public Endereco cadastraEndereco(String tipoEndereco,
			String tipoLogradouro, String nomeLogradouro, String numero,
			String complemento, Integer cep, String nomeBairro,
			String nomeCidade, String nomeEstado, String nomePais)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

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
		// TODO Auto-generated method stub

	}

	public Telefone cadastraTelefone(short ddd, long numero, String tipo)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public String consultaPessoaDocumento(String numeroDocumento)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public String consultaPessoaId(Long pessoaId) throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Long, String> consultaPessoaPorDocumento(String numeroDocumento)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public BairroRepository getBairroRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public CidadeRepository getCidadeRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public DocumentoRepository getDocumentoRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmailRepository getEmailRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public EnderecoRepository getEnderecoRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public EstadoRepository getEstadoRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public LogradouroRepository getLogradouroRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public PaisRepository getPaisRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public PessoaRepository getPessoaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public TelefoneRepository getTelefoneRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaDocumentosPessoa(Long pessoaId)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaEmailsPessoa(Long pessoaId) throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaEnderecosPessoa(Long pessoaId)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoas() throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasBairro(String nomeBairro)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasCidade(String nomeCidade)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasEndereco(String nomeRua,
			String complemento, String numero) throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasIdade(Date dataNascimento)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasIdadeSexo(Date dataNascimento, String sexo)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasNome(String nome) throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasSexo(String sexo) throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaPessoasTelefone(long numTelefone)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listaTelefonesPessoa(Long pessoaId)
			throws EscolaException {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeDocumento(String numero) throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void removeEmail(String email) throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void removeEnderecoListaPessoa(Long pessoaId, String nomeLogradouro)
			throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void removePessoa(Long pessoaId) throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void removeTelefoneListaPessoa(Long pessoaId, long numero)
			throws EscolaException {
		// TODO Auto-generated method stub

	}

	public void setBairroRepository(BairroRepository br) {
		// TODO Auto-generated method stub

	}

	public void setCidadeRepository(CidadeRepository cr) {
		// TODO Auto-generated method stub

	}

	public void setDocumentoRepository(DocumentoRepository dr) {
		// TODO Auto-generated method stub

	}

	public void setEmailRepository(EmailRepository er) {
		// TODO Auto-generated method stub

	}

	public void setEnderecoRepository(EnderecoRepository endRep) {
		// TODO Auto-generated method stub

	}

	public void setEstadoRepository(EstadoRepository er) {
		// TODO Auto-generated method stub

	}

	public void setLogradouroRepository(LogradouroRepository lr) {
		// TODO Auto-generated method stub

	}

	public void setPaisRepository(PaisRepository pr) {
		// TODO Auto-generated method stub

	}

	public void setPessoaRepository(PessoaRepository pr) {
		// TODO Auto-generated method stub

	}

	public void setTelefoneRepository(TelefoneRepository tr) {
		// TODO Auto-generated method stub

	}

	public boolean verificaAdicaoDocumentoLista(Pessoa p, Documento d) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verificaDocumentoUnicoLista(Pessoa p, Documento d) {
		// TODO Auto-generated method stub
		return false;
	}

}
