package io.quarkus.ts.sqldb.compatibility;

import io.quarkus.test.bootstrap.RestService;
import io.quarkus.test.bootstrap.SqlServerService;
import io.quarkus.test.scenarios.QuarkusScenario;
import io.quarkus.test.scenarios.annotations.DisabledOnFipsAndJava17;
import io.quarkus.test.services.QuarkusApplication;
import io.quarkus.test.services.SqlServerContainer;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledOnFipsAndJava17(reason = "https://github.com/quarkusio/quarkus/issues/40813")
@DisabledIfSystemProperty(named = "ts.arm.missing.services.excludes", matches = "true", disabledReason = "MS SQL is not supported on aarch64.")
@QuarkusScenario
public class MssqlDatabaseIT extends AbstractSqlDatabaseIT {

    @SqlServerContainer
    static SqlServerService database = new SqlServerService();

    @QuarkusApplication
    static final RestService app = new RestService()
            .withProperties("mssql.properties")
            .withProperty("quarkus.datasource.username", database.getUser())
            .withProperty("quarkus.datasource.password", database.getPassword())
            .withProperty("quarkus.datasource.jdbc.url", database::getJdbcUrl);
}
