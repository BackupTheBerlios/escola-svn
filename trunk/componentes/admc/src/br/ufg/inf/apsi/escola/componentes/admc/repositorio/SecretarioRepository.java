package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario;

public interface SecretarioRepository {

	
	public abstract void gravar(Secretario secretario) throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract Secretario consultar(long id)throws Exception ;
	public abstract List<Secretario> consultar() throws Exception;
	public abstract Secretario consultar(String numeroMatricula) throws Exception;
}
