package main;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import main.IhgHome_Page;

public class MainTest {
	
	private static WebDriver chromeDriver;
	public final String PAGE_TITLE_ES = "IHG | InterContinental Hotels Group";
	public final String COPYRIGHT_TEXT_ES = "© 2017 IHG. Todos los derechos reservados. La mayoría de los hoteles son de propiedad y gestión independiente.";
	public IhgHome_Page homePage;
	
	@BeforeTest
	public void setUp() throws Exception {
		File file = new File("C:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		chromeDriver = new ChromeDriver();
		homePage = new IhgHome_Page(chromeDriver);
        chromeDriver.get("https://www.ihg.com");
        Thread.sleep(2000);
	}
	
	@AfterTest
	public void quit() {
		chromeDriver.quit();
	}
	
	@Test
	public void test1() {
		if(homePage.isFooterPresent()) {
			assert(homePage.isFooterTextValid(COPYRIGHT_TEXT_ES));
		}
	}
	
	@Test
	public void test2() {
		assertEquals(PAGE_TITLE_ES, homePage.getPageTitle());
	}
}
