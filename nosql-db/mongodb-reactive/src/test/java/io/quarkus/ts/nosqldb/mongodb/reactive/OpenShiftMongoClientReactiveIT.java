package io.quarkus.ts.nosqldb.mongodb.reactive;

import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import io.quarkus.test.bootstrap.MongoDbService;
import io.quarkus.test.bootstrap.RestService;
import io.quarkus.test.scenarios.OpenShiftScenario;
import io.quarkus.test.services.Container;
import io.quarkus.test.services.QuarkusApplication;

@OpenShiftScenario
@DisabledIfSystemProperty(named = "ts.arm.missing.services.excludes", matches = "true", disabledReason = "https://github.com/quarkus-qe/quarkus-test-suite/issues/1146")
public class OpenShiftMongoClientReactiveIT extends AbstractMongoClientReactiveIT {

    @Container(image = "${mongodb.image}", port = 27017, expectedLog = "Waiting for connections")
    static MongoDbService database = new MongoDbService();

    @QuarkusApplication
    static RestService app = new RestService()
            .withProperty("quarkus.mongodb.connection-string", database::getJdbcUrl);

    @Override
    protected RestService getApp() {
        return app;
    }
}
