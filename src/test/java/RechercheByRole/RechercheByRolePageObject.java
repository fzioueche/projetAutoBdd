package RechercheByRole;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RechercheByRolePageObject {
	// Declaration des selecteurs:

	public final static String USER_ROLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div";
	                  
	public final static String ADMIN_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span";
	
	public final static String ESS_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]";
	public final static String FIRST_XPATH = " //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String SECOND_XPATH = "]/div/div[3]/div";
	public final static String VERIF_USERROLE_CLASS_NAME = "oxd-table-card";
	public final static String TAB_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]";

	// Declaration des element web avec l'annotation FINDBY

	@FindBy(how = How.XPATH, using = USER_ROLE_XPATH)
	public static WebElement userRole;

	@FindBy(how = How.XPATH, using = ADMIN_XPATH)
	public static WebElement userRoleAdmin;

	@FindBy(how = How.XPATH, using = ESS_XPATH)
	public static WebElement userRoleEss;

	@FindBy(how = How.XPATH, using = FIRST_XPATH)
	public static WebElement firstUserRole;

	@FindBy(how = How.XPATH, using = SECOND_XPATH)
	public static WebElement secondUserRole;

	@FindBy(how = How.CLASS_NAME, using = VERIF_USERROLE_CLASS_NAME)
	public static List<WebElement> ListUserRole;

	// Création des methodes:

	public void choisirRoleAdmin() {
		this.userRole.click();
		this.userRoleAdmin.click();
	}

	public void choisirRoleEss() {
		this.userRole.click();
		this.userRoleEss.click();
	}
	

	public List<String> verifierUserRoleList(WebDriver driver) {

		List<String> userRoleListObtenu = new ArrayList<String>();
		for (int i = 1; i <= ListUserRole.size(); i++) {
			String userRoleXpath = FIRST_XPATH + i + SECOND_XPATH;
			WebElement userRoleObtenu = driver.findElement(By.xpath(userRoleXpath));
			userRoleListObtenu.add(userRoleObtenu.getText());

		}
		return userRoleListObtenu;

	}
}
