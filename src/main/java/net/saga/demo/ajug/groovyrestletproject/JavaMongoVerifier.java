/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.saga.demo.ajug.groovyrestletproject;

import org.restlet.security.LocalVerifier;

/**
 *
 * @author summers
 */
public class JavaMongoVerifier extends LocalVerifier {

    @Override
    public char[] getLocalSecret(String identifier) {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
