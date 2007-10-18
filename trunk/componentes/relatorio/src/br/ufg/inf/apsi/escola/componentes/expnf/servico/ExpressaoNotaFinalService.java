package br.ufg.inf.apsi.escola.componentes.expnf.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;

public interface ExpressaoNotaFinalService {
	public double calculaNotaFinal(List<Nota> listaNotas, String expressao);
}
