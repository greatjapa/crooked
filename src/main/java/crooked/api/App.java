package crooked.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * The Application class.
 *
 * @author Marcelo Oikawa
 */
public class App extends Application<Conf> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "crooked-app";
    }

    @Override
    public void initialize(Bootstrap<Conf> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Conf conf, Environment environment) throws Exception {
        DefaultHealthCheck healthCheck = new DefaultHealthCheck();
        environment.healthChecks().register("default", healthCheck);

        DataResource dataResource = new DataResource(conf.getStorageImpl(), conf.getAlgorithmImpl());
        environment.jersey().register(dataResource);
    }
}
