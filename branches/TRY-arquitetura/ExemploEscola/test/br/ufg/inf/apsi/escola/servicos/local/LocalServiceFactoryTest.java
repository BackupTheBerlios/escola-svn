/*
 * LocalServiceFactoryTest.java
 * JUnit based test
 *
 * Created on 6 de Outubro de 2007, 14:44
 */

package br.ufg.inf.apsi.escola.servicos.local;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import junit.framework.*;
import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import java.util.ArrayList;

/**
 *
 * @author pmelo
 */
public class LocalServiceFactoryTest extends TestCase {
    
    public LocalServiceFactoryTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
    }
    
    protected void tearDown() throws Exception {
    }
    
    /**
     * Teste do método obtemPessoaService, da classe br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory.
     */
    public void testObtemPessoaService() {
        System.out.println("obtemPessoaService");
        
        LocalServiceFactory instance = new LocalServiceFactory();
        
        PessoaService result = instance.obtemPessoaService();
                
        try {
            result.gravar(new Pessoa("Teste transacional 38"));
            ArrayList<Pessoa> lista = (ArrayList<Pessoa>) result.buscarTodas();
            
            for(Pessoa pessoa : lista) {
                System.out.println(pessoa);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}