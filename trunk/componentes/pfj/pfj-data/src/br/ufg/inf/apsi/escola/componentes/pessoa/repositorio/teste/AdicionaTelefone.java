package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.teste;

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
 * Classe definida para testar a adição de telefones.
 * @author gilmar
 *
 */
public class AdicionaTelefone {
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]){
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

		short ddd = 62;
		long numero = 96088434;
		try {
			ps.adicionaTelefone(1L, ddd, numero, "CELULAR");
		} catch (EscolaException ee) {
			ee.printStackTrace();
			ee.getCause().getMessage();
		} 

		cpg.finaliza();
	}

}
