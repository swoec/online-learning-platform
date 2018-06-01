package test.java;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import main.java.com.angular.util.PageUtils;

public class Webtest {

	@Test
	public void test() throws InterruptedException {
		//1、open a browse and the target website
        WebDriver driver = PageUtils.getChromeDriver("http://localhost:8081/Angular");

      //2、fill the login information
        WebElement loginInput = driver.findElement(By.id("uname"));  
        loginInput.sendKeys("admin");  
        WebElement pwdInput = driver.findElement(By.id("password"));  
        pwdInput.sendKeys("1");  
           
        //3、get the submit button 
        WebElement submitElement = driver.findElement(By.cssSelector("input#bt"));

        //4、click
        PageUtils.scrollToElementAndClick(submitElement, driver);

        //rest fot 3 seconds
        Thread.sleep(3000);

        //5、add a new user information name phone sex
        WebElement newuname = driver.findElement(By.name("uname"));  
        newuname.sendKeys("nov");
        WebElement newphone = driver.findElement(By.name("uphone"));  
        newphone.sendKeys("79997788");
        //driver.find_element_by_xpath('//input[@value="male"]').click();
        WebElement newusex = driver.findElement(By.xpath("//input[@value='male']")); 
        if(!newusex.isSelected()){
             newusex.click();
        }
        WebElement usersubmitElement = driver.findElement(By.cssSelector("input#dttd"));
        PageUtils.scrollToElementAndClick(usersubmitElement, driver);
        
        
        //remove a user
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        //WebElement btt=  driver.findElement(By.xpath("//span[contains(.,'www')]"));
        WebElement btt=  driver.findElement(By.xpath("//button[@value='28']"));
        //WebElement btt=  driver.findElement(By.xpath("//form[@id='myForm']/button[19]"));
       
        //int yScrollPosition = btt.getLocation().getY() - 100;        
        //int xScrollPosition = btt.getLocation().getX();     
        //JavascriptExecutor executor = (JavascriptExecutor) driver;      
        //executor.executeScript("window.scroll(" + xScrollPosition + ", " + yScrollPosition + ");");
        
        //please pay attention to the ng-click
        Actions action = new Actions(driver);
        action.moveToElement(btt).perform();
        action.moveToElement(btt).click().perform();
       
        
        /*
        buttons.get(19).click();
        for(int i=1;i<=buttons.size();i++){
        	WebElement li =(WebElement)buttons.get(i);
        	System.out.println(li.getAttribute("id"));
        	if("18".equals(li.getAttribute("id"))){
        		li.click();
        	}
        }
        */
       // update a user
       
        WebElement bttuur=  driver.findElement(By.xpath("//button[@value='29u']"));
        Actions actionupdate = new Actions(driver);
        actionupdate.moveToElement(bttuur).perform();
        actionupdate.moveToElement(bttuur).click().perform();
        
        //set values
        WebElement updateuname = driver.findElement(By.name("uname"));  
        updateuname.clear();//clear the previous value
        updateuname.sendKeys("novup");
        WebElement updatephone = driver.findElement(By.name("uphone"));
        updatephone.clear();
        updatephone.sendKeys("up799");
        
        WebElement updateusex = driver.findElement(By.xpath("//input[@value='male']")); 
        if(!updateusex.isSelected()){
        	updateusex.click();
        }
        // submit
        WebElement userupdateElement = driver.findElement(By.cssSelector("input#dttd"));
        PageUtils.scrollToElementAndClick(userupdateElement, driver);

        
	}

}
