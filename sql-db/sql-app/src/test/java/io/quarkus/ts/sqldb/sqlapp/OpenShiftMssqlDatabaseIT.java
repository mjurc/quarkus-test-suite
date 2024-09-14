package io.quarkus.ts.sqldb.sqlapp;

import org.junit.jupiter.api.Disabled;

import io.quarkus.test.scenarios.OpenShiftScenario;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@OpenShiftScenario
@DisabledIfSystemProperty(named = "ts.arm.missing.services.excludes", matches = "true", disabledReason = "MS SQL is not supported on aarch64.")
@Disabled("https://github.com/microsoft/mssql-docker/issues/769")
public class OpenShiftMssqlDatabaseIT extends MssqlDatabaseIT {

}
