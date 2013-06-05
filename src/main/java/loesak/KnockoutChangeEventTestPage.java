package loesak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KnockoutChangeEventTestPage {
	
	@FindBy(css = "*[data-test-asset=input]")
	public WebElement input;
	
	@FindBy(css = "*[data-test-asset=output]")
	public WebElement output;
	
	public static KnockoutChangeEventTestPage go(WebDriver driver) {
		driver.get("http://localhost:8080/knockout.webdriver.change.event.test");
		
		KnockoutChangeEventTestPage page = new KnockoutChangeEventTestPage();
		
		PageFactory.initElements(driver, page);
		
		return page;
	}
}