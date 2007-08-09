/*
 * PessoaNegocioBean.java
 *
 * Created on 27 de Junho de 2007, 08:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.negocio.bean;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaNegocio;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepositorio;
import java.util.List;

/**
 * Implementacao em Bean da classe de Negocio do componente Pessoa
 * @author agaphbm
 */
class PessoaNegocioBean implements PessoaNegocio {
    /**
     * Referencia a implementacao da classe de persistencia do componente Pessoa
     */
    private PessoaRepositorio pessoaRepositorio = null;
    
    /**
     * Cria uma nova instancia de PessoaNegocioBean
     * @param pessoaRepositorio Referencia para a implementacao da classe de persistencia do componente Pessoa
     */
    public PessoaNegocioBean(PessoaRepositorio pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }
    
    /**
     * Valida regras dados no objeto pessoa e delega o mesmo para o repositorio
     * @param pessoa Instancia de Pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer excecao.
     */
    public void gravar(Pessoa pessoa) throws PessoaException {
    	pessoaRepositorio.inserir(pessoa);
    }
    
    /**
     * Busca usuario no repositorio pelo id
     * @param id Intero longo contendo o id da Pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer excecao
     * @return uma instancia de pessoa
     */
    public Pessoa buscar(long id) throws PessoaNaoEncontradaException, PessoaException {
        return pessoaRepositorio.buscar(id);
    }
    
    /**
     * Busca todas as pessoas cadastradas no repositorio
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer excecao
     * @return Lista com todas as pessoas cadastradas no repositorio
     */
    public List buscarTodas() throws NenhumaPessoaEncontradaException, PessoaException {
        return pessoaRepositorio.buscarTodas();
    }
    
    /**
     * Valida o que for necessario e remove uma pessoa do repositorio
     * @param id Inteiro longo contendo o id da Pessoa a ser removida
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorencia de qualquer Excecao
     */
    public void remover(long id) throws PessoaNaoEncontradaException, PessoaException {
        pessoaRepositorio.remover(id);
    }
}