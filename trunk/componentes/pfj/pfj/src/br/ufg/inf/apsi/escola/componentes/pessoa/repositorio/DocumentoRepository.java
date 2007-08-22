package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.DocumentoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.DocumentoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumDocumentoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.RemocaoDocumentoException;


/**
 * Interface definida para gerenciar a persistência de documentos.
 * @author gilmar
 *
 */

public interface DocumentoRepository {
	/**
	 * Opração definida para incluir um documento no repositório.
	 * @param doc
	 * @return
	 * @throws DocumentoCadastradoException
	 */
	boolean incluir(Documento doc) throws DocumentoCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um documento do repositório.
	 * @param numero
	 * @return
	 * @throws RemocaoDocumentoException
	 */
	boolean remover(String numero) throws RemocaoDocumentoException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de um documento.
	 * @param doc
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Documento doc) throws EscolaException;
	/**
	 * Operação definida para consultar um documento, a partir do seu número.
	 * @param numero
	 * @return
	 * @throws DocumentoNaoEncontradoException
	 */
	Documento consultar(String numero) throws DocumentoNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um documento, a partir do seu id.
	 * @param documentoId
	 * @return
	 * @throws DocumentoNaoEncontradoException
	 */
	Documento carregar(Long documentoId) throws DocumentoNaoEncontradoException;
	/**
	 * Operação definida para listar os documentos cadastrados.
	 * @return
	 * @throws NenhumDocumentoEncontradoException
	 */
	List<Documento> listaTodos() throws NenhumDocumentoEncontradoException;
	
}
