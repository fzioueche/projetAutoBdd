package RechercheByStatus;

	import java.util.List;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import utile.Setup;
	import utile.WaitMethods;

	public class RechercheByStatusStepDef {
		// Déclaration des variables de la classe
		public WebDriver driver;
		// Declaration de la classe RechercheUserName page object

		public RechercheByStatusPageObject rechercheStatusPO = new RechercheByStatusPageObject();
		// initialisation de la classe WaitMethods
		public WaitMethods waitMethods = new WaitMethods();

		// Constructeur de la class StepDefinition
		public RechercheByStatusStepDef() {
			driver = Setup.driver;
			PageFactory.initElements(driver, RechercheByStatusPageObject.class);
		}
		
		@When("je clique sur le champ status et je choisis le role {string}")
		public void je_clique_sur_le_champ_status_et_je_choisis_le_role(String status) {
		   
			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheStatusPO.STATUS_XPATH, 6);

			if (status.equals("Enabled")) {
				rechercheStatusPO.choisirStatusEnabled();
		
			} else {
				rechercheStatusPO.choisirStatusDisabled();
			}
		}
		

		@Then("je verifie le status {string} dans le tableau")
		public void je_verifie_le_status_dans_le_tableau(String resultatAttendu) {
			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheStatusPO.TAB_XPATH, 6);
			List<String> listObtenu = rechercheStatusPO.verifStatusList(driver);
					for (int i = 0; i < listObtenu.size(); i++) {
					Assert.assertEquals(listObtenu.get(i), resultatAttendu);

					}
		}

	}

	