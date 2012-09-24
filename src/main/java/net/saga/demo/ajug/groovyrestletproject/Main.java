/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.saga.demo.ajug.groovyrestletproject;

import org.restlet.Server;
import org.restlet.data.Protocol;

/**
 *
 * @author summers
 */
public class Main {
    
    public static void main(String args[]) throws Exception {
    
         new Server(Protocol.HTTP, 8111, BuggieApplication.class)
                .start();
        
    }
}
