/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.ProgramaDisciplinaRepositorio;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author ailton
 *
 */
public class ProgramaDisciplinaRepositorioImpl extends JpaDaoSupport implements
		ProgramaDisciplinaRepositorio {

	public ProgramaDisciplinaRepositorioImpl() {
	
	}
	
	public List<ProgramaDisciplina> consultar() throws Exception {
		 List<ProgramaDisciplina> list = getJpaTemplate().find("from ProgramaDisciplina");
	        
	        if(list.size()==0){
	            throw new Exception("Nenhum Programa de Disciplina encontrado!");
	        }
	        
	        return list;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.ProgramaDisciplinaRepositorio#consultar(long)
	 */
	public ProgramaDisciplina consultar(long id) throws Exception {
ProgramaDisciplina programa = (ProgramaDisciplina) getJpaTemplate().find(ProgramaDisciplina.class, Long.valueOf(id));
        
        if(programa==null) {
            throw new Exception("Nenhum Programa de Disciplina encontrado!");
        }
        
        return programa;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.ProgramaDisciplinaRepositorio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.ProgramaDisciplinaRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina)
	 */
	public void gravar(ProgramaDisciplina programa) throws Exception {
		getJpaTemplate().persist(programa);

	}

}
