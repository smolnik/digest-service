package net.adamsmolnik.digest.setup;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import net.adamsmolnik.digest.boundary.DigestService;

/**
 * @author ASmolnik
 *
 */
@ApplicationPath("/*")
public class RestSetup extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(DigestService.class);
        return classes;
    }
}
