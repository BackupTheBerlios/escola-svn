/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepositorio;



/**
 * @author ailton
 *
 */
public class AlunoRepositorioImpl extends JpaDaoSupport implements AlunoRepositorio {

	
	public AlunoRepositorioImpl(){}
	
	
	
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
		    Map<String, String> params = new HashMap<String, String>();
	        params.put("numeroMatricula",numeroMatricula);
	        return (Aluno) getJpaTemplate().findByNamedParams("from Aluno where numeroMatricula = :numeroMatricula", params).get(0);

	}

}
