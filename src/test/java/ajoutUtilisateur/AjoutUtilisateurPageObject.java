package ajoutUtilisateur;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

 public class AjoutUtilisateurPageObject {
 public final static String BTN_ADD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button";
 public final static String USER_ROLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div";
 public final static String ADMIN_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]";
 public final static String ESS_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]";
 public final static String EMPLOYE_NAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div";
 public final static String STATUS_XPATH= "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div";
 public final static String ENABLED_XPATH = "div[role='listbox'] div:nth-child(2) span:nth-child(1)";
 public final static String DISABLED_XPATH = "div[role='listbox'] div:nth-child(2) span:nth-child(1)";
 public final static String USERNAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input";
 public final static String PASSWORD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input";
 public final static String CONMFIRM_PASSWORD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input";
 public final static String BTN_SAVE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]";
 public final static String VERIF_USERNAME_CLASS_NAME ="oxd-table-card";
 public final static String USER_CONNX_XPATH ="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p";
 public final static String SELECT_EMPLOYEE_NAME_XPATH ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div/span";
 public final static String VERIF_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5";
 public final static String VERIF_USERNAME_XPATH ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[2]/div";
 public final static String TAB_LIST_XPATH ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]";
 public final static String FIRST_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
 public final static String SECOND_XPATH = "]/div/div[2]/div";
	


 @FindBy(how = How.XPATH, using = BTN_ADD_XPATH)
 public static WebElement btnAdd;
 @FindBy(how = How.XPATH, using = USER_ROLE_XPATH)
 public static WebElement userRole;
 @FindBy(how = How.XPATH, using = ADMIN_XPATH)
 public static WebElement userRoleAdmin;
 @FindBy(how = How.XPATH, using = ESS_XPATH)
 public static WebElement userRoleEss;
 @FindBy(how = How.XPATH, using = EMPLOYE_NAME_XPATH)
 public static WebElement employeeName;
 @FindBy(how = How.XPATH, using = STATUS_XPATH)
 public static WebElement status;
 @FindBy(how = How.XPATH, using = ENABLED_XPATH)
 public static WebElement statusEnabled;
 @FindBy(how = How.XPATH, using = DISABLED_XPATH)
 public static WebElement statusDisabled;
 @FindBy(how = How.XPATH, using = USERNAME_XPATH)
 public static WebElement userName;
 @FindBy(how = How.XPATH, using = PASSWORD_XPATH)
 public static WebElement password;
 @FindBy(how = How.XPATH, using = CONMFIRM_PASSWORD_XPATH)
 public static WebElement comfirmPassword;
 @FindBy(how = How.XPATH, using = BTN_SAVE_XPATH)
 public static WebElement btnSave;

 @FindBy (how = How.XPATH, using = USER_CONNX_XPATH) 
 public static WebElement userConnx ;
 @FindBy (how = How.XPATH, using = SELECT_EMPLOYEE_NAME_XPATH) 
 public static WebElement selectEmployeeName ;
 @FindBy(how = How.XPATH, using = VERIF_XPATH)
 public static WebElement verification;
 @FindBy(how = How.CLASS_NAME, using = VERIF_USERNAME_CLASS_NAME )
 public static List<WebElement> list;
 @FindBy(how= How.XPATH, using = FIRST_XPATH )
 public static WebElement firstXpath;
 @FindBy(how= How.XPATH, using = SECOND_XPATH )
 public static WebElement secondXpath;

	
	
	
	
	
 public void cliquerBtnAdd() {
  this.btnAdd.click();
 }
	
 public void cliquerRole() {
  this.userRole.click();
 }
 public void choisirRoleAdmin() {
  
  this.userRoleAdmin.click();
 }
 public void choisirRoleEss() {
  
  this.userRoleEss.click();
 }
 public void saisirEmployeName() {
  String name = userConnx.getText();
  this.employeeName.sendKeys(name);
  
  
 }
 public void selectEmployeeName () {
  this.selectEmployeeName.click();
 }
	
 public void cliquerStatus() {
  this.status.click();
 }
 public void choisirStatusEnabled() {
  
  this.statusEnabled.click(); 
 }
 public void choisirStatusdisabled() {
  
  this.statusDisabled.click(); 
 }
 public void saisirUsername(String username) {
  this.userName.sendKeys(username);
 }
 public void saisirPassword(String password) {
  this.password.sendKeys(password);
 }
 public void comfirmPassword(String cpassword) {
  this.comfirmPassword.sendKeys(cpassword);
 }
 public void cliquerBtnSave() {
  this.btnSave.click();
 }
	
 public String resultatObtenu() {
  return this.verification.getText();
 }
 public List<String> verifUsername(WebDriver driver) {
  
  List<String> verifUsernameObtenu = new ArrayList<String>();
  
  for(int i=1 ; i<=list.size(); i++) {
   
   String userNameXpath = FIRST_XPATH + i + SECOND_XPATH ;
   WebElement userName = driver.findElement(By.xpath(userNameXpath));
   verifUsernameObtenu.add(userName.getText()) ;
  
  }
  return verifUsernameObtenu;

}
}


