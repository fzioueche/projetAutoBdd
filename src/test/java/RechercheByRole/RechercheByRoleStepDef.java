package RechercheByRole;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utile.Setup;
import utile.WaitMethods;

public class RechercheByRoleStepDef {
	// Déclaration des variables de la classe
	public WebDriver driver;
	// Declaration de la classe RechercheUserName page object

	public RechercheByRolePageObject rechercheRolePO = new RechercheByRolePageObject();
	// initialisation de la classe WaitMethods
	public WaitMethods waitMethods = new WaitMethods();

	// Constructeur de la class StepDefinition
	public RechercheByRoleStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, RechercheByRolePageObject.class);
	}

	@When("je clique sur le champ user role et je choisis le role {string}")
	public void je_clique_sur_le_champ_user_role_et_je_choisis_le_role(String userRole) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheRolePO.USER_ROLE_XPATH, 6);

		if (userRole.equals("Admin")) {
			rechercheRolePO.choisirRoleAdmin();
		} else {
			rechercheRolePO.choisirRoleEss();
		}
	}

	@Then("je verifie le user role {string} dans le tableau")
	public void jeVerifieLeUserRoleDansLeTableau(String resultatAttendu) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheRolePO.TAB_XPATH, 6);
		List<String> listObtenu = rechercheRolePO.verifierUserRoleList(driver);
				for (int i = 0; i < listObtenu.size(); i++) {
				Assert.assertEquals(listObtenu.get(i), resultatAttendu);

				}
	}

}
