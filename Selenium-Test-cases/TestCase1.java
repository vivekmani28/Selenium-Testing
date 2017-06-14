import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {
	 public static void main(String[] args) {
		 	System.setProperty("webdriver.firefox.marionette","C:\\Users\\vivek\\Downloadsgeckodriver.exe");
	        WebDriver driver = new FirefoxDriver();
	        String baseUrl = "http://checkbox.io/studies.html";
	        driver.get(baseUrl);
	        WebElement frustationElement = driver.findElement(By.xpath(".//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]"));
	      
	        String frustationElmentTestValue = "55";
	        String frustationElementActualValue = frustationElement.getText();
	        
	        System.out.println("Expected value :" + frustationElmentTestValue);
	        System.out.println("Actual value :" + frustationElementActualValue);
	        
	        if (frustationElementActualValue.equals(frustationElmentTestValue)){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }
	       
	        driver.close();
	        System.exit(0);
	    }


}
