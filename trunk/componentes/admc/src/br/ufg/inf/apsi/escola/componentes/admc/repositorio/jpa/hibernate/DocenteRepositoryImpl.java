/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;

/**
 * @author ailton
 * 
 */
public class DocenteRepositoryImpl extends JpaDaoSupport implements
		br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepository {

	public DocenteRepositoryImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#consultar(long)
	 */
	public Docente consultar(long id) throws Exception {
		Docente docente = (Docente) getJpaTemplate().find(Docente.class,
				Long.valueOf(id));

		if (docente == null) {
			throw new Exception("Nenhum Docente encontrado!");
		}

		return docente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#consultar()
	 */
	public List<Docente> consultar() throws Exception {
		List<Docente> list = getJpaTemplate().find("from Docente");

		if (list.size() == 0) {
			throw new Exception("Nenhum Docente encontrado!");
		}

		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente)
	 */
	public void gravar(Docente docente) throws Exception {
		getJpaTemplate().persist(docente);

	}

	public Docente consultarPorMatricula(String matricula) throws Exception {
		Docente docente = (Docente) getJpaTemplate().find(
				"from Docente docente where docente.matricula = '" + matricula
						+ "'");

		if (docente == null) {
			throw new Exception("Nenhum Docente encontrado!");
		}

		return docente;
	}
}
