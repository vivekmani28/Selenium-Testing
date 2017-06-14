import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase4 {
	 public static void main(String[] args) {
		 	System.setProperty("webdriver.firefox.marionette","C:\\Users\\vivek\\Downloadsgeckodriver.exe");
	        WebDriver driver = new FirefoxDriver();
	        String baseUrl = "http://checkbox.io/studies.html";
	        driver.get(baseUrl);
	        WebElement  parentElement =  driver.findElement(By.xpath(".//*[@id='dynamicStudies']/div[12]"));
	      
	        String elmentTestValue = "/media/amazongc-micro.jpg";
	        String elementActualValue;
	        try{
	        	WebElement childElement = parentElement.findElement(By.xpath("./div[1]/div[1]/div[2]/span/img"));
	        	elementActualValue = childElement.getAttribute("src");
	        	//System.out.println(elementActualValue);
	        	if (elementActualValue.indexOf(elmentTestValue) != -1 ){
		            System.out.println("Test Passed!");
		        } else {
		            System.out.println("Test Failed. Image element found. No Amazon reward image is present");
		        }
	        	driver.close();
	 	        System.exit(0);
	        }
	        catch(NoSuchElementException excep){
	        	System.out.println("Test Failed. No Image element is present");
	        	driver.close();
		        System.exit(-1);
	        }
	        
	       
	    }
}
