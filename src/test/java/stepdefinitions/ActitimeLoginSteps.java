package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitimeLoginSteps {
	WebDriver driver;
	
	@Given("Launch browser and enter actitime url")
	public void launch_browser_and_enter_actitime_url() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demo.actitime.com/login.do");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("login credentials are entered")
	public void login_credentials_are_entered() {
	   driver.findElement(By.id("username")).sendKeys("admin");
	   driver.findElement(By.name("pwd")).sendKeys("manager");
	}

	@When("login button is clicked")
	public void login_button_is_clicked() {
	    driver.findElement(By.id("loginButton")).click();
	}

	@Then("Actitime home page should display")
	public void actitime_home_page_should_display() {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains("Time-Track"));
	    driver.quit();
	}
}
