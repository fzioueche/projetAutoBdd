package déconnection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class deconnectionPageObject {
// Declaration des selecteurs:
	public final static String MENU_UTILISATEUR_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i";
	public final static String LOGOUT_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a";
	public final static String LOGIN_XPATH = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5";

// declaration des elementsweb avec l'annotation findby
	@FindBy(how = How.XPATH, using = MENU_UTILISATEUR_XPATH)

	public static WebElement userBtn;
	@FindBy(how = How.XPATH, using = LOGOUT_XPATH)
	public static WebElement logOutBtn;
	@FindBy(how = How.XPATH, using = LOGIN_XPATH)
	public static WebElement login;

//creation des methodes
	public void cliquerUtilisateurBtn() {
		this.userBtn.click();
	}

	public void cliquerLogout() {

		this.logOutBtn.click();

	}

	public String resultatObtenu() {
		return this.login.getText();
	}

}
