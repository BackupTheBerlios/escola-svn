package br.ufg.inf.apsi.escola.servicos;

import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;

/**
 * Interface ServiceFactory que fornece métodos para que se possa obter as
 * referências de classe de outros componentes
 * 
 * @author leandro
 * 
 */
public interface ServiceFactory {
	/**
	 * Metodo para obter referencia para implementecao local de PessoaService
	 * 
	 * @return Instancia de implementacao de PessoaService
	 */
	PessoaService obtemPessoaService();

	/**
	 * Metodo para obter referencia para implementecao local de UsuarioService
	 * 
	 * @return Instancia de implementacao de UsuarioService
	 */
	UsuarioService obtemUsuarioService();
}