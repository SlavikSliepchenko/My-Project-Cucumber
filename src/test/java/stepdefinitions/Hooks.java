package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContext;

public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        context.cleanUp();
    }
}
