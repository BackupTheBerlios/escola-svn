package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;


import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.DisciplinaRepositorio;
import org.springframework.orm.jpa.support.JpaDaoSupport;
/**
 * @author ailton
 *
 */
public class DisciplinaRepositorioImpl extends JpaDaoSupport implements DisciplinaRepositorio {

	public DisciplinaRepositorioImpl() {
	
	}
	
	public Disciplina consultar(long id) throws Exception {
		Disciplina disciplina = (Disciplina) getJpaTemplate().find(Disciplina.class,
				Long.valueOf(id));

		if (disciplina == null) {
			throw new Exception("Nenhuma disciplina encontrada!");
		}

		return disciplina;
	}

	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	public void gravar(Disciplina disciplina) throws Exception {
		getJpaTemplate().persist(disciplina);

	}

}
