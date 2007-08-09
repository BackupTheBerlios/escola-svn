/*
 * PessoaFacade.java
 *
 * Created on 27 de Junho de 2007, 07:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.servico;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException;
import java.util.List;

/**
 *
 * @author agaphbm
 */
public interface PessoaService {
    /**
     * Chama metodos necessarios para gravacao de Pessoa no Componente
     * @param pessoa Instancia de pessoa a ser gravada no repositorio.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao
     */
    public void gravar(Pessoa pessoa) throws PessoaException;
    
    /**
     * Busca pessoa no repositorio
     * @return Instancia de Pessoa
     * @param id Inteiro longo contendo o identificador da pessoa.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException Quando a Pessoa nao e encontrada.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer outra excecao
     */
    public Pessoa buscar(int id) throws PessoaNaoEncontradaException, PessoaException;
    
    /**
     * Busca todas as pessoas cadastradas no repositorio
     * @return Lista de Pessoas
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException Quando nenhuma Pessoa e encontrada
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencie de qualquer outra excecao
     */
    public List buscarTodas() throws NenhumaPessoaEncontradaException, PessoaException;
    
    /**
     * Remove pessoa do Repositorio
     * @param id Inteiro longo contendo o id da pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException Quando a pessoas a ser removida nao existe.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer outra excecao
     */
    public void remover(int id) throws PessoaNaoEncontradaException, PessoaException;
}