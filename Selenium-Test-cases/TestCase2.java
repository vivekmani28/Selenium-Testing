import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase2 {
	 public static void main(String[] args) {
		 	System.setProperty("webdriver.firefox.marionette","C:\\Users\\vivek\\Downloadsgeckodriver.exe");
	        WebDriver driver = new FirefoxDriver();
	        String baseUrl = "http://checkbox.io/studies.html";
	        driver.get(baseUrl);
	        List<WebElement>  ElmentList =  driver.findElements(By.xpath(".//*[@id='dynamicStudies']/div[*]/div[2]/a/span"));
	      
	        String elmentTestValue = "CLOSED";
	        String elementActualValue;
	        int closedCount = 0, expectedCount =5;
	        
	        for( WebElement element : ElmentList ){
	        	elementActualValue = element.getText();
		        if (elementActualValue.equals(elmentTestValue)){
		        	closedCount++;
		        }
	        }
	        
	        if (expectedCount == closedCount){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }

	        driver.close();
	        System.exit(0);
	    }
}
