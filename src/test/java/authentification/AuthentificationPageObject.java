package authentification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthentificationPageObject {
	// Déclaration des selecteurs

	public final static String USERNAME_XPATH = "//input[@name='username']";
	public final static String PASSWORD_XPATH = "//input[@name='password']";
	public final static String LOGIN_XPATH = "//button[@type='submit']";
	public final static String VERIF_DASHBOARD = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6";
	public final static String ERROR1_XPATH = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p";
	public final static String ERROR2_XPATH = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span";
	public final static String ERROR3_XPATH = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span";

	// Déclaration des élements web avec l'annotation @FindBy
	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement userName;

	@FindBy(how = How.XPATH, using = PASSWORD_XPATH)
	public static WebElement password;

	@FindBy(how = How.XPATH, using = LOGIN_XPATH)
	public static WebElement login;

	@FindBy(how = How.XPATH, using = VERIF_DASHBOARD)
	public static WebElement dashboard;
	@FindBy(how = How.XPATH, using = ERROR1_XPATH)
	public static WebElement error1;

	@FindBy(how = How.XPATH, using = ERROR2_XPATH)
	public static WebElement error2;

	@FindBy(how = How.XPATH, using = ERROR3_XPATH)
	public static WebElement error3;

	// création des méthodes
	public void saisirUserName(String username) {
		this.userName.sendKeys(username);
	}

	public void saisirPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickButton() {
		this.login.click();
	}
	public String resultatObtenu() {
		return this.dashboard.getText();
	}
	public String verifError1() {
			return this.error1.getText();
	}
	public String verifError2() {
				return this.error2.getText();
	}
	public String verifError3() {
		return this.error3.getText();
	}

}
