import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase3 {
	 public static void main(String[] args) {
		 	System.setProperty("webdriver.firefox.marionette","C:\\Users\\vivek\\Downloadsgeckodriver.exe");
	        WebDriver driver = new FirefoxDriver();
	        String baseUrl = "http://checkbox.io/studies.html";
	        driver.get(baseUrl);
	        List<WebElement>  ElmentList =  driver.findElements(By.xpath(".//*[@id='dynamicStudies']/div[*]/div[2]/a/span"));
	        WebDriverWait wait = new WebDriverWait(driver, 5);
	        
	        boolean errorFlag = false;
	        String elmentTestValue = "OPEN";
	        String elementActualValue;
	        
	        try{
		        for( WebElement element : ElmentList ){
		        	elementActualValue = element.getText();
			        if (elementActualValue.equals(elmentTestValue)){
			        	wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.xpath("./../../div[1]/button"))));
			        }
		        }
		        if (!errorFlag){
		            System.out.println("Test Passed!");
		        }
		        
		        driver.close();
		        System.exit(0);
	        }
	        
	        catch(TimeoutException e){
	        	errorFlag = true;
	        	System.out.println("Test Failed");
	        	driver.close();
		        System.exit(-1);
	        }
	    }
}
