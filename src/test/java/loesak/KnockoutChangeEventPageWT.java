package loesak;

import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
;

public class KnockoutChangeEventPageWT {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private WebDriver driver = null;
	private KnockoutChangeEventTestPage page = null;
	
	@Before
	public void setup() {
		this.driver = new FirefoxDriver(DesiredCapabilities.firefox());
//		this.driver = new SafariDriver(DesiredCapabilities.safari());
		this.page = KnockoutChangeEventTestPage.go(this.driver);
	}
	
	@After
	public void teardown() {
		this.driver.close();
		this.driver = null;
	}
	
	@Test
	public void test_tab() {
		// clear input field
		this.page.input.clear();
		
		// give input field focus
		this.page.input.click();
		
		// type text into input field
		this.page.input.sendKeys("gobbledegook");
	
		// tab to fire change event
		this.page.output.sendKeys(Keys.TAB);
		
		// verify output changed
		this.collector.checkThat(this.page.output.getText(), is("gobbledegook"));
	}
	
	@Test
	public void test_click() {
		// clear input field
		this.page.input.clear();
		
		// give input field focus
		this.page.input.click();
		
		// type text into input field
		this.page.input.sendKeys("gobbledegook");
	
		// click away in hopes to fire change event
		this.page.output.click();
		
		// verify output changed
		this.collector.checkThat(this.page.output.getText(), is("gobbledegook"));
	}
	
	@Test
	public void test_jquery() {
		// clear input field
		this.page.input.clear();
		
		// give input field focus
		this.page.input.click();
		
		// type text into input field
		this.page.input.sendKeys("gobbledegook");
	
		// explicitly fire change event
		((JavascriptExecutor) driver).executeScript(
		        "console.log(arguments[0]); $(arguments[0]).change(); return true;"
		    , this.page.input);
		
		// verify output changed
		this.collector.checkThat(this.page.output.getText(), is("gobbledegook"));
	}
}