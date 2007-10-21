package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumDocumentoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.RemocaoDocumentoException;


/**
 * Interface definida para gerenciar a persistência de documentos.
 * @author gilmar
 *
 */

public interface DocumentoRepository {
	/**
	 * Opração definida para incluir um documento no repositório.
	 * @param documento
	 * @return boolean
	 * @throws DocumentoCadastradoException
	 */
	boolean incluir(Documento documento) throws DocumentoCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um documento do repositório.
	 * @param numeroDocumento
	 * @return boolean
	 * @throws RemocaoDocumentoException
	 */
	boolean remover(String numeroDocumento) throws RemocaoDocumentoException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de um documento.
	 * @param documento
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean salvar(Documento documento) throws EscolaException;
	/**
	 * Operação definida para consultar um documento, a partir do seu número.
	 * @param numeroDocumento
	 * @return {@link Documento}
	 * @throws DocumentoNaoEncontradoException
	 */
	Documento consultar(String numeroDocumento) throws DocumentoNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um documento, a partir do seu id.
	 * @param documentoId
	 * @return {@link Documento}
	 * @throws DocumentoNaoEncontradoException
	 */
	Documento carregar(Long documentoId) throws DocumentoNaoEncontradoException;
	/**
	 * Operação definida para listar os documentos cadastrados.
	 * @return List<Documento> 
	 * @throws NenhumDocumentoEncontradoException
	 */
	List<Documento> listaTodos() throws NenhumDocumentoEncontradoException;
	
}
