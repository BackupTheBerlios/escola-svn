/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.TurmaRepositorio;
import org.springframework.orm.jpa.support.JpaDaoSupport;
/**
 * @author ailton
 *
 */
public class TurmaRepositorioImpl extends JpaDaoSupport implements TurmaRepositorio {

	
	public TurmaRepositorioImpl() {
	
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.TurmaRepositorio#consultar()
	 */
	public List<Turma> consultar() throws Exception {
		List<Turma> list = getJpaTemplate().find("from Turma");
        
        if(list.size()==0){
            throw new Exception("Nenhuma Turma econtrada!");
        }
        
        return list;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.TurmaRepositorio#consultar(java.lang.String)
	 */
	public Turma consultar(String codigoTurma) throws Exception {
Turma turma = (Turma) getJpaTemplate().find(Turma.class, String.valueOf(codigoTurma));
        
        if(turma==null) {
            throw new Exception("Nenhuma Turma encontrada!");
        }
        
        return turma;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.TurmaRepositorio#excluir(java.lang.String)
	 */
	public void excluir(String codigoTurma) throws Exception {
		getJpaTemplate().remove(this.consultar(codigoTurma));

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.TurmaRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma)
	 */
	public void gravar(Turma turma) throws Exception {
		getJpaTemplate().persist(turma);

	}

}
