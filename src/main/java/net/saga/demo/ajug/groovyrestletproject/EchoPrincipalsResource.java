package net.saga.demo.ajug.groovyrestletproject;

/**
 * Created with IntelliJ IDEA.
 * User: summers
 * Date: 9/23/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */

import org.restlet.data.CharacterSet;
import org.restlet.data.Language;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.restlet.security.Role;

import java.security.Principal;

/**
 * @author Bruno Harbulot (bruno/distributedmatter.net)
 */
public class EchoPrincipalsResource extends ServerResource {
    @Get("txt")
    public Representation echoPrincipals() throws ResourceException {
        StringBuilder sb = new StringBuilder("* User: ");
        sb.append(getClientInfo().getUser());
        sb.append("\n");

        sb.append("* Roles: \n");
        for (Role role : getClientInfo().getRoles()) {
            sb.append("  - ");
            sb.append(role.getName());
            sb.append("\n");
        }

        sb.append("* Principals: \n");
        for (Principal principal : getClientInfo().getPrincipals()) {
            sb.append("  - ");
            sb.append(principal.getName());
            sb.append(" (");
            sb.append(principal.getClass());
            sb.append(")\n");
        }

        Representation rep = new StringRepresentation(sb, MediaType.TEXT_PLAIN,
                Language.ALL, CharacterSet.UTF_8);
        return rep;
    }
}
