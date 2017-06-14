# Selenium Testing

Here we perform Selenium unit testing on a sample site http://checkbox.io, which is a survey hosting site.

All the JAVA files are attached in the repo.


### Test case snippets

#### The participant count of "Frustration of Software Developers" is 55
```
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
```

#### The total number of studies closed is 5.
```
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
```

#### If a status of a study is open, you can click on a "Participate" button.
```
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
```

#### Check if the "Software Changes Survey" has a Amazon reward image.
```
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
```
