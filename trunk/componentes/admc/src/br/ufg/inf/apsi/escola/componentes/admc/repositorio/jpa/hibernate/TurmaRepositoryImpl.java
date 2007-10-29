/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.TurmaRepository;

/**
 * @author ailton
 * 
 */
public class TurmaRepositoryImpl extends JpaDaoSupport implements
		TurmaRepository {

	public TurmaRepositoryImpl() {

	}

	public List<Turma> consultar() throws Exception {
		List<Turma> list = getJpaTemplate().find("from Turma");

		if (list.size() == 0) {
			throw new Exception("Nenhuma Turma econtrada!");
		}

		return list;
	}

	public Turma consultar(long id) throws Exception {
		Turma turma = (Turma) getJpaTemplate().find(Turma.class,
				Long.valueOf(id));

		if (turma == null) {
			throw new Exception("Nenhuma Turma encontrada!");
		}

		return turma;
	}

	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	public void gravar(Turma turma) throws Exception {
		if (turma.getId() == 0) {
			getJpaTemplate().persist(turma);
		} else {
			getJpaTemplate().merge(turma);
		}
		
	}

}
