/*
 * EncodificadorPassword.java
 *
 * Created on 23 de Julho de 2007, 23:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.ie.acegi;

import org.acegisecurity.providers.encoding.BasePasswordEncoder;
import org.springframework.dao.DataAccessException;

/**
 * Implementacao de BasePasswordEncoder
 * @author Paulo Melo
 */
public class EncodificadorPassword extends BasePasswordEncoder {
    
    /** Creates a new instance of EncodificadorPassword */
    public EncodificadorPassword() {
    }

    /**
     * Codifica a string passada como parametro
     * @param string String a ser codificada
     * @param object 
     * @return String decodificada
     * @throws org.springframework.dao.DataAccessException 
     * @author Paulo Melo
     */
    public String encodePassword(String string, Object object) throws DataAccessException {
        return string;
    }

    /**
     * Verifica se um password � v�lido
     *
     * @param encPass String contendo password codificado
     * @param rawPass String contendo a senha digitada pelo usu�rio
     * @throws DataAccessException na ocorr�ncia de alguma exce��o
     * @return true se o password � v�lido e false caso o contr�rio
     * @author Paulo Melo
     */
    public boolean isPasswordValid(String encPass, String rawPass, Object object) throws DataAccessException {
        if(encodePassword(rawPass, null).equals(encPass)) {
            return true;
        }
        
        return false;
    }
}