package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ExpenseCategoryPage {
	public WebDriver driver;
	public ExpenseCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseButton;
	
	@FindBy(xpath="//li[@class='nav-item']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	private WebElement expenseCategoryButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr")
	private List<WebElement> tableRows;
	
	public void clickExpenseCategory() {
		String firstRow;
		Boolean flag=false;
		PageUtility.clickOnElement(manageExpenseButton);
		WaitUtility.waitForElementClickable(driver, manageExpenseButton);
		PageUtility.clickOnElement(expenseCategoryButton);
		List<WebElement> rowElements=tableRows;
		firstRow=rowElements.get(0).getText();
		if((firstRow.contains("Title")) && (firstRow.contains("Action"))){
			flag=true;
		}
		Assert.assertTrue(true, "First row of table does not contains Title");
		
	}
	

}
