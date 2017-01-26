package whtson.test;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import whtson.test.db.EmployeeDAO;
import whtson.test.db.LogDAO;
import whtson.test.resource.EmployeeResource;
import whtson.test.resource.LogResource;

public class App extends Application<AppConfiguration> {

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {

        //connection pool to the database, a health check for connectivity to the database
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        environment.jersey().setUrlPattern("/api/*");

        // data access objects
        final EmployeeDAO employeeDAO = jdbi.onDemand(EmployeeDAO.class);
        final LogDAO logDAO = jdbi.onDemand(LogDAO.class);


        // resources
        EmployeeResource employeeResource = new EmployeeResource(employeeDAO);
        LogResource logResource = new LogResource(logDAO);


        // environment
        environment.jersey().register(employeeResource);
        environment.jersey().register(logResource);

    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


}
