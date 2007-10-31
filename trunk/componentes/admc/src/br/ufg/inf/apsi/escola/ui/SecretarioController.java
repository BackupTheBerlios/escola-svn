package br.ufg.inf.apsi.escola.ui;

import static br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.util.Util.formataData;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario;
import br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * @author Ailton Antonio de Araujo
 * 
 */
public class SecretarioController {

	private SecretarioService secretarioService = null;
	private LocalServiceFactory localServiceFactory = null;
	private String matricula;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private Long telefone1;
	private Long telefone2;
	private Short dddf1;
	private Short dddf2;
	private String cpf;
	private String rg;
	private String dataEmissao;
	private String orgaoExpedidor;
	private String email;
	private String endereco;
	private String numero;
	private String complemento;
	private Integer cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private Long id;

	private PessoaService ps = null;
	
	public SecretarioController() {
		localServiceFactory = new LocalServiceFactory();
		secretarioService = localServiceFactory.obterSecretarioService();
		ps = localServiceFactory.obterPessoaService();
	}

	public String cadastro(){
		
		Secretario secretario = getSecretarioFromEditOrDelete();
		if(secretario==null){
			return novo();
		}else return editar();
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
		setDddf1(new String());
		setDddf2(new String());

		return "cadastroSecretario";
	}

	public String gravar() {
		Long p = null;
		try {

			p = ps.consultaPessoaDocumento(getCpf());

		} catch (EscolaException ee) {
			// FacesContext.getCurrentInstance().addMessage("msg",new
			// FacesMessage(ee.getMessage()));
			p = null;
		}
		try {

			if (p == null) {
				ps.cadastraPessoa(getNome(), getSexo(),
						formataData(getDataNascimento()), "", "", "",
						"RESIDENCIAL", "RUA", getEndereco(), getNumero(),
						getComplemento(), this.cep, getBairro(), getCidade(),
						getEstado(), getPais(), getEmail(), this.dddf1,
						this.telefone1, "FIXO", getCpf(), null, null, getRg(),
						formataData(getDataEmissao()), getOrgaoExpedidor());

				p = ps.consultaPessoaDocumento(getCpf());

			}
			if (getId() > 0) {
				secretarioService
						.gravar(new Secretario(getId(),getMatricula(),p));
			} else {
				secretarioService.gravar(new Secretario(getMatricula(),p));
			}

			limpar();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Dados Gravados com sucesso!"));

		} catch (EscolaException ee) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Erro ao gravar dados do Secretario!"));
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Erro ao gravar dados do Secretario!"));
		}

		return null;

	}

	public String excluir() throws Exception {
		

		try {

			secretarioService.excluir(getId());

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Secretario Excluído com sucesso!"));

			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Falha ao excluir o Secretario!"));
			return null;
		}

	}

	public String editar() {
		Secretario secretario = getSecretarioFromEditOrDelete();

		try {

			setMatricula(secretario.getMatricula());

			setNome(ps.consultaPessoaId(secretario.getPessoa_id()));
			/**
			 * 
			 * Não existe nenhum metodo em PessoaService q retorna os dados de
			 * uma pessoa Fisica ou Juridica somente nome
			 * 
			 */
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
			setDddf1(new String());
			setDddf2(new String());

			return "cadastroSecretario";
		} catch (Exception e) {
			return null;
		}

	}

	
	public Secretario getSecretarioFromEditOrDelete() {
		Secretario secretario = null;
		try {
			if(!secretarioService.consultar().isEmpty()){
				secretario=secretarioService.consultar().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return secretario;
	}

	public void limpar() {
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
		setDddf1(new String());
		setDddf2(new String());
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
		return ((telefone1 == null) || (telefone1.equals(0))) ? "" : String
				.valueOf(telefone1);
	}

	public void setTelefone1(String telefone1) {
		try {
			this.telefone1 = Long.parseLong(telefone1);
		} catch (NumberFormatException nf) {

		}
	}

	public String getTelefone2() {

		return ((telefone2 == null) || (telefone2.equals(0))) ? "" : String
				.valueOf(telefone2);

	}

	public void setTelefone2(String telefone2) {
		try {
			this.telefone2 = Long.parseLong(telefone2);
		} catch (NumberFormatException nf) {

		}
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
		return ((cep == null) || (cep.equals(0))) ? "" : String.valueOf(cep);
	}

	public void setCep(String cep) {
		try {
			this.cep = Integer.parseInt(cep);
		} catch (NumberFormatException nf) {

		}
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDddf1() {
		return ((dddf1 == null) || (dddf1.equals(0))) ? "" : String
				.valueOf(dddf1);
	}

	public void setDddf1(String dddf1) {
		try {
			this.dddf1 = Short.parseShort(dddf1);
		} catch (NumberFormatException ne) {

		}
	}

	public String getDddf2() {
		return ((dddf2 == null) || (dddf2.equals(0))) ? "" : String
				.valueOf(dddf2);
	}

	public void setDddf2(String dddf2) {
		try {
			this.dddf2 = Short.parseShort(dddf2);
		} catch (NumberFormatException ne) {

		}
	}

}
