package br.ufg.inf.apsi.escola.componentes.relatorios.negocio;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import net.sf.jasperreports.engine.JRException;
import br.ufg.inf.apsi.escola.componentes.relatorios.modelo.TurmaNaoEncontradaException;

public interface RelatorioNotasEFrequencias {

	public void relatorioNFDosAlunosDeUmaTurma(String codigoTurma, OutputStream outputStream) throws FileNotFoundException, JRException, TurmaNaoEncontradaException;
	public OutputStream relatorioNFDeUmAlunoEmTodasTurmas(Long idPessoa);
	public OutputStream relatorioNFDeUmAlunoEmUmaTurma(Long idPessoa,String codigoTurma);

}
