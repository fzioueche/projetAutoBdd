package authentification;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utile.CommonMethods;
import utile.Setup;
import utile.WaitMethods;

public class AuthentificationStepDefinition {
	// Déclaration des variables de la classe
	public WebDriver driver;

	// instantation de la classe authentification page object

	public AuthentificationPageObject authentificationpageobject = new AuthentificationPageObject();

	// instantation de la classe CommonMethods
	public CommonMethods commonMethods = new CommonMethods();

	// initialisation de la classe WaitMethods
	public WaitMethods waitmethods = new WaitMethods();

	// Constructeur de la class StepDefinition
	public AuthentificationStepDefinition() {
		driver = Setup.driver;
		// initialisation des éléments web page object
		PageFactory.initElements(driver, AuthentificationPageObject.class);
	}

	@Given("je me connecte sur l'application")
	public void je_me_connecte_sur_l_application() throws IOException {
		commonMethods.openURLWithConfigFile("url");
	}

	@When("je saisis le username {string}")
	public void je_saisis_le_username(String username) {
		waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthentificationPageObject.USERNAME_XPATH,
				5);
		authentificationpageobject.saisirUserName(username);
	}

	@When("je saisis le password {string}")
	public void je_saisis_le_password(String password) {
		waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthentificationPageObject.PASSWORD_XPATH,
				5);
		authentificationpageobject.saisirPassword(password);
	}

	@When("je clique sur le bouton login")
	public void je_clique_sur_le_bouton_login() {
		waitmethods.explicitWaitUntilButtonIsClickableXpath(driver, AuthentificationPageObject.LOGIN_XPATH, 5);
		authentificationpageobject.clickButton();
	}

	@Then("je me redirige vers la page d'accueil et le texte {string} s'affiche")
	public void je_me_redirige_vers_la_page_d_accueil_et_le_texte_s_affiche(String resultatAttendu) {
		switch (resultatAttendu) {
		case "Dashboard":
			waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver,
					AuthentificationPageObject.VERIF_DASHBOARD, 5);
			String textObtenu = authentificationpageobject.resultatObtenu();
			Assert.assertTrue(textObtenu.contains(resultatAttendu));
			break;

		case "Invalid credentials":
			waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthentificationPageObject.ERROR1_XPATH,
					6);
			String erreur1obtenu = authentificationpageobject.verifError1();
			Assert.assertTrue(erreur1obtenu.contains(resultatAttendu));
			break;

		case "Required":
			if (commonMethods.isElementDisplayed(AuthentificationPageObject.error2)
					&& !commonMethods.isElementDisplayed(AuthentificationPageObject.error3)) {
				waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver,
						AuthentificationPageObject.ERROR2_XPATH, 6);
				String erreur2obtenu = authentificationpageobject.verifError2();
				Assert.assertTrue(erreur2obtenu.contains(resultatAttendu));
			} else if (commonMethods.isElementDisplayed(AuthentificationPageObject.error3)
					&& !commonMethods.isElementDisplayed(AuthentificationPageObject.error2)) {
				waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver,
						AuthentificationPageObject.ERROR2_XPATH, 6);
				String erreur3obtenu = authentificationpageobject.verifError3();
				Assert.assertTrue(erreur3obtenu.contains(resultatAttendu));

			} else if (commonMethods.isElementDisplayed(AuthentificationPageObject.error3)
					&& commonMethods.isElementDisplayed(AuthentificationPageObject.error2)) {

				waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver,
						AuthentificationPageObject.ERROR2_XPATH, 6);
				String erreur2obtenu = authentificationpageobject.verifError2();
				Assert.assertTrue(erreur2obtenu.contains(resultatAttendu));

				waitmethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver,
						AuthentificationPageObject.ERROR2_XPATH, 6);
				String erreur3obtenu = authentificationpageobject.verifError3();
				Assert.assertTrue(erreur3obtenu.contains(resultatAttendu));

			}

			break;
		}

	}
}
