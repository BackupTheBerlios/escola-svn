/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepository;



/**
 * @author ailton
 *
 */
public class AlunoRepositoryImpl extends JpaDaoSupport implements AlunoRepository {

	
	public AlunoRepositoryImpl(){}
	
	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepositorio#consultar(long)
	 */
	public Aluno consultar(long id) throws Exception {
		Aluno aluno = getJpaTemplate().find(Aluno.class, Long.valueOf(id));
        
        if(aluno==null) {
            throw new Exception("Nenhum aluno encontrado!");
        }
        
        return aluno;

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepositorio#consultar()
	 */
	public List<Aluno> consultar() throws Exception {
		 List<Aluno> list = getJpaTemplate().find("from Aluno");
	        
	        if(list.size()==0){
	            throw new Exception("Nenhum Aluno encontrado!");
	        }
	        
	        return list;

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepositorio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno)
	 */
	public void gravar(Aluno aluno) throws Exception {
		if (aluno.getId() != -1) {
			getJpaTemplate().merge(aluno);
		} else {
			getJpaTemplate().persist(aluno);
		}


	}



	public Aluno consultar(String numeroMatricula) throws Exception {
		    
	        return (Aluno) getJpaTemplate().find("select a from Aluno a where a.getNumeroMatricula = ?1", numeroMatricula);

	}

}
