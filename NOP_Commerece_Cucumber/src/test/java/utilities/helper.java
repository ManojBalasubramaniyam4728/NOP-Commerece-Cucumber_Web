package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {

	public WebDriver driver;
	
	public helper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitTillVisibilityOfElement(WebElement element,long durationSecounds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationSecounds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillVisibilityOfElementLocated(String locater,String locaterValue,long durationSecounds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationSecounds));
		if (locater.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locaterValue)));
		}
		else if (locater.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locaterValue)));
		}
		else if (locater.equalsIgnoreCase("cssSelector")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locaterValue)));
		}
		else if (locater.equalsIgnoreCase("className")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locaterValue)));
		}
		else if (locater.equalsIgnoreCase("linkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locaterValue)));
		}
		else if (locater.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locaterValue)));
		}
		else if (locater.equalsIgnoreCase("tagName")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locaterValue)));
		}
		else if (locater.equalsIgnoreCase("partialLinkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locaterValue)));
		}	
	}
	public void waitTillelementToBeClickable(WebElement element,long durationSecounds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationSecounds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
