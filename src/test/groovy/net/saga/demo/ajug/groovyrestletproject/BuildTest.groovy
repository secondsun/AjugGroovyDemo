package net.saga.demo.ajug.groovyrestletproject

import org.junit.Assert
import org.junit.Test
import org.restlet.Request
import org.restlet.Response
import org.restlet.Restlet
import org.restlet.data.ChallengeResponse
import org.restlet.security.ChallengeAuthenticator
import org.restlet.security.Verifier

/**
 * Created with IntelliJ IDEA.
 * User: summers
 * Date: 9/22/12
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */

class BuildTest {
    @Test
    void pass() {
        Assert.assertTrue(true);
    }


    @Test
    void createInboundRootHappens() {
        BuggieApplication app = new BuggieApplication()

        Restlet result
        result = app.createInboundRoot();

        Assert.assertTrue(result instanceof ChallengeAuthenticator)

    }

    @Test
    void createInboundRootHasSecurity() {
        BuggieApplication app = new BuggieApplication()

        ChallengeAuthenticator result
        result = app.createInboundRoot();

        def identifier = "scott"
        def secret = "tiger".toCharArray()

        def challengeResponse = ['getIdentifier' : {_->identifier},
                                 'getSecret' : {_->secret}] as ChallengeResponse

        def request = ['getChallengeResponse' : challengeResponse] as Request
        def response = ['getClientInfo' : {['setUser' : {}]}] as Response

        Assert.assertEquals(Verifier.RESULT_VALID, result.verifier.verify(request, response))
    }


}