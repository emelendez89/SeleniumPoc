package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IhgHome_Page {
	
	public IhgHome_Page(WebDriver chromeDriver) {
		e = chromeDriver;
	}
	
	private final By pageFooter = By.className("footer-copyrightBlock");
	
	private final By copyrightText = By.className("footer-copyrightText");
	
	private WebDriver e;
	
	public String getPageTitle() {
		return e.getTitle();
	}
		
	public boolean isFooterPresent() {
		WebElement footer = e.findElement(pageFooter);
		return footer.findElements(copyrightText).size() > 0;
//				
	}
	
	public boolean isFooterTextValid(String footerText) {
		WebElement footer = e.findElement(pageFooter);
		return footerText.equalsIgnoreCase(footer.getText());
	}

}
