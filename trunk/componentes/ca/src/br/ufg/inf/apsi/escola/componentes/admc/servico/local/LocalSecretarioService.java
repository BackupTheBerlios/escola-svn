package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService;

public class LocalSecretarioService implements SecretarioService {

	@Override
	public boolean isSecretario(Long idPessoa) {
		return true;
	}

}
