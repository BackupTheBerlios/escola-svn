package br.ufg.inf.apsi.escola.componentes.relatorios.servico;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.relatorios.modelo.TurmaNaoEncontradaException;

import net.sf.jasperreports.engine.JRException;

public interface RelatorioService {
	public void relatorioNFDosAlunosDeUmaTurma(String codigoTurma, OutputStream outputStream) throws FileNotFoundException, JRException, TurmaNaoEncontradaException;
	public List<HashMap<String,String>> consultaTurmasAluno(Long idPessoa);
}
