package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.SkillMainPage;
import utils.TestContext;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before("@login")
    public void loginBeforeScenario() {
        new SkillMainPage(context).login();
    }

    @After
    public void tearDown() {
        context.cleanUp();
    }
}


