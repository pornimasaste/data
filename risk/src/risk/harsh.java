package risk;


import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class harsh {

	public static void main(String[] args)throws Exception {
 
			int i, accuresult=0;
			String baseURL="http://www.sword-activerisk.com/";
			String searchCriteria="Risk management";
			By searchTextBox= By.name("s");
			By searchButton=By.id("searchsubmit");
			By searchResult=By.className("metaPost");
			
			WebDriver wd=new FirefoxDriver();
			wd.navigate().to(baseURL);
			Thread.sleep(5000);
			wd.manage().window().maximize();
			
			wd.findElement(searchTextBox).sendKeys(searchCriteria);
			wd.findElement(searchButton).click();
			Thread.sleep(5000);
			List<WebElement> L1=wd.findElements(searchResult);
			System.out.println("Total search Result:" + L1.size());
			for (i=0;i<L1.size();i++)
			{
				String SearchResultTitle = L1.get(i).getText();
				if(SearchResultTitle.contains(searchCriteria)==true)
            {
					accuresult++;
					
			}
				int index=SearchResultTitle.indexOf(" ");
				String expectedPageTitle = SearchResultTitle.substring(index+8);
				String CurrentURL =wd.getCurrentUrl();
				L1.get(i).findElement(By.tagName("a")).click();
				Thread.sleep(5000);
				System.out.println("Link is :"+wd.getTitle());
				String actualTitle=wd.getTitle();
				
				if(SearchResultTitle.contains(actualTitle))
				{
					System.out.println("correct page is opened");
				}
				wd.navigate().to(CurrentURL);
				Thread.sleep(5000);
				L1= wd.findElements(searchResult);	
		}
		
			wd.close();
	}

}