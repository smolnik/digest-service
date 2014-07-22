package net.adamsmolnik.digest.setup;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import net.adamsmolnik.digest.boundary.DigestActivityImpl;
import net.adamsmolnik.digest.control.Digest;
import net.adamsmolnik.setup.ActivityLauncher;

/**
 * @author ASmolnik
 *
 */
@WebListener("digestActivitySetup")
public class WebSetup implements ServletContextListener{

    @Inject
    private Digest digest;

    @Inject
    private ActivityLauncher al;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        al.register(new DigestActivityImpl(digest));
        //sal.launch();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        al.shutdown();
    }

}
