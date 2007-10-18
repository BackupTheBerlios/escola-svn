/*
 * ListarPessoas.java
 *
 * Created on 25 de Julho de 2007, 11:11
 * Copyright paulo
 */
package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;
import java.util.LinkedList;
import java.util.List;
import javax.faces.component.html.HtmlDataTable;

public class ListarPessoas {
    
    private ServiceFactory serviceFactory = new LocalServiceFactory();
    private PessoaService pessoaService = serviceFactory.obtemPessoaService();
    
    private List pessoasCadastradas = new LinkedList();
    private HtmlDataTable htmlDataTable = new HtmlDataTable();
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListarPessoas() {
        
    }
    
    public String voltar() {
        return "voltar";
    }
    
    public List getPessoasCadastradas() {
        try{
            pessoasCadastradas = pessoaService.buscarTodas();
        } catch(PessoaException e){
            e.printStackTrace();
        } catch(NenhumaPessoaEncontradaException e){
            pessoasCadastradas = null;
        }
        
        return pessoasCadastradas;
    }
    
    public void setPessoasCadastradas(List pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }
    
    public void pageFirst() {
        getHtmlDataTable().setFirst(0);
    }
    
    public void pagePrevious() {
        getHtmlDataTable().setFirst(getHtmlDataTable().getFirst() - getHtmlDataTable().getRows());
    }
    
    public void pageNext() {
        getHtmlDataTable().setFirst(getHtmlDataTable().getFirst() + getHtmlDataTable().getRows());
    }
    
    public void pageLast() {
        int count = getHtmlDataTable().getRowCount();
        int rows = getHtmlDataTable().getRows();
        
        getHtmlDataTable().setFirst(count - ((count % rows != 0) ? count % rows : rows));
    }
    
    public HtmlDataTable getHtmlDataTable() {
        return htmlDataTable;
    }
    
    public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
        this.htmlDataTable = htmlDataTable;
    }
}