/*
 * CadastrarPessoa.java
 *
 * Created on 25 de Julho de 2007, 11:06
 * Copyright paulo
 */
package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CadastrarPessoa  {
    private String nome = null;
    
    private PessoaService pessoaService = null;
    private LocalServiceFactory localServiceFactory = null;
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CadastrarPessoa() {
        localServiceFactory = new LocalServiceFactory();
        pessoaService = localServiceFactory.obtemPessoaService();
    }
    
    public String voltar() {
        
        return "voltar";
    }
    
    public String gravar() {
        Pessoa pessoa = new Pessoa();
        
        try {
            pessoa.setNome(nome);
            pessoaService.gravar(pessoa);
        } catch(PessoaException e){
            e.printStackTrace();
        }
        nome = "";
        
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }        
}