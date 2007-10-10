package br.ufg.inf.apsi.escola.componentes.admc.servico;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import java.util.List;

public interface TurmaService {
 
	public abstract void gravar(Turma turma)throws Exception;
	public abstract void excluir(String codigoTurma)throws Exception;
	public abstract List consultar()throws Exception;
	public abstract Turma consultar(String codigoTurma)throws Exception;
}
 
