/*
 * HibernatePessoaDAO.java
 *
 * Created on 27 de Junho de 2007, 08:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepositorio;
import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;


/**
 * Implementacao em JPA(Hibernate) para a classe de persistencia do componente Pessoa
 * @author agaphbm
 */
class HibernatePessoaRepositorio extends JpaDaoSupport implements PessoaRepositorio{
    
    /** Creates a new instance of HibernatePessoaDAO */
    public HibernatePessoaRepositorio() {
        
    }
    
    /**
     * Busca todas as Pessoas cadastradas no repositorio
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao
     * @return Lista contendo todas as pessoas cadastradas no repositorio
     */
    public List buscarTodas() throws NenhumaPessoaEncontradaException, PessoaException {
        List list = getJpaTemplate().find("from Pessoa");
        
        if(list.size()==0){
            throw new NenhumaPessoaEncontradaException();
        }
        
        return list;
    }
    
    /**
     * insere Pessoa no Repositorio
     * @param pessoa Instancia de pessoa a ser inserida no repositorio
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao
     */
    public void inserir(Pessoa pessoa) throws PessoaException {
        getJpaTemplate().persist(pessoa);
    }
    
    /**
     * Busca Pessoa pelo id
     * @param id Inteiro longo contendo o identificador da Pessoa
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualque Excecao
     * @return Instancia de pessoa
     */
    public Pessoa buscar(long id) throws PessoaNaoEncontradaException, PessoaException {
        Pessoa pessoa = (Pessoa) getJpaTemplate().find(Pessoa.class, Long.valueOf(id));
        
        if(pessoa==null) {
            throw new PessoaNaoEncontradaException();
        }
        
        return pessoa;
    }
    
    /**
     * Remove Pessoa do repositorio
     * @param id Inteiro longo contendo o id da Pessoa.
     * @throws br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException Na ocorrencia de qualquer Excecao.
     */
    public void remover(long id) throws PessoaNaoEncontradaException, PessoaException {
        getJpaTemplate().remove(buscar(id));
    }
}