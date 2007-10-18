package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.Consultas;

public class ConsultasBean implements Consultas {

	private TurmaService turmaService;

	public ConsultasBean() {
		turmaService = null;
	}

	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	public List<HashMap<String, String>> consultaTurmasDoAluno(Long idPessoa) {
		return converteList(turmaService.consultarTurmasAluno(idPessoa));
	}

	public List<HashMap<String, String>> consultaTurmasDoDocente(String matriculaDocente) {
		return converteList(turmaService.consultarTurmasDocente(matriculaDocente));
	}

	private List<HashMap<String, String>> converteList(List<Turma> listTurma) {
		List<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> tabelaHash;
		Turma turma;

		for (int indice = 0; indice < listTurma.size(); indice++) {
			tabelaHash = new HashMap<String, String>();
			turma = listTurma.get(indice);
			tabelaHash.put("codigoTurma", turma.getCodigoTurma());
			tabelaHash.put("codigoDisciplina", turma.getDisciplina()
					.getCodigo());
			tabelaHash.put("nomeDisciplina", turma.getDisciplina().getNome());
			lista.add(tabelaHash);
		}
		return lista;
	}

}
