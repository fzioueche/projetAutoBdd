package RechercheEmployeeName;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import java.util.List;
import utile.Setup;
import utile.WaitMethods;

public class RechercheByEmployeeNameStepDef {

	// declaration du variable de la classe

	public WebDriver driver;

	// instantiation de la classe recheche page object

	public RechercheByEmployeeNamePageObject rechercheEmployeeNamePO = new RechercheByEmployeeNamePageObject();

	// instantiation de la classe waitmethods

	public WaitMethods waitMethods = new WaitMethods();

	// constructeur de la classe step def

	public RechercheByEmployeeNameStepDef() {

		driver = Setup.driver;

		// initialisation des elements

		PageFactory.initElements(driver, RechercheByEmployeeNamePageObject.class);
	}

	@When("je saisis l'employeename a chercher")
	public void je_saisis_l_employeename_a_chercher() {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheEmployeeNamePO.EMPLOYEENAME_XPATH,
				5);

		rechercheEmployeeNamePO.saisirEmployeeNameValide();
		
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheEmployeeNamePO.SELECT_USER_XPATH,
				5);
		rechercheEmployeeNamePO.selectEmployeeName();
		
	}

	@Then("je verifie que l'employee name  apparait dans le tableau")
	public void je_verifie_que_l_employee_name_apparait_dans_le_tableau() {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheEmployeeNamePO.TAB_XPATH, 5);

		List<String> resultatObtenu = rechercheEmployeeNamePO.verifTab(driver);

		for (int i = 0; i < resultatObtenu.size(); i++) {
			String employeeNameAttendu = rechercheEmployeeNamePO.utilisateurConnecte.getText();

			Assert.assertEquals(employeeNameAttendu, resultatObtenu.get(i));

		}

	}

	@When("je saisis l'employeename a chercher {string} dans le champ de recherche")
	public void je_saisis_l_employeename_a_chercher_dans_le_champ_de_recherche(String nameInvalide) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheEmployeeNamePO.EMPLOYEENAME_XPATH,
				10);
		rechercheEmployeeNamePO.saisirEpmloyeeNameNonValide(nameInvalide);
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheEmployeeNamePO.NORECORD_XPATH,
				5);
		rechercheEmployeeNamePO.selectEmployeeNameNonValide();
	}

	@Then("je verifie l'apparition du message d'erreur {string}")
	public void je_verifie_l_apparition_du_message_d_erreur(String resultatattendu) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheEmployeeNamePO.ERROR_XPATH, 10);
		String resultatObtenu = driver.findElement(By.xpath(rechercheEmployeeNamePO.ERROR_XPATH)).getText();
		Assert.assertTrue(resultatObtenu.contains(resultatattendu));
	}

}
