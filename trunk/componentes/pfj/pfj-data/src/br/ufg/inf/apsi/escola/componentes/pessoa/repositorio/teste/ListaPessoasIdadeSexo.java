package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.teste;

import static br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.util.Util.formataData;

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
 * Classe definida para testar a listagem de pessoas por sexo e idade.
 * @author gilmar
 *
 */

public class ListaPessoasIdadeSexo {
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

		try {
			List<String> nomePessoas = ps.listaPessoasIdadeSexo(formataData("01/01/60"), "M");
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
