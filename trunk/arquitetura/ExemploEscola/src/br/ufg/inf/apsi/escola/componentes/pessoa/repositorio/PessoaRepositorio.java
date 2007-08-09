/*
 * PessoaDAO.java
 *
 * Created on 27 de Junho de 2007, 08:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException;
import java.util.List;

/**
 *
 * @author agaphbm
 */
public interface PessoaRepositorio {
    /**
     * Busca todas as Pessoas cadastradas no repositorio
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao
     * @return Lista contendo todas as pessoas cadastradas no repositorio
     */
    public List buscarTodas() throws NenhumaPessoaEncontradaException, PessoaException;
    
    /**
     * insere Pessoa no Repositorio
     * @param pessoa Instancia de pessoa a ser inserida no repositorio
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao
     */
    public void inserir(Pessoa pessoa) throws PessoaException;
    
    /**
     * Busca Pessoa pelo id
     * @param id Inteiro longo contendo o identificador da Pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualque Excecao
     * @return Instancia de pessoa
     */
    public Pessoa buscar(long id) throws PessoaNaoEncontradaException, PessoaException;
    
    /**
     * Remove Pessoa do repositorio
     * @param id Inteiro longo contendo o id da Pessoa.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao.
     */
    public void remover(long id) throws PessoaNaoEncontradaException, PessoaException;
}
