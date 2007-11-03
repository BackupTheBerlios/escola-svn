package br.ufg.inf.apsi.escola.componentes.expnf.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.expnf.servico.ExpressaoNotaService;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;

public class LocalExpressaoNotaService implements
		ExpressaoNotaService {

	public double calculaNotaFinal(List<Nota> listaNotas, String expressao) {
		return 9.5599;
	}

}
