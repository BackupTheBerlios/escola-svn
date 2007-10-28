package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.CursoRepository;

/**
 * @author ailton
 * 
 */
public class CursoRepositoryImpl extends JpaDaoSupport implements
		CursoRepository {

	public CursoRepositoryImpl() {

	}

	public Curso consultar(long id) throws Exception {
		Curso curso = (Curso) getJpaTemplate().find(Curso.class,
				Long.valueOf(id));

		if (curso == null) {
			throw new Exception("Nenhum Curso encontrado!");
		}

		return curso;
	}

	public List<Curso> consultar() throws Exception {
		List<Curso> list = getJpaTemplate().find("from Curso");

		if (list.size() == 0) {
			throw new Exception("Nenhum Curso encontrado!");
		}

		return list;

	}

	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	public void gravar(Curso curso) throws Exception {
		if (curso.getId() != 0 || curso.getId() != -1) {
			getJpaTemplate().merge(curso);
		} else {
			getJpaTemplate().persist(curso);
		}
	}

}
