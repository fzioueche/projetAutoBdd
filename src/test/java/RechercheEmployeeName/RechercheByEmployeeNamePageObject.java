package RechercheEmployeeName;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class RechercheByEmployeeNamePageObject {

	// Declaration des selecteurs:

	public final static String EMPLOYEENAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input";

	public final static String VERIF_EMPLOYEENAME = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[4]/div";

	public final static String UTILISATEUR_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p";

	public final static String SELECT_USER_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div/span";

	public final static String FIRST_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";

	public final static String SECOND_XPATH = "]/div/div[4]/div";

	public final static String CLASSNAME = "oxd-table-card";

	public final static String TAB_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]";
	public final static String ERROR_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/span";
	public final static String NORECORD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div";

	// //declaration des elementsweb avec l'annotation findby

	@FindBy(how = How.XPATH, using = EMPLOYEENAME_XPATH)

	public static WebElement employeeName;

	@FindBy(how = How.XPATH, using = UTILISATEUR_XPATH)

	public static WebElement utilisateurConnecte;

	@FindBy(how = How.XPATH, using = VERIF_EMPLOYEENAME)

	public static WebElement verifEmployeeName;

	@FindBy(how = How.XPATH, using = SELECT_USER_XPATH)

	public static WebElement selectUser;

	@FindBy(how = How.XPATH, using = NORECORD_XPATH)
	public static WebElement noRecord;

	@FindBy(how = How.CLASS_NAME, using = CLASSNAME)
	public static List<WebElement> ListEmployeeName;

	// Création des méthodes:

	public void saisirEmployeeNameValide() {
		String name = utilisateurConnecte.getText();
		this.employeeName.sendKeys(name);

	}

	public void selectEmployeeName() {
		this.selectUser.click();

	}

	public void saisirEpmloyeeNameNonValide(String employeeNameInvalide) {

		this.employeeName.sendKeys(employeeNameInvalide);

	}

	public void selectEmployeeNameNonValide() {
		this.noRecord.click();

	}

	public List<String> verifTab(WebDriver driver) {

		List<String> employeeNameList = new ArrayList<String>();
		for (int i = 1; i <= ListEmployeeName.size(); i++) {
			String employeeNameXPATH = FIRST_XPATH + i + SECOND_XPATH;

			WebElement employeeName = driver.findElement(By.xpath(employeeNameXPATH));

			employeeNameList.add(employeeName.getText());
		}

		return (employeeNameList);

	}

}
