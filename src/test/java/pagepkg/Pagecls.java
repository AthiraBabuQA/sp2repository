package pagepkg;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import basepkg.Basecls;

public class Pagecls extends Basecls{
   @FindBy(name ="field-keywords" )
   WebElement searchbar;
   @FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2")
   WebElement phone;
   @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
   WebElement addtocart;
   public Pagecls(WebDriver driver)
   {
	  this.driver=driver;
	  PageFactory.initElements( driver,this);
   }
   public void search()
   {
	   searchbar.sendKeys("mobilephones",Keys.ENTER);
   }
   public void titleverification()
   {
	   String actualTitle =driver.getTitle();
	   String expectedTitle = "Amazon.in : mobilesphones";
	   if(actualTitle.equals(expectedTitle))
	   {
	   	System.out.println("passed.Title is verified");
	   }
	   else
	   {
	   	System.out.println("failed");
	   }
	   
   }
   public void product()
   {
	   phone.click();
   }
   public void windowhandler()
   {
	        String parentWindow=driver.getWindowHandle();
	        Set<String> allWindow=driver.getWindowHandles();
	   		for (String windowHandle :allWindow) 
	   		{
	   			if(!windowHandle.equalsIgnoreCase(parentWindow)) {
	   			driver.switchTo().window(windowHandle);
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        JavascriptExecutor js=(JavascriptExecutor)driver;
		        js.executeScript("window.scrollBy(0,200)", "");
		        addtocart.click();
	   			}
		driver.switchTo().window(parentWindow);
		driver.navigate().refresh();
	}
		   
   }}
