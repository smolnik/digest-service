package net.adamsmolnik.setup.digest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import net.adamsmolnik.boundary.digest.DigestActivityImpl;
import net.adamsmolnik.control.digest.Digest;
import net.adamsmolnik.setup.ActivityLauncher;

/**
 * @author ASmolnik
 *
 */
//@Startup
//@Singleton
public class EjbSetup {

    //@Inject
    private Digest digest;

    //@Inject
    private ActivityLauncher al;

    //@PostConstruct
    private void init() {
        al.register(new DigestActivityImpl(digest));
        al.launch();
    }

    //@PreDestroy
    private void destroy() {
        al.shutdown();
    }

}
