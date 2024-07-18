package recherche;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import authentification.AuthentificationPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utile.Setup;
import utile.WaitMethods;

public class RechercheUserNameStepDef {
	// Déclaration des variables de la classe
	public WebDriver driver;
	// instantation de la classe RechercheUserName page object

	public RechercheUserNamePageObject rechercheUserNamePO = new RechercheUserNamePageObject();
	// initialisation de la classe WaitMethods
	public WaitMethods waitMethods = new WaitMethods();

	// Constructeur de la class StepDefinition
	public RechercheUserNameStepDef() {
		driver = Setup.driver;
		// initialisation des elements web
		PageFactory.initElements(driver, RechercheUserNamePageObject.class);
	}

	@When("je clique sur le menu Admin")
	public void je_clique_sur_le_menu_admin() {
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, rechercheUserNamePO.BTN_ADMIN_XPATH, 5);
		rechercheUserNamePO.cliquerBtnAdmin();
	}

	@When("je saisis le username a chercher {string}")
	public void je_saisis_le_username_a_chercher(String username) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheUserNamePO.USERNAME_XPATH, 5);
		rechercheUserNamePO.saisirUserName(username);
	}

	@When("je clique sur le bouton search")
	public void je_clique_sur_le_bouton_search() {
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, rechercheUserNamePO.BTN_SEARCH_XPATH, 5);
		rechercheUserNamePO.cliquerBtnSearch();
	}

	@Then("je verifie le username {string} dans le tableau")
	public void je_verifie_le_username_dans_le_tableau(String resultatAttendu) {
    waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheUserNamePO.TAB_XPATH, 5);
		List<String> listObtenu = rechercheUserNamePO.verifierUserNameList(driver);
		for(int i = 0; i<listObtenu.size(); i++) {
			Assert.assertEquals(listObtenu.get(i), resultatAttendu);

		}
	}

}
