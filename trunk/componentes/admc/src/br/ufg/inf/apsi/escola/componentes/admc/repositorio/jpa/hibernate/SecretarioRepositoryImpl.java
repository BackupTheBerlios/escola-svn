/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepository;

/**
 * @author ailton
 *
 */
public class SecretarioRepositoryImpl extends JpaDaoSupport implements SecretarioRepository {

	public SecretarioRepositoryImpl(){}
	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepositorio#consultar(long)
	 */
	public Secretario consultar(long id) throws Exception {
Secretario secretario = (Secretario) getJpaTemplate().find(Secretario.class, Long.valueOf(id));
        
        if(secretario==null) {
            throw new Exception("Nenhum aluno encontrado!");
        }
        
        return secretario;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepositorio#consultar()
	 */
	public List<Secretario> consultar() throws Exception {
		 List<Secretario> list = getJpaTemplate().find("from Secretario");
	        
	        if(list.size()==0){
	            throw new Exception("Nenhum Secretario encontrado!");
	        }
	        
	        return list;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepositorio#consultar(java.lang.String)
	 */
	public Secretario consultar(String numeroMatricula) throws Exception {
		 Map<String, String> params = new HashMap<String, String>();
	        params.put("numeroMatricula",numeroMatricula);
	        return (Secretario) getJpaTemplate().findByNamedParams("from Secretario where numeroMatricula = :numeroMatricula", params).get(0);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepositorio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		getJpaTemplate().remove(this.consultar(id));

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario)
	 */
	public void gravar(Secretario secretario) throws Exception {
		getJpaTemplate().persist(secretario);

	}

}
