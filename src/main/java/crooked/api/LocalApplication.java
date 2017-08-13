package crooked.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LocalApplication extends Application<LocalConfiguration> {
    public static void main(String[] args) throws Exception {
        new LocalApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<LocalConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(LocalConfiguration localConfiguration, Environment environment) throws Exception {
        DataResource dataResource = new DataResource();
        environment.jersey().register(dataResource);
    }
}
