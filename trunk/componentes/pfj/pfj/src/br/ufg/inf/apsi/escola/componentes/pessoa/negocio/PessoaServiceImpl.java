package br.ufg.inf.apsi.escola.componentes.pessoa.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEnderecoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.RemocaoDocumentoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoEndereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoTelefone;
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
 * Classe definida para implementar a interface PessoaService, disponibilizando os serviços constantes daquela interface.
 * @author gilmar
 */
public class PessoaServiceImpl implements PessoaService {
	/**
	 * atributo definido para representar o repositório de bairros
	 */		
	private BairroRepository 			 bairroRepository 	  = null;
	/**
	 * atributo definido para representar o repositório de cidades
	 */
	private CidadeRepository 			 cidadeRepository 	  = null;
	/**
	 * atributo definido para representar o repositório de documentos
	 */
	private DocumentoRepository 		 documentoRepository  = null;
	/**
	 * atributo definido para representar o repositório de emails
	 */
	private EmailRepository 			 emailRepository 	  = null;
	/**
	 * atributo definido para representar o repositório de endereços
	 */
	private EnderecoRepository 			 enderecoRepository   = null;
	/**
	 * atributo definido para representar o repositório de estados
	 */
	private EstadoRepository 			 estadoRepository  	  = null;
	/**
	 * atributo definido para representar o repositório de logradouros
	 */
	private LogradouroRepository 		 logradouroRepository = null;
	/**
	 * atributo definido para representar o repositório de países
	 */
	private PaisRepository 				 paisRepository 	  = null;
	/**
	 * atributo definido para representar o repositório de pessoas
	 */
	private PessoaRepository 			 pessoaRepository 	  = null;
	/**
	 * atributo definido para representar o repositório de telefones
	 */
	private TelefoneRepository 			 telefoneRepository   = null;
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#adicionaDocumento(Long, String, Date, String)
	 */
	public void adicionaDocumento(Long pessoaId,String numero, Date dataEmissao, String orgaoExpedidor) throws EscolaException {
		Pessoa pessoa = null;
		Documento doc = null;
		//atribui à referência pessoa,  a pessoa instanciada partir do parâmetro pessoaId.
		try{
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
			try {
				//Pesquisa se o documento existe na base de dados
				doc = documentoRepository.consultar(numero);
				if (doc.getNumero() != null){
					throw new EscolaException(new DocumentoCadastradoException().getMessage());
				}
				//Documento não encontrado.
			} catch (DocumentoNaoEncontradoException dnee) {
				//cria um novo documento a partir dos parâmetros informados.
				doc = Documento.getDocumento(numero, dataEmissao, orgaoExpedidor);
				//verifica se o documento é um documento válido
				if (doc.validar(doc.getNumero())){
					//verifica se o documento pode ser adicionado à lista de documentos da pessoa.
					if (verificaAdicaoDocumentoLista(pessoa, doc)){
						//verifica se o documento é cpf ou cnpj e se na lista de documentos da pessoa não consta um destes tipos de documento
						if (verificaDocumentoUnicoLista(pessoa, doc)){
							//verifica se o documento consta da lista de documentos da pessoa.
							if (!pessoa.getListaDocumentos().contains(doc)){
								try {
									doc.setTitular(pessoa);
									documentoRepository.incluir(doc);
								} catch (DocumentoCadastradoException dce) {
									throw new EscolaException(dce.getMessage());
								}
							}
						}
					}
				}
			}
			//pessoa não encontrada
		}catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}	
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#removeDocumento(String)
	 */
	public void removeDocumento(String numero) throws EscolaException {
		Documento doc = null;
		try {
			doc = documentoRepository.consultar(numero);
			if (doc instanceof RG){
				try {
					documentoRepository.remover(numero);
				} catch (RemocaoDocumentoException rde) {
					throw new EscolaException(rde.getMessage());
				}		
			}
		}catch (DocumentoNaoEncontradoException dnee) {
			throw new EscolaException(dnee.getMessage());
		}
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#adicionaEmail(Long, String)
	 */		
	public void adicionaEmail(Long pessoaId, String email) throws EscolaException {
		Pessoa pessoa = null;
		Email mail = null;
		//atribui à referência pessoa,  a pessoa instanciada partir do parâmetro pessoaId.
		try{
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
		}catch (PessoaNaoEncontradaException pne) {
			throw new EscolaException(pne.getMessage());
		}	
		//consulta se o email já existe, se existe ou já faz parte da lista de emails da pessoa, ou de outra pessoa,
		//portanto não pode mais ser adicionado.
		try {
			mail = emailRepository.consultar(email);
		} catch (EmailNaoEncontradoException enee) {
			// Email não encontrado, portanto não existe
			//Cria um email a partir da string informada
			mail =  new Email(email);
			if (mail.validar(mail.getEmail())){
				mail.setTitularEmail(pessoa);
				try {
					emailRepository.incluir(mail);
				} catch (EmailCadastradoException ece) {
					throw new EscolaException(ece.getMessage());
				}
				pessoa.getListaEmails().add(mail);
			}
		}	
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#removeEmail(String)
	 */
	public void removeEmail(String email) throws EscolaException {
		try {
			emailRepository.remover(email);
		} catch (EscolaException ee) {
			throw new EscolaException(ee.getMessage());
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#alteraEmail(Long, String, String) 
	 */
	public void alteraEmail(Long pessoaId, String emailAtual, String novoEmail) throws EscolaException {
		Pessoa pessoa = null;
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
			for(Email e : pessoa.getListaEmails()){
				if (e.getEmail().equals(emailAtual)){
					e.setEmail(novoEmail);
				}
				emailRepository.salvar(e);
			}
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#adicionaEndereco(Long, String, String, String, String, String, Integer, String, String, String, String)
	 */
	public void adicionaEndereco(Long pessoaId, String tipoEndereco, String tipoLogradouro, String nomeLogradouro, String numero, String complemento, 
			Integer cep, String nomeBairro, String nomeCidade, String nomeEstado, String nomePais) throws EscolaException {
		Pessoa pessoa = null;
		Endereco endereco = null;
		//atribui à referência pessoa,  a pessoa instanciada partir do parâmetro pessoaId
		try{
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
		}catch (PessoaNaoEncontradaException pne) {
			throw new EscolaException(pne.getMessage());
		}	
		//Pesquisa se o endereço já existe na base de dados
		try{
			//Se o endereço existe será adicionado à lista de endereços da pessoa;
			endereco = enderecoRepository.consultarDiversos(nomeLogradouro, complemento, numero);
			if (!pessoa.getListaEnderecos().contains(endereco)){
				pessoa.getListaEnderecos().add(endereco);
				endereco.getPessoas().add(pessoa);
				pessoaRepository.salvar(pessoa);
				enderecoRepository.salvar(endereco);
			}
		}catch (EnderecoNaoEncontradoException enee) {
			//Se o endeço não existe, será criado e adicionado à lista de endereços da pessoa
			endereco = cadastraEndereco(tipoEndereco, tipoLogradouro, nomeLogradouro, numero, complemento, cep, nomeBairro, nomeCidade, nomeEstado, nomePais);
			pessoa.getListaEnderecos().add(endereco);
			endereco.getPessoas().add(pessoa);
			pessoaRepository.salvar(pessoa);
			enderecoRepository.salvar(endereco);
		}		
	}	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#removeEnderecoListaPessoa(Long, String)
	 */
	@SuppressWarnings("unchecked")
	public void removeEnderecoListaPessoa(Long pessoaId, String nomeLogradouro) throws EscolaException {
		
		try{
			List<Endereco> listaEnderecos = enderecoRepository.consultarNomeRua(nomeLogradouro);
			for (Endereco end : listaEnderecos){
				for(Pessoa p : end.getPessoas()){
					if (p.getId() == pessoaId){
						p.getListaEnderecos().remove(end);
						end.getPessoas().remove(p);
						pessoaRepository.salvar(p);
						enderecoRepository.salvar(end);
					}
				}
			}
		}catch (NenhumEnderecoEncontradoException neee) {
			throw new EscolaException(neee.getMessage());
		}
		
	}
	
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#alteraEndereco(Long, String, String, String, String, Integer, Integer, String, String)
	 */
	public void alteraEndereco(Long pessoaId,
			String complementoAtual, String novoComplemento,
			String numeroAtual, String novoNumero,
			Integer cepAtual, Integer novoCep,
			String tipoEnderecoAtual, String novoTipoEndereco) throws EscolaException{
		
		//atribui à referência pessoa,  a pessoa instanciada partir do parâmetro pessoaId
		Pessoa pessoa = null;
		try{
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
		}catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
		//percorre a lista de endereços da pessoa para procurar o endereço cujo cep é igual ao cep atual passado como parâmetro.
		for (Endereco end : pessoa.getListaEnderecos()){
			
			if(end.getComplemento().equals(complementoAtual)){
				end.setComplemento(novoComplemento);
			}
			if(end.getNumero().equals(numeroAtual)){
				end.setNumero(novoNumero);
			}
			if(end.getCep() == cepAtual){
				end.setCep(novoCep);
			}
			if(end.getTipo().equals(TipoEndereco.valueOf(tipoEnderecoAtual))){
				end.setTipo(TipoEndereco.valueOf(novoTipoEndereco));
			}
			enderecoRepository.salvar(end);
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#adicionaTelefone(Long, short, long, String)
	 */
	public void adicionaTelefone(Long pessoaId, short ddd, long numero, String tipo) throws EscolaException{
		Pessoa pessoa = null;
		Telefone telefone = null;
		//atribui à referência pessoa,  a pessoa instanciada partir do parâmetro pessoaId
		try{
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
		}catch (PessoaNaoEncontradaException pne) {
			throw new EscolaException(pne.getMessage());
		}	
		//Pesquisa se o telefone já existe na base de dados
		try{
			//Se o telefone existe será adicionado à lista de telefones da pessoa;
			telefone = telefoneRepository.consultar(numero);
			if (!pessoa.getListaTelefones().contains(telefone)){
				pessoa.getListaTelefones().add(telefone);
				telefone.getPessoas().add(pessoa);
				pessoaRepository.salvar(pessoa);
				telefoneRepository.salvar(telefone);
			}
		}catch (TelefoneNaoEncontradoException enee) {
			//Se o telefone não existe, será criado e adicionado à lista de telefones da pessoa
			telefone = cadastraTelefone(ddd, numero, tipo);
			pessoa.getListaTelefones().add(telefone);
			telefone.getPessoas().add(pessoa);
			pessoaRepository.salvar(pessoa);
			telefoneRepository.salvar(telefone);
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#removeTelefoneListaPessoa(Long, long)
	 */
	public void removeTelefoneListaPessoa(Long pessoaId, long telefoneNumero) throws EscolaException{
		
		try{
			Telefone t = telefoneRepository.consultar(telefoneNumero);
			for (Pessoa p : t.getPessoas()){
				if (p.getId() == pessoaId){
					p.getListaTelefones().remove(t);
					t.getPessoas().remove(p);
					pessoaRepository.salvar(p);
					telefoneRepository.salvar(t);
				}
			}
		}catch (TelefoneNaoEncontradoException tnee) {
			throw new EscolaException(tnee.getMessage());
		}
		
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#alteraTelefone(Long, long, short, long, String)
	 */
	public void alteraTelefone(Long pessoaId, long numeroAtual, short novoDDD, long novoNumero, String novoTipo) throws EscolaException {
		Pessoa pessoa = null;
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
			for (Telefone t : pessoa.getListaTelefones()){
				String tipo = String.valueOf(t.getTipo());
				if (t.getNumero() == numeroAtual){
					if (t.getDDD() != novoDDD){
						t.setDDD(novoDDD);
					}
					if (t.getNumero() != novoNumero){
						t.setNumero(novoNumero);
					}
					if (!t.getTipo().equals(tipo)){
						t.setTipo(TipoTelefone.valueOf(novoTipo));
					}
				}
				try {
					telefoneRepository.salvar(t);
				} catch (EscolaException ee) {
					throw new EscolaException(ee.getMessage());
				}
				
			}
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#cadastraEndereco(String, String, String, String, String, Integer, String, String, String, String)
	 */
	public Endereco cadastraEndereco(String tipoEndereco, String tipoLogradouro, String nomeLogradouro, String numero, String complemento, 
			Integer cep, String nomeBairro, String nomeCidade, String nomeEstado, String nomePais) throws EscolaException {
		Pais pais = null;
		Estado estado = null;
		Cidade cidade = null;
		Bairro bairro = null;
		Logradouro logradouro = null;
		Endereco endereco = null;
		//Manipula dados do País
		try {
			pais = paisRepository.consultar(nomePais);
		}catch (PaisNaoEncontradoException pnee) {
			pais = new Pais(nomePais);
			try {
				paisRepository.incluir(pais);
			} catch (PaisCadastradoException pce) {
				throw new EscolaException(pce.getMessage());
			}
		}
		//Manipula dados do estado
		try{
			estado = estadoRepository.consultar(nomeEstado);
		}catch (EstadoNaoEncontradoException enee) {
			estado = new Estado(nomeEstado, pais);
			try {
				estadoRepository.incluir(estado);
			} catch (EstadoCadastradoException ece) {
				throw new EscolaException(ece.getMessage());
			}
		}	
		//Manipula os dados da cidade
		try{
			cidade = cidadeRepository.consultar(nomeCidade);
		}catch (CidadeNaoEncontradaException cnee) {
			cidade = new Cidade(nomeCidade, estado);
			try {
				cidadeRepository.incluir(cidade);
			} catch (CidadeCadastradaException cce) {
				throw new EscolaException(cce.getMessage());
			}
		}	
		//Manipula os dados do bairro
		try{
			bairro = bairroRepository.consultar(nomeBairro);
		}catch (BairroNaoEncontradoException bnee) {
			bairro = new Bairro(nomeBairro, cidade);
			try{
				bairroRepository.incluir(bairro);
			}catch (BairroCadastradoException bce) {
				throw new EscolaException(bce.getMessage());
			}
		}	
		//Manipula os dados do logradouro
		try{
			logradouro = logradouroRepository.consultar(nomeLogradouro);
		}catch (LogradouroNaoEncontradoException lnee) {
			logradouro = new Logradouro(tipoLogradouro, nomeLogradouro);
			try {
				logradouroRepository.incluir(logradouro);
			} catch (LogradouroCadastradoException lce) {
				throw new EscolaException(lce.getMessage());
			}
		}
		//manipula os dados do endereco
		endereco = new Endereco(tipoEndereco,logradouro, numero, complemento, 
				cep, bairro);
		try{
			enderecoRepository.incluir(endereco);	
		} catch (EnderecoCadastradoException ece) {
			throw new EscolaException(ece.getMessage());
		}
		return endereco;
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#cadastraPessoa(String, String, Date, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, short, long, String, String, Date, String, String, Date, String)
	 */
	public void cadastraPessoa(
			//atributos da pessoa
			String nomePessoa, String sexo, Date dataNascimento,String nacionalidade,String naturalidade,String nomeFantasia,
			//Endereço
			String  tipoEndereco, String tipoLogradouro, String nomeLogradouro, String numeroEndereco, String complemento, Integer cep, 
			String nomeBairro, String nomeCidade, String nomeEstado, String nomePais,
			//mail
			String mail,
			short dddTelefone, long numeroTelefone, String tipoTelefone,
			//Documentos
			String numeroDoc1, Date dataEmissaoDoc1, String orgaoExpedidorDoc1,
			String numeroDoc2, Date dataEmissaoDoc2, String orgaoExpedidorDoc2) throws EscolaException{
		Pessoa pessoa = null;
		Documento doc = null;

		//consulta a existência do documento na base de dados
		//se o documento existe, automaticamente a pessoa titular existe, pois não existe documento sem pessoa.
		try {
			doc = documentoRepository.consultar(numeroDoc1);
		} catch (DocumentoNaoEncontradoException dnee) {
			
			//Definir que tipo de pessoa instanciar a partir dos documentos
			doc = Documento.getDocumento(numeroDoc1, dataEmissaoDoc1, orgaoExpedidorDoc1);
			
			if (doc instanceof CPF){
				pessoa = new PessoaFisica(nomePessoa);
				PessoaFisica pf = (PessoaFisica) pessoa;
				pf.setSexo(sexo);
				pf.setDataNascimento(dataNascimento);
				pf.setNacionalidade(nacionalidade);
				pf.setNaturalidade(naturalidade);
				try{
					pessoaRepository.incluir(pf);
					adicionaEmail(pf.getId(), mail);
					adicionaEndereco(pf.getId(), tipoEndereco, tipoLogradouro, nomeLogradouro, numeroEndereco, complemento, cep, nomeBairro, nomeCidade, nomeEstado, nomePais);
					adicionaDocumento(pf.getId(), numeroDoc1, dataEmissaoDoc1, orgaoExpedidorDoc1);
					adicionaDocumento(pf.getId(), numeroDoc2, dataEmissaoDoc2, orgaoExpedidorDoc2);
					adicionaTelefone(pf.getId(), dddTelefone, numeroTelefone, tipoTelefone);
				}catch (PessoaCadastradaException pce) {
					throw new EscolaException(pce.getMessage());
				}
			}else {
				pessoa = new PessoaJuridica(nomePessoa);
				PessoaJuridica pj = (PessoaJuridica) pessoa;
				pj.setNomeFantasia(nomeFantasia);
				try{
					pessoaRepository.incluir(pj);
					adicionaEmail(pj.getId(), mail);
					adicionaEndereco(pj.getId(), tipoEndereco, tipoLogradouro, nomeLogradouro, numeroEndereco, complemento, cep, nomeBairro, nomeCidade, nomeEstado, nomePais);						
					adicionaDocumento(pj.getId(), numeroDoc1, dataEmissaoDoc1, orgaoExpedidorDoc1);
					adicionaTelefone(pj.getId(), dddTelefone, numeroTelefone, tipoTelefone);	
				} catch (PessoaCadastradaException pce) {
					throw new EscolaException(pce.getMessage());
				}
			}
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#cadastraTelefone(short, long, String)
	 */
	public Telefone cadastraTelefone(short ddd, long numero, String tipo) throws EscolaException{
		
		Telefone telefone = null;
		try {
			telefone = telefoneRepository.consultar(numero);
		} catch (TelefoneNaoEncontradoException tnee) {
			telefone = new Telefone(ddd, numero, tipo);
			try {
				telefoneRepository.incluir(telefone);		
			} catch (TelefoneCadastradoException tce) {
				throw new EscolaException(tce.getMessage());
			}
		}
		return telefone;
		
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#consultaPessoaDocumento(String)
	 */
	public String consultaPessoaDocumento(String numeroDocumento) throws EscolaException {
		
		try {
			Pessoa pessoa = pessoaRepository.consultaPessoaDocumento(numeroDocumento);
			return pessoa.getNome();		
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
		
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#consultaPessoaId(Long)
	 */	
	@Override
	public Long consultaPessoaDocumentoId(String numeroDocumento)
			throws EscolaException {
		try {
			Pessoa pessoa = pessoaRepository.consultaPessoaDocumento(numeroDocumento);
			return pessoa.getId();		
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#consultaPessoaId(Long)
	 */
	@Override
	public String consultaPessoaId(Long pessoaId) throws EscolaException {
		Pessoa pessoa = null;
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
		} catch (PessoaNaoEncontradaException e) {
			throw new EscolaException(e.getMessage());
		}
		return pessoa.getNome();
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#consultaPessoaPorDocumento(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<Long, String> consultaPessoaPorDocumento(String numeroDocumento)
			throws EscolaException {
		Map<Long, String> idNomePessoa = null;
		try {
			idNomePessoa = pessoaRepository.consultaPessoaPorDocumento(numeroDocumento);
		} catch (PessoaNaoEncontradaException e) {
			throw new EscolaException(e.getMessage());
		}
		return idNomePessoa;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getBairroRepository()
	 */
	public BairroRepository getBairroRepository() {
		return bairroRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getCidadeRepository()
	 */
	public CidadeRepository getCidadeRepository() {
		return cidadeRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getDocumentoRepository()
	 */
	public DocumentoRepository getDocumentoRepository() {
		return documentoRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getEnderecoRepository()
	 */
	public EnderecoRepository getEnderecoRepository() {
		return enderecoRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getEmailRepository()
	 */
	public EmailRepository getEmailRepository() {
		return emailRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getEstadoRepository()
	 */
	public EstadoRepository getEstadoRepository() {
		return estadoRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getLogradouroRepository()
	 */
	public LogradouroRepository getLogradouroRepository() {
		return logradouroRepository;
	}


	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getPaisRepository()
	 */
	public PaisRepository getPaisRepository() {
		return paisRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getPessoaRepository()
	 */
	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#getTelefoneRepository()
	 */
	public TelefoneRepository getTelefoneRepository() {
		return telefoneRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaDocumentosPessoa(Long)
	 */
	public List<String> listaDocumentosPessoa(Long pessoaId) throws EscolaException {
		Pessoa pessoa = null;
		
		//Atribui à referência pessoa, a pessoa instanciada a partir do id passado como parâmetro
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
			List<String> listaDocumentosPessoa = new ArrayList<String>();
			for (Documento doc : pessoa.getListaDocumentos()){
				
				if (doc instanceof RG) {
					RG doc1 = (RG) doc;
					listaDocumentosPessoa.add(doc.getNumero() + " " + doc.getTipo() + " " +
							doc1.getDataEmissao() + " " + doc1.getOrgaoExpedidor() + "\n");
				}else
					listaDocumentosPessoa.add(doc.getNumero() + " " + doc.getTipo() + "\n");
			}
			return listaDocumentosPessoa;
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaEmailsPessoa(Long)
	 */
	public List<String> listaEmailsPessoa(Long pessoaId) throws EscolaException {
		Pessoa pessoa = null;
		//Atribui à referência pessoa, a pessoa instanciada a partir do id passado como parâmetro
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
			List<String> listaEmailsPessoa = new ArrayList<String>();
			for (Email email : pessoa.getListaEmails()){
				listaEmailsPessoa.add(email.getEmail() + "\n");
			}
			return listaEmailsPessoa;	
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaEnderecosPessoa(Long)
	 */
	public List<String> listaEnderecosPessoa(Long pessoaId) throws EscolaException {
		Pessoa pessoa = null;
//		Atribui à referência pessoa, a pessoa instanciada a partir do id passado como parâmetro
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
			List<String> listaEnderecosPessoa = new ArrayList<String>();
			for (Endereco end : pessoa.getListaEnderecos()){
				listaEnderecosPessoa.add(end.toString());
			}
			return listaEnderecosPessoa;
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
	}
	
	/** 
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasEndereco(String, String, String)
	 */
	public List<String> listaPessoasEndereco(String nomeRua, String complemento, String numero) throws EscolaException {
		Endereco end = null;
		try {
			end = enderecoRepository.consultarDiversos(nomeRua, complemento, numero);
			List<String> nomePessoas = new ArrayList<String>();
			for(Pessoa p : end.getPessoas()){
				nomePessoas.add(p.getNome());
			}
			return nomePessoas;
		} catch (EnderecoNaoEncontradoException neee) {
			throw new EscolaException(neee.getMessage());
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoas()
	 */	
	@SuppressWarnings("unchecked")
	public List<String> listaPessoas() throws EscolaException {
		List<String> listaNomePessoas = new ArrayList<String>();
		try{
			List<Pessoa> listaPessoas = pessoaRepository.listaTodos();
			for (Pessoa p : listaPessoas){
				listaNomePessoas.add(p.getNome());
			}
			return listaNomePessoas;
		}catch (NenhumaPessoaEncontradaException npee) {
			throw new EscolaException(npee.getMessage());
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasBairro(String)
	 */
	
	@SuppressWarnings("unchecked")
	public List<String> listaPessoasBairro(String nomeBairro)  throws EscolaException {
		List<String> listaNomes = new ArrayList<String>();
		
		try {
			List<Pessoa> listaPessoas = pessoaRepository.consultarPessoaBairro(nomeBairro);
			for (Pessoa p : listaPessoas) {
				listaNomes.add(p.getNome());
			}	
		} catch (NenhumaPessoaEncontradaException npee) {
			throw new EscolaException(npee.getMessage());
		}
		
		return listaNomes;
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasCidade(String)
	 */
	@SuppressWarnings("unchecked")
	public List<String> listaPessoasCidade(String nomeCidade) throws EscolaException{
		List<String> listaNomes = new ArrayList<String>();;
		try {
			List<Pessoa> listaPessoas = pessoaRepository.consultarPessoaCidade(nomeCidade);
			for (Pessoa p : listaPessoas){
				listaNomes.add(p.getNome());
			}	
		} catch (NenhumaPessoaEncontradaException npee) {
			throw new EscolaException(npee.getMessage());
		}
		
		return listaNomes;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasNome(String)
	 */
	@SuppressWarnings("unchecked")
	public List<String> listaPessoasNome(String nome) throws EscolaException{
		List<String> listaNomes = new ArrayList<String>();;
		try{
		List<Pessoa> listaPessoas = pessoaRepository.consultarPessoaNome(nome);
 		for (Pessoa p : listaPessoas){
			listaNomes.add(p.getNome());
		}
		}catch (NenhumaPessoaEncontradaException npee) {
			throw new EscolaException(npee.getMessage());
		}
		return listaNomes;
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasIdade(Date)
	 */
	@SuppressWarnings("unchecked")
	public List<String> listaPessoasIdade(Date dataNascimento) throws EscolaException {
		List<String> listaNomes = new ArrayList<String>();;
		try{
		List<Pessoa> listaPessoas = pessoaRepository.listaPessoasIdade(dataNascimento);
 		for (Pessoa p : listaPessoas){
			listaNomes.add(p.getNome());
		}
		return listaNomes;
		}catch (NenhumaPessoaEncontradaException npee) {
			throw new EscolaException(npee.getMessage());
		}
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasIdadeSexo(Date, String)
	 */
	@SuppressWarnings("unchecked")
	public List<String> listaPessoasIdadeSexo(Date dataNascimento, String sexo) throws EscolaException {
		List<String> listaNomes = new ArrayList<String>();
		try{
			List<Pessoa> listaPessoas = pessoaRepository.listaPessoasIdadeSexo(dataNascimento, sexo);
			for (Pessoa p : listaPessoas){
				listaNomes.add(p.getNome());
			}
		}catch (NenhumaPessoaEncontradaException npee) {
			throw new EscolaException(npee.getMessage());
		}
 		return listaNomes;
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasSexo(String)
	 */
	@SuppressWarnings("unchecked")
	public List<String> listaPessoasSexo(String sexo) throws EscolaException {
		List<String> listaNomes = new ArrayList<String>();
		try{
			List<Pessoa> listaPessoas = pessoaRepository.listaPessoasSexo(sexo);
	 		for (Pessoa p : listaPessoas){
				listaNomes.add(p.getNome());
			}
			return listaNomes;
		}catch (NenhumaPessoaEncontradaException npee) {
			throw new EscolaException(npee.getMessage());
		}

	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaPessoasTelefone(long)
	 */
	@SuppressWarnings("unchecked")
	public List<String> listaPessoasTelefone(long numeroTelefone) throws EscolaException {
		List<String> listaNomes = new ArrayList<String>();
		try{
		List<Pessoa> listaPessoas = pessoaRepository.consultarPessoaTelefone(numeroTelefone);
		for (Pessoa p : listaPessoas) {
			listaNomes.add(p.getNome());
		}
		}catch (NenhumaPessoaEncontradaException npe) {
			throw new EscolaException(npe.getMessage());
		}
		return listaNomes;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#listaTelefonesPessoa(Long)
	 */
	public List<String> listaTelefonesPessoa(Long pessoaId)  throws EscolaException {
		Pessoa pessoa = null;
		//atribui à referência pessoa,  a pessoa instanciada partir do parâmetro pessoaId
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
			List<String > listaTelefones = new ArrayList<String>();
			for (Telefone t : pessoa.getListaTelefones()){
				listaTelefones.add(t.getDDD() + " " +String.valueOf(t.getNumero()) +" "+ t.getTipo());
			}
			return listaTelefones;	
		} catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
		}
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#removePessoa(Long)
	 */
	public void removePessoa(Long pessoaId) throws EscolaException {
		
			try {
				pessoaRepository.remover(pessoaId); 
			} catch (EscolaException ee) {
				throw new EscolaException(ee.getMessage());
			}	
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setBairroRepository(BairroRepository)
	 */
	public void setBairroRepository(BairroRepository bairroRepository) {
		this.bairroRepository = bairroRepository;
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setCidadeRepository(CidadeRepository)
	 */
	public void setCidadeRepository(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setDocumentoRepository(DocumentoRepository)
	 */
	public void setDocumentoRepository(DocumentoRepository documentoRepository) {
		this.documentoRepository = documentoRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setEnderecoRepository(EnderecoRepository)
	 */
	public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setEmailRepository(EmailRepository)
	 */
	public void setEmailRepository(EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setEstadoRepository(EstadoRepository)
	 */
	public void setEstadoRepository(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setLogradouroRepository(LogradouroRepository)
	 */
	public void setLogradouroRepository(LogradouroRepository logradouroRepository) {
		this.logradouroRepository = logradouroRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setPaisRepository(PaisRepository)
	 */
	public void setPaisRepository(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setPessoaRepository(PessoaRepository)
	 */
	public void setPessoaRepository(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#setTelefoneRepository(TelefoneRepository)
	 */
	public void setTelefoneRepository(TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
	}
	/**
	 * @see PessoaService#toString(Long)
	 */
	@Override
	public String toString(Long pessoaId) throws PessoaNaoEncontradaException {
		
		Pessoa pessoa = null;
		try {
			pessoa = pessoaRepository.consultarPessoaId(pessoaId);
		} catch (PessoaNaoEncontradaException e) {
			throw new PessoaNaoEncontradaException();
		}
		return pessoa.toString();
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#verificaAdicaoDocumentoLista(Pessoa, Documento)
	 */
	public boolean verificaAdicaoDocumentoLista(Pessoa pessoa, Documento documento) {
		
		if ((pessoa instanceof PessoaFisica) && ((documento instanceof CPF)||(documento instanceof RG)))
			return true;
		else if ((pessoa instanceof PessoaJuridica) && (documento instanceof CNPJ))
			return true;
		else
		return true;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService#verificaDocumentoUnicoLista(Pessoa, Documento)
	 */
	public boolean verificaDocumentoUnicoLista(Pessoa pessoa, Documento documento) {

		if ((documento instanceof CPF) || (documento instanceof CNPJ)){
			for (Documento doc : pessoa.getListaDocumentos()){
				if ((doc instanceof CPF) || (doc instanceof CNPJ)){
					return false;
				}else 
					return true;
			}
		}
		return true;
	}
}
