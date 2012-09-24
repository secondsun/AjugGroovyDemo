package net.saga.demo.ajug.groovyrestletproject;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.ChallengeScheme;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;
import org.restlet.security.Verifier;

/**
 * Hello world!
 */
public class BuggieApplication extends Application {
    private Verifier verifier;


    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public BuggieApplication() {
        MapVerifier verifier = new MapVerifier();
        verifier.getLocalSecrets().put("scott", "tiger".toCharArray());
        this.verifier = verifier;
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attachDefault(EchoPrincipalsResource.class);

        ChallengeAuthenticator authenticator = new ChallengeAuthenticator(
                getContext(), ChallengeScheme.HTTP_BASIC, "Basic Test");
        authenticator.setVerifier(verifier);

        authenticator.setNext(router);
        return authenticator;
    }
}
