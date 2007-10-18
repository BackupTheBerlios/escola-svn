package br.ufg.inf.apsi.escola.componentes.relatorios.servico.local;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import br.ufg.inf.apsi.escola.componentes.relatorios.modelo.TurmaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.Consultas;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioNotasEFrequencias;
import br.ufg.inf.apsi.escola.componentes.relatorios.servico.RelatorioService;

public class LocalRelatorioService implements RelatorioService {

	RelatorioNotasEFrequencias relatorioNotasEFrequencias;
	Consultas consultas;
	
	public LocalRelatorioService(){}

	public void setRelatorioNotasEFrequencias(RelatorioNotasEFrequencias relatorioNotasEFrequencias) {
		this.relatorioNotasEFrequencias = relatorioNotasEFrequencias;
	}

	public void setConsultas(Consultas consultas) {
		this.consultas = consultas;
	}

	public void relatorioNFDosAlunosDeUmaTurma(String codigoTurma,OutputStream outputStream) throws FileNotFoundException,
			JRException, TurmaNaoEncontradaException {
				relatorioNotasEFrequencias.relatorioNFDosAlunosDeUmaTurma(codigoTurma, outputStream);
	}

	public List<HashMap<String,String>> consultaTurmasAluno(Long idPessoa) {
			return consultas.consultaTurmasDoAluno(idPessoa);
	}

}
