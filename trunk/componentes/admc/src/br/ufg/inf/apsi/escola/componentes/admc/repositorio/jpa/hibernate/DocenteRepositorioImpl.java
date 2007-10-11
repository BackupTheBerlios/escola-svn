/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author ailton
 *
 */
public class DocenteRepositorioImpl extends JpaDaoSupport implements
		br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio {

	public DocenteRepositorioImpl() {
	
	}
	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#consultar(long)
	 */
	public Docente consultar(long id) throws Exception {
Docente docente = (Docente) getJpaTemplate().find(Docente.class, Long.valueOf(id));
        
        if(docente==null) {
            throw new Exception("Nenhum Docente encontrado!");
        }
        
        return docente;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#consultar()
	 */
	public List<Docente> consultar() throws Exception {
		List<Docente> list = getJpaTemplate().find("from Docente");
        
        if(list.size()==0){
            throw new Exception("Nenhum Docente encontrado!");
        }
        
        return list;

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente)
	 */
	public void gravar(Docente docente) throws Exception {
		getJpaTemplate().persist(docente);

	}

}