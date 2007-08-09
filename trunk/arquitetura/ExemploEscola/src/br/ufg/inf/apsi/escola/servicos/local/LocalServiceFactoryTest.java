package br.ufg.inf.apsi.escola.servicos.local;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;

public class LocalServiceFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testObtemPessoaService() {
        ServiceFactory serviceFactory = new LocalServiceFactory();
        
        //PessoaService expResult = null;
        PessoaService result = serviceFactory.obtemPessoaService();
        try {
            Pessoa pessoa = new Pessoa("Teste " + (int)(Math.random() * 100));
            result.gravar(pessoa);
            
            List resultado = result.buscarTodas();
            
            for(int i = 0; i<resultado.size(); i++){
                System.out.println(((Pessoa)resultado.get(i)).getNome());
            }
        } catch(NenhumaPessoaEncontradaException e){
            System.out.println(e.getMessage());
        } catch(PessoaException e) {
            System.out.println(e.getMessage());
        }
	}
}