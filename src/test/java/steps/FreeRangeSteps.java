package steps;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;

public class FreeRangeSteps extends PaginaPrincipal {

    PaginaPrincipal landingPage = new PaginaPrincipal();

    @Given("I navigate to www.freerangetesters.com")
    public void InavifateToFRT() {
        landingPage.navigateToFreeRange();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUser(String section) {
        landingPage.clicklOnSectionNavigationBar(section);
    }


}
