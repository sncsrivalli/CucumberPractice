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

public class ActitimeWithParamaterization {

	WebDriver driver;

	@Given("User launches browser and enters actitime url")
	public void user_launches_browser_and_enters_actitime_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
	}

	@When("clicks on login")
	public void clicks_on_login() {
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("^home Page (.*) is displayed$")
	public void home_page_status_is_displayed(String status) {
		System.out.println(status);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Time-Track"));
		driver.quit();
	}
}
