package crooked.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CrookedApplication extends Application<CrookedConfiguration> {
    public static void main(String[] args) throws Exception {
        new CrookedApplication().run(args);
    }

    @Override
    public String getName() {
        return "crooked-app";
    }

    @Override
    public void initialize(Bootstrap<CrookedConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(CrookedConfiguration configuration, Environment environment) throws Exception {
        DataResource dataResource = new DataResource(configuration.getRedisHost());
        environment.jersey().register(dataResource);
    }
}
