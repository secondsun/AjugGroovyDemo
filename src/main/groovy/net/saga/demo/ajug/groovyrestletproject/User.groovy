/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.saga.demo.ajug.groovyrestletproject

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode


/**
 *
 * @author summers
 */
@CompileStatic
@EqualsAndHashCode
class User {
    char[] password
    String username
}

