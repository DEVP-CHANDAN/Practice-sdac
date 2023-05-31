import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginModuleTest {
    public static void main(String[] args) {
    	ChromeOptions option = new ChromeOptions();
    	option.addArguments("--remote-allow-origins=*");
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rupesh\\Desktop\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver(option);

        // Navigate to the login page
        driver.get("http://localhost:8081/ChatGpt/Login.jsp");

        // Find the username and password fields
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the username and password
        usernameField.sendKeys("john");
        passwordField.sendKeys("password123");

        // Submit the login form
        passwordField.submit();

        // Wait for the next page to load (replace "success.jsp" with the actual success page URL)
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/button"));

        // Perform assertions or additional actions as needed
        // For example, you can assert the presence of a welcome message on the success page:
        WebElement welcomeMessage = driver.findElement(By.tagName("h1"));
        String messageText = welcomeMessage.getText();
        if (messageText.contains("Welcome")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the browser
        driver.quit();
    }
}
