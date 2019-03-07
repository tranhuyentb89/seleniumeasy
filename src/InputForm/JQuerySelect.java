package InputForm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class JQuerySelect {
	WebDriver driver;
	JavascriptExecutor javascript;
//  @Test
//  public void TC_01_DropdownWithSearchBox() throws Exception {
//	  driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
//	  DropdownWithSearchBox("//span[@class='select2-selection select2-selection--single']","//span[@class='select2-search select2-search--dropdown']/input", "//ul[@id='select2-country-results']/li", "Bangladesh");
//	  
//	  driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
//	  DropdownWithSearchBox("//span[@class='select2-selection select2-selection--single']","//span[@class='select2-search select2-search--dropdown']/input", "//ul[@id='select2-country-results']/li", "Netherlands");
//
//	  Thread.sleep(3000);
//  }
//  @Test
//  public void TC_02_DropdownWithoutSearchBox() throws Exception
//  {
//	  driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
//	  DropdownWithOutSearchBox("//span[@class='select2-selection select2-selection--single']","//ul[@id='select2-country-results']/li", "Bangladesh");
//	  
//	  driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
//	  DropdownWithOutSearchBox("//span[@class='select2-selection select2-selection--single']","//ul[@id='select2-country-results']/li", "Netherlands");
//
//	  Thread.sleep(3000);
//
//  }
  @Test
  public void TC_03_SelectMultiValue() throws Exception
  {
	  driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
	  SelectMultiValue("//ul[@class='select2-selection__rendered']","//li[contains(@id,'select2-c51j-result')]","Alabama");
	  Thread.sleep(3000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	  driver= new ChromeDriver();		
	  javascript = (JavascriptExecutor)driver;
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  public void DropdownWithSearchBox(String parentXpath, String searchXpath, String childXpath, String valueExpected) throws Exception {
	  WebElement parent = driver.findElement(By.xpath(parentXpath));
	  //javascript.executeScript("arguments[0].click()", parent);
	  parent.click();
	  Thread.sleep(3000);
	  
	  WebElement search = driver.findElement(By.xpath(searchXpath));
	  search.sendKeys("a");
	  //wait cho tat ca cac item duoc hien thi
	  List<WebElement> child = driver.findElements(By.xpath(childXpath));
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfAllElements(child));
	  for(WebElement chilItem: child)
	  {
		  if(chilItem.getText().equals(valueExpected))
		  {
			  javascript.executeScript("arguments[0].scrollIntoView(true);", chilItem);
			  chilItem.click();
			  Thread.sleep(3000);
			  break;
		  }
	  }
  }
  public void DropdownWithOutSearchBox(String parentXpath, String childXpath, String valueExpected) throws Exception {
	  WebElement parent = driver.findElement(By.xpath(parentXpath));
	  //javascript.executeScript("arguments[0].click()", parent);
	  parent.click();
	  Thread.sleep(3000);
	  //wait cho tat ca cac item duoc hien thi
	  List<WebElement> child = driver.findElements(By.xpath(childXpath));
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfAllElements(child));
	  for(WebElement chilItem: child)
	  {
		  if(chilItem.getText().equals(valueExpected))
		  {
			  javascript.executeScript("arguments[0].scrollIntoView(true);", chilItem);
			  chilItem.click();
			  Thread.sleep(3000);
			  break;
		  }
	  }
  }
  public void SelectMultiValue(String parentXpath, String childXpath, String valueExpected) throws Exception {
	  WebElement parent = driver.findElement(By.xpath(parentXpath));
	  javascript.executeScript("arguments[0].click()", parent);
	  //parent.click();
	  Thread.sleep(3000);
	  //wait cho tat ca cac item duoc hien thi
	  List<WebElement> child = driver.findElements(By.xpath(childXpath));
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfAllElements(child));
	  for(WebElement chilItem: child)
	  {
		  if(chilItem.getText().equals(valueExpected))
		  {
			  javascript.executeScript("arguments[0].scrollIntoView(true);", chilItem);
			  javascript.executeScript("arguments[0].click()", chilItem);
			  Thread.sleep(3000);
			  break;
		  }
	  }

  }

}
