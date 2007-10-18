package br.ufg.inf.apsi.escola.componentes.relatorios.negocio;

import java.util.HashMap;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;

public interface Consultas {

	public void setTurmaService(TurmaService turmaService);
	public List<HashMap<String,String>> consultaTurmasDoAluno(Long idPessoa);
	public List<HashMap<String,String>> consultaTurmasDoDocente(String matriculaDocente);
}
