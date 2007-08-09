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
 * @author pmelo
 */
public class EncodificadorPassword extends BasePasswordEncoder {
    
    /** Creates a new instance of EncodificadorPassword */
    public EncodificadorPassword() {
    }

    /**
     * Codifica a string passada como parametro
     * @param string String a ser codificada
     * @param object 
     * @return String codificada
     * @throws org.springframework.dao.DataAccessException 
     */
    public String encodePassword(String string, Object object) throws DataAccessException {
        return string;
    }

    public boolean isPasswordValid(String encPass, String rawPass, Object object) throws DataAccessException {
        if(encodePassword(rawPass, null).equals(encPass)) {
            return true;
        }        
        
        return false;
    }    
}