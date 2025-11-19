package pages;

import org.openqa.selenium.WebElement;

public class PaginaPrincipal extends BasePage {

    String sectionLinkRecursos ="nav li a[href*=\"recursos\"]";//css

    //Generals
    public void navigateToFreeRange() {
        navigateTo("https://www.freerangetesters.com/");
    }


    public void clicklOnSectionNavigationBar() {
        clickElement(sectionLinkRecursos);
    }


}
