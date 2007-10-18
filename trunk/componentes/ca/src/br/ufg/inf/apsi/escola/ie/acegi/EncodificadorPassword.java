package br.ufg.inf.apsi.escola.ie.acegi;

import org.acegisecurity.providers.encoding.BasePasswordEncoder;
import org.springframework.dao.DataAccessException;

/**
 * Implementacao de BasePasswordEncoder
 * 
 * @author leandro
 */
public class EncodificadorPassword extends BasePasswordEncoder {

	/** Creates a new instance of EncodificadorPassword */
	public EncodificadorPassword() {
	}

	/**
	 * Codifica a string passada como parametro
	 * 
	 * @param string
	 *            String a ser codificada
	 * @param object
	 * @return String decodificada
	 * @throws org.springframework.dao.DataAccessException
	 */
	public String encodePassword(String string, Object object)
			throws DataAccessException {
		return string;
	}

	/**
	 * Verifica se um password é válido
	 * 
	 * @param encPass
	 *            String contendo password codificado
	 * @param rawPass
	 *            String contendo a senha digitada pelo usuário
	 * @throws DataAccessException
	 *             na ocorrência de alguma exceção
	 * @return true se o password é válido e false caso o contrário
	 */
	public boolean isPasswordValid(String encPass, String rawPass, Object object)
			throws DataAccessException {
		if (encodePassword(rawPass, null).equals(encPass)) {
			return true;
		}
		return false;
	}
}
