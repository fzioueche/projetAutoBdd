package déconnection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utile.Setup;
import utile.WaitMethods;
import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class deconnectionStepDef {

// declaration du variable de la classe
	public WebDriver driver;
// instantiation de la classe rechercheStatus page object
	public deconnectionPageObject logoutPO = new deconnectionPageObject();
// instantiation de la classe waitmethods
	public WaitMethods waitMethods = new WaitMethods();

// constructeur de la classe step def
	public deconnectionStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, deconnectionPageObject.class);

	}

	@When("je clique sur le menu déroulant du profil utilisateur")
	public void je_clique_sur_le_menu_déroulant_du_profil_utilisateur() {

		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, logoutPO.MENU_UTILISATEUR_XPATH, 50);
		logoutPO.cliquerUtilisateurBtn();
	}

	@When("je clique sur le bouton logout")
	public void je_clique_sur_le_bouton_logout() {
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, logoutPO.LOGOUT_XPATH, 50);
		logoutPO.cliquerLogout();
	}

	@Then("je me redirige vers la page de connexion  et login s'affiche")
	public void je_me_redirige_vers_la_page_de_connexion_et_login_s_affiche() {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, logoutPO.LOGIN_XPATH, 5);

		String textattendu = "Login";

		String textObtenu = logoutPO.resultatObtenu();
		Assert.assertTrue(textObtenu.contains((textattendu)));

	}

}
