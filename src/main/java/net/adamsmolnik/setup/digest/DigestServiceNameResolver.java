package net.adamsmolnik.setup.digest;

import javax.inject.Singleton;
import net.adamsmolnik.setup.ServiceNameResolver;

/**
 * @author ASmolnik
 *
 */
@Singleton
public class DigestServiceNameResolver implements ServiceNameResolver {

    @Override
    public String getServiceName() {
        return "digest-service";
    }

}
