package RechercheByStatus;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RechercheByStatusPageObject {
	// Declaration des selecteurs:

		public final static String STATUS_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div";
		public final static String ENABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/span";
		public final static String DISABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[3]/span";
		public final static String FIRST_XPATH = " //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
		public final static String SECOND_XPATH = "]/div/div[5]/div";
		public final static String VERIF_STATUS_CLASS_NAME = "oxd-table-card";
		public final static String TAB_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]";

		// Declaration des element web avec l'annotation FINDBY

		@FindBy(how = How.XPATH, using = STATUS_XPATH)
		public static WebElement status;

		@FindBy(how = How.XPATH, using = ENABLED_XPATH)
		public static WebElement statusEnabled;

		@FindBy(how = How.XPATH, using = DISABLED_XPATH)
		public static WebElement statusDisabled;

		@FindBy(how = How.XPATH, using = FIRST_XPATH)
		public static WebElement firstStatus;

		@FindBy(how = How.XPATH, using = SECOND_XPATH)
		public static WebElement secondStatus;

		@FindBy(how = How.CLASS_NAME, using = VERIF_STATUS_CLASS_NAME)
		public static List<WebElement> ListStatus;

		// Création des methodes:

		public void choisirStatusEnabled() {
			this.status.click();
			this.statusEnabled.click();
		}

		public void choisirStatusDisabled() {
			this.status.click();
			this.statusDisabled.click();
		}
		public List<String> verifStatusList(WebDriver driver) {

			List<String> statusListObtenu = new ArrayList<String>();
			for (int i = 1; i <= ListStatus.size(); i++) {
				String statusXPATH = FIRST_XPATH + i + SECOND_XPATH;

				WebElement statusObtenu = driver.findElement(By.xpath(statusXPATH));

				statusListObtenu.add(statusObtenu.getText());
			}
			return statusListObtenu;
		}
}

		

	
			

		
	


