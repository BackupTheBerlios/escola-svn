package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.teste;



import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaServiceImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.BairroRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.CidadeRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.CriaPersistenciaGeral;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.DocumentoRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.EmailRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.EnderecoRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.EstadoRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.LogradouroRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.PaisRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.PessoaRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate.TelefoneRepositoryImpl;

/**
 * 
 * @author gilmar
 *
 */
public class ListaPessoasEndereco {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CriaPersistenciaGeral cpg = new CriaPersistenciaGeral();
		PessoaService ps = new PessoaServiceImpl();
		ps.setBairroRepository(new BairroRepositoryImpl());
		ps.setCidadeRepository(new CidadeRepositoryImpl());
		ps.setDocumentoRepository(new DocumentoRepositoryImpl());
		ps.setEmailRepository(new EmailRepositoryImpl());
		ps.setEnderecoRepository(new EnderecoRepositoryImpl());
		ps.setEstadoRepository(new EstadoRepositoryImpl());
		ps.setLogradouroRepository(new LogradouroRepositoryImpl());
		ps.setPaisRepository(new PaisRepositoryImpl());
		ps.setPessoaRepository(new PessoaRepositoryImpl());
		ps.setTelefoneRepository(new TelefoneRepositoryImpl());

		try {
			List<String> nomePessoas = ps.listaPessoasEndereco("SR 17", "qd. 34 lt. 13A", "S/N");
			for (String s : nomePessoas){
				System.out.println(s);
			}
		} catch (EscolaException ee) {
			ee.printStackTrace();
			ee.getCause().getMessage();
		}

		cpg.finaliza();
	}

}


