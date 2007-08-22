package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.teste;

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
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
/**
 * Classe definida para testar a alteração de endereços.
 * @author gilmar
 *
 */
public class AlteraEndereco {
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

		String tipoEnderecoAtual = "COMERCIAL";
		String novoTipoEndereco = "RESIDENCIAL";
		String numeroAtual = "2565";
		String novoNumero = "2563";
		String complementoAtual = "qd. 09 lt. 03";
		String novoComplemento = "qd. 10 lt. 04";
		Integer cepAtual = 74093140;
		Integer novoCep = 74093140;
		
		try {
			ps.alteraEndereco(1L, complementoAtual, novoComplemento, numeroAtual, 
					novoNumero, cepAtual, novoCep, tipoEnderecoAtual, novoTipoEndereco);
		} catch (EscolaException ee) {
			ee.printStackTrace();
			ee.getCause().getMessage();
		}

		cpg.finaliza();
	}

}
