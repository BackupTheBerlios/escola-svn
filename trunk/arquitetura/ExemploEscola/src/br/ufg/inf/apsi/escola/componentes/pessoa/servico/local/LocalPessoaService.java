/*
 * PessoaFacade.java
 *
 * Created on 27 de Junho de 2007, 07:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.servico.local;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaNegocio;
import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import java.util.List;

/**
 * implementacao Local da classe de servico do componente Pessoa
 * @author agaphbm
 */
public class LocalPessoaService implements PessoaService {
    /**
     * Referencia implementacao da classe de Negocio do componente Pessoa
     */
    private PessoaNegocio pessoaNegocio = null;
    
    /**
     * Cria uma nova instancia de PessoaServico
     * @param pessoaNegocio Referencia para implementacao da classe de Negocio do componente Pessoa
     */
    public LocalPessoaService(PessoaNegocio pessoaNegocio) {
        this.pessoaNegocio = pessoaNegocio;
    }
    
    /**
     * Chama metodos necessarios para gravacao de Pessoa no Componente
     * @param pessoa Instancia de pessoa a ser gravada no repositorio.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao
     */
    public void gravar(Pessoa pessoa) throws PessoaException {
        pessoaNegocio.gravar(pessoa);
    }
    
    /**
     * Busca pessoa no repositorio
     * @return Instancia de Pessoa
     * @param id Inteiro longo contendo o identificador da pessoa.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException Quando a Pessoa nao e encontrada.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer outra excecao
     */
    public Pessoa buscar(int id) throws PessoaNaoEncontradaException, PessoaException {
        return pessoaNegocio.buscar(id);
    }
    
    /**
     * Busca todas as pessoas cadastradas no repositorio
     * @return Lista de Pessoas
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException Quando nenhuma Pessoa e encontrada
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencie de qualquer outra excecao
     */
    public List buscarTodas() throws NenhumaPessoaEncontradaException, PessoaException {
        return pessoaNegocio.buscarTodas();
    }
    
    /**
     * Remove pessoa do Repositorio
     * @param id Inteiro longo contendo o id da pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException Quando a pessoas a ser removida nao existe.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer outra excecao
     */
    public void remover(int id) throws PessoaNaoEncontradaException, PessoaException {
        pessoaNegocio.remover(id);
    }
}