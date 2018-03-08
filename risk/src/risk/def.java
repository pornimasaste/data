package risk;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class def {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.sword-activerisk.com/");
		
		driver.findElement(By.xpath("//*[@id='s']")).sendKeys("Risk MAnagement");
		
		driver.findElement(By.xpath("//*[@id='searchsubmit']")).click();
		
		WebElement count=driver.findElement(By.id("internal-page-content"));
		System.out.println(count.findElements(By.tagName("time")).size());
		
		List<WebElement> linksList = driver.findElements(By.tagName("time"));
        System.out.println("Total links count : " + linksList.size());
        
        
       // List<WebElement> linksList1 = (List<WebElement>) driver.findElement(By.id("internal-page-content"));
        //System.out.println();
		
       /* for (WebElement anchorTagElement : linksList) {
        	String url = anchorTagElement.findElement(By.id("internal-page-content"));
        	System.out.println(url);
        }*/
        }
	}


