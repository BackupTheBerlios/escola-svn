/*
 * PessoaNegocio.java
 *
 * Criado em 27 de Junho de 2007, 07:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.negocio;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException;
import java.util.List;

/**
 * Inteface para classe de Negócio do componente Pessoa
 * @author agaphbm
 */
public interface PessoaNegocio {
    /**
     * Valida regras dados no objeto pessoa e delega o mesmo para o repositorio
     * @param pessoa Instancia de Pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer excecao.
     */
    public void gravar(Pessoa pessoa) throws PessoaException;
    
    /**
     * Busca usuario no repositorio pelo id
     * @param id Intero longo contendo o id da Pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer excecao
     * @return uma instancia de pessoa
     */
    public Pessoa buscar(long id) throws PessoaNaoEncontradaException, PessoaException;
    
    /**
     * Busca todas as pessoas cadastradas no repositorio
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer excecao
     * @return Lista com todas as pessoas cadastradas no repositorio
     */
    public List buscarTodas() throws NenhumaPessoaEncontradaException, PessoaException;
    
    /**
     * Valida o que for necessario e remove uma pessoa do repositorio
     * @param id Inteiro longo contendo o id da Pessoa a ser removida
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorencia de qualquer Excecao
     */
    public void remover(long id) throws PessoaNaoEncontradaException, PessoaException;
}
