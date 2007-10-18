package br.ufg.inf.apsi.escola.ui;

import static br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.util.Util.formataData;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaServiceImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository;
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
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class AlunoController {

	private AlunoService alunoService = null;
	private LocalServiceFactory localServiceFactory = null;
	private String matricula;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String telefone1;
	private String telefone2;
	private String cpf;
	private String rg;
	private String dataEmissao;
	private String orgaoExpedidor;
	private String email;
	private String endereco;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;

	private DataModel model;
	private CriaPersistenciaGeral cpg = null;
	PessoaService ps = null;
	PessoaRepository pr = null;

	public AlunoController() {
		localServiceFactory = new LocalServiceFactory();
		alunoService = localServiceFactory.obterAlunoService();
        ps = localServiceFactory.obterPessoaService();
	}

	public String novo() {
		setMatricula(new String());
		setNome(new String());
		setDataNascimento(new String());
		setTelefone1(new String());
		setTelefone2(new String());
		setCpf(new String());
		setRg(new String());
		setDataEmissao(new String());
		setOrgaoExpedidor(new String());
		setEmail(new String());
		setEndereco(new String());
		setNumero(new String());
		setComplemento(new String());
		setCep(new String());
		setBairro(new String());
		setCidade(new String());
		setEstado(new String());
		setPais(new String());

		return "novoAluno";
	}

	public String gravar() {
		try {
			pr = ps.getPessoaRepository();
			Pessoa p = pr.consultaPessoaDocumento(getCpf());
			if (p == null) {
				ps.cadastraPessoa(getNome(), getSexo(),
						formataData(getDataNascimento()), "", "", "",
						"RESIDENCIAL", "", getEndereco(), getNumero(),
						getComplemento(), Integer.getInteger(getCep()),
						getBairro(), getCidade(), getEstado(), getPais(),
						getEmail(), Short.parseShort(getTelefone1()), Long
								.parseLong(getTelefone2()), "", getCpf(),
						formataData(""), "", getRg(),
						formataData(getDataEmissao()), getOrgaoExpedidor());

				p = pr.consultaPessoaDocumento(getCpf());
				alunoService.gravar(new Aluno(p.getId(), getMatricula(), null));
			} else {
				alunoService.gravar(new Aluno(p.getId(), getMatricula(), null));
			}

		} catch (EscolaException ee) {
			ee.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}

		return null;

	}

	public String editar() {
		Aluno aluno = getAlunoFromEditOrDelete();
		try {
			setMatricula(aluno.getNumeroMatricula());
			pr = ps.getPessoaRepository();
			Pessoa p = pr.consultarPessoaId(aluno.getPessoa());
			
			setNome(p.getNome());
			/**
			 * Nao foi disponibilizado em PessoaRepository um metodo q 
			 * permite consultar PessoaFisica, data nascimento e um 
			 * atributo de pessoa fisica.
			 */
			setDataNascimento("");
			setTelefone1(new String());
			setTelefone2(new String());
			setCpf(new String());
			setRg(new String());
			setDataEmissao(new String());
			setOrgaoExpedidor(new String());
			setEmail(new String());
			setEndereco(new String());
			setNumero(new String());
			setComplemento(new String());
			setCep(new String());
			setBairro(new String());
			setCidade(new String());
			setEstado(new String());
			setPais(new String());
			return "editar";
		} catch (Exception e) {
			return null;
		}

	}

	public DataModel getTodos() throws Exception {
		try{
		
		model = new ListDataModel(alunoService.consultar());
		
		}catch(Exception e){
			e.getMessage();
		}
		return model;
	}

	public Aluno getAlunoFromEditOrDelete() {
		Aluno aluno = (Aluno) model.getRowData();
		return aluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public CriaPersistenciaGeral getCpg() {
		return cpg;
	}

	public void setCpg(CriaPersistenciaGeral cpg) {
		this.cpg = cpg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
