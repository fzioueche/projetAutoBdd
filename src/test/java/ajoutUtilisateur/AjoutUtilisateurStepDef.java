package ajoutUtilisateur;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import recherche.RechercheUserNamePageObject;
import utile.Setup;
import authentification.AuthentificationPageObject;
import utile.WaitMethods;

public class AjoutUtilisateurStepDef {

	// Déclaration des variables de la classe
	public WebDriver driver;
	// Declaration de la classe RechercheUserName page object
	public AjoutUtilisateurPageObject addUserPO = new AjoutUtilisateurPageObject();

//initialisation de la classe WaitMethods
	public WaitMethods waitMethods = new WaitMethods();

	// Constructeur de la class StepDefinition
	public AjoutUtilisateurStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, AjoutUtilisateurPageObject.class);
	}

	@When("je clique sur bouton add")
	public void je_clique_sur_bouton_add() {
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, addUserPO.BTN_ADD_XPATH, 10);
		addUserPO.cliquerBtnAdd();

	}

	@When("j ecris le user role {string}")
	public void j_ecris_le_user_role(String addUser) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.USER_ROLE_XPATH, 10);
		addUserPO.cliquerRole();

		if (addUser.equals("Admin")) {
			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.ADMIN_XPATH, 10);
			addUserPO.choisirRoleAdmin();

		} else {
			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.ESS_XPATH, 10);
			addUserPO.choisirRoleEss();
		}

	}

	@When("je saisis le nom de l'employee {string}")
	public void je_saisis_le_nom_de_l_employee(String employeeName) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.EMPLOYE_NAME_XPATH, 10);
		addUserPO.saisirEmployeName();
		waitMethods.explicitWaitUntilButtonIsClickableCss(driver, addUserPO.SELECT_EMPLOYEE_NAME_XPATH, 10);
		addUserPO.selectEmployeeName();
	}

	@When("je sélectionne le statut de l'employee {string}")
	public void je_sélectionne_le_statut_de_l_employee(String status) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.STATUS_XPATH, 10);
		addUserPO.cliquerStatus();

		if (status.equals("Enabled")) {
			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.ENABLED_XPATH, 10);
			addUserPO.choisirStatusEnabled();

		} else {
			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.DISABLED_XPATH, 10);
			addUserPO.choisirStatusdisabled();

		}

	}

	@When("je saisis le username a ajouter {string}")
	public void je_saisis_le_username_a_ajouter(String username) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.USERNAME_XPATH, 10);
		addUserPO.saisirUsername(username);

	}

	@When("j ecris le mot de passe {string}")
	public void j_ecris_le_mot_de_passe(String password) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.PASSWORD_XPATH, 10);
		addUserPO.saisirPassword(password);

	}

	@When("je confirme le mot de passe ecris {string}")
	public void je_confirme_le_mot_de_passe_ecris(String cpassword) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.CONMFIRM_PASSWORD_XPATH, 10);
		addUserPO.comfirmPassword(cpassword);

	}

	@When("je clique sur bouton save")
	public void je_clique_sur_bouton_save() throws InterruptedException {
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, addUserPO.BTN_SAVE_XPATH, 10);
		addUserPO.cliquerBtnSave();

	}

	@Then("je me redirige vers la page Admin et {string} s'affiche")
	public void je_me_redirige_vers_la_page_admin_et_s_affiche(String userName) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.VERIF_XPATH, 10);
		String textObtenu = addUserPO.resultatObtenu();
		Assert.assertTrue(textObtenu.contains(userName));

	}

	@Then("je vérifie que le nouvel utilisateur {string} est présent dans le tableau")
	public void je_vérifie_que_le_nouvel_utilisateur_est_présent_dans_le_tableau(String userName) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, addUserPO.TAB_LIST_XPATH, 10);
		List<String> listObtenu = addUserPO.verifUsername(driver);

		for (int i = 0; i < listObtenu.size(); i++) {

			Assert.assertEquals(listObtenu.get(i), userName);

		}
	}

}
