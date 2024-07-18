package recherche;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RechercheUserNamePageObject {
	//Declaration des selecteurs:
	public final static String BTN_ADMIN_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span";
	public final static String USERNAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input";
	public final static String BTN_SEARCH_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]";
	public final static String FIRST_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String SECOND_XPATH ="]/div/div[2]/div";
    public final static String LIST_CLASS_NAME= "oxd-table-card";
    public final static String TAB_XPATH ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]";
  
	//Declaration des elementweb avec l'annotation FINDBY
	@FindBy(how = How.XPATH, using = BTN_ADMIN_XPATH)
	public static WebElement adminBtn;
	
	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement userName;
	
	@FindBy(how = How.XPATH, using = BTN_SEARCH_XPATH)
	public static WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = FIRST_XPATH)
	public static WebElement firstName;
	
	
	@FindBy(how = How.XPATH, using = SECOND_XPATH)
	public static WebElement secondName;
	
	@FindBy(how = How.CLASS_NAME, using = LIST_CLASS_NAME)
	public static List<WebElement> ListUserName;
	
	//Création des methodes:
	public void cliquerBtnAdmin() {
		this.adminBtn.click();
	}
	public void saisirUserName(String username) {
		this.userName.sendKeys(username);
	}
	public void cliquerBtnSearch() {
		this.btnSearch.click();
	}
	public String resultatobtenu() {         
		return this.firstName.getText();
		
	}
	
	public List<String> verifierUserNameList(WebDriver driver){
		
		List<String> userNameListObtenu = new ArrayList<String>();
		for(int i=1; i<=ListUserName.size(); i++) {
		String userNameXpath = FIRST_XPATH + i + SECOND_XPATH ;
		WebElement userNameObtenu = driver.findElement(By.xpath(userNameXpath));
		userNameListObtenu.add(userNameObtenu.getText());

	}
		return userNameListObtenu;
		
		

}
}

