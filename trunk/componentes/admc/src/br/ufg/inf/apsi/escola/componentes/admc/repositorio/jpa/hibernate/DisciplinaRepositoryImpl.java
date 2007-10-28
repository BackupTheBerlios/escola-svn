package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;


import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.DisciplinaRepository;
import org.springframework.orm.jpa.support.JpaDaoSupport;
/**
 * @author ailton
 *
 */
public class DisciplinaRepositoryImpl extends JpaDaoSupport implements DisciplinaRepository {

	public DisciplinaRepositoryImpl() {
	
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
		if (disciplina.getId() != -1) {
			getJpaTemplate().merge(disciplina);
		} else {
			getJpaTemplate().persist(disciplina);
		}
	}

	public List<Disciplina> consultar() throws Exception {
		List<Disciplina> list = getJpaTemplate().find("from Disciplina");
        
        if(list.size()==0){
            throw new Exception("Nenhuma Disciplina encontrada!");
        }
        
        return list;
	}

}
