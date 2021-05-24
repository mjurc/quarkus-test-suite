package io.quarkus.ts.external.applications.todo.demo.app;

import io.quarkus.test.bootstrap.RestService;
import io.quarkus.test.scenarios.OpenShiftDeploymentStrategy;
import io.quarkus.test.scenarios.OpenShiftScenario;
import io.quarkus.test.services.QuarkusApplication;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

@OpenShiftScenario(deployment = OpenShiftDeploymentStrategy.QuarkusS2IBuild)
public class OpenShiftTodoDemoAppIT {

    @QuarkusApplication(gitRepositoryUri = "https://github.com/quarkusio/todo-demo-app.git")
    static RestService app = new RestService();

    @Test
    public void test() {
        app.given()
                .get("/")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
