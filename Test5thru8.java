import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.logging.Level;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Test5thru8 {

	WebDriver driver = new HtmlUnitDriver();

	@Before
	public void setup(){
		driver.get("https://cs1632ex.herokuapp.com/");
	}

	//Fibonacci test 1 - Enter an edge invalid value for the Fibonacci page
	//near the boundary of good values, in this case: 0 and should get "1"
	@Test
	public void fibonacciTest1(){
		try {
			WebElement elem = driver.findElement(By.linkText("Fibonacci"));
			elem.click();
			elem = driver.findElement(By.name("value"));
			elem.sendKeys("0");
			elem.submit();
			elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("1"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Fibonacci test 2 - Enter an invalid value for the Fibonacci page
	// at the boundary that an int can hold, in this case: -10000000000000000000000000000000000000000000
	// and the result should be "1"
	@Test
	public void fibonacciTest2(){
		try {
			WebElement elem = driver.findElement(By.linkText("Fibonacci"));
			elem.click();
			elem = driver.findElement(By.name("value"));
			elem.sendKeys("-10000000000000000000000000000000000000000000");
			elem.submit();
			elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("1"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}


	}

	//Fibonacci test 3 - Enter an invalid value for the Fibonacci page
	// in this case not an int but string "iohieo"
	@Test
	public void fibonacciTest3(){
		try {
			WebElement elem = driver.findElement(By.linkText("Fibonacci"));
			elem.click();
			elem = driver.findElement(By.name("value"));
			elem.sendKeys("iohieo");
			elem.submit();
			elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("1"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Factorial test 1 - Enter an edge invalid value for the Factorial page
	//near the boundary of good values, in this case: 0 and should result in "1"
	@Test
	public void factorialTest1(){
		try {
			WebElement elem = driver.findElement(By.linkText("Factorial"));
			elem.click();
			elem = driver.findElement(By.name("value"));
			elem.sendKeys("0");
			elem.submit();
			elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("1"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Factorial test 2 - Enter an invalid value for the Factorial page
	// at the boundary that an int can hold, in this case: -10000000000000000000000000000000000000000000
	// and the result should be "1"
	@Test
	public void factorialTest2(){
		try {
			WebElement elem = driver.findElement(By.linkText("Fibonacci"));
			elem.click();
			elem = driver.findElement(By.name("value"));
			elem.sendKeys("-10000000000000000000000000000000000000000000");
			elem.submit();
			elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("1"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Factorial test 3 - Enter an invalid value for the Factorial page
	// in this case not an int but string "iohieo"
	@Test
	public void factorialTest3(){
		try {
			WebElement elem = driver.findElement(By.linkText("Factorial"));
			elem.click();
			elem = driver.findElement(By.name("value"));
			elem.sendKeys("iohieo");
			elem.submit();
			elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("1"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Hello page test 1 - Access the hello page with no trailing values will
	//display the message "Hello CS1632, from Prof. Laboon!"
	@Test
	public void helloPageTest1() {
		try {
			driver.get("https://cs1632ex.herokuapp.com/hello");
			WebElement elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("Hello CS1632, from Prof. Laboon!"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Hello page test 2 - Access the hello page with a trailing value of "/Emily+Hanna"
	// this will display the message "Hello CS1632, from Emily Hanna"
	@Test
	public void helloPageTest2() {
		try {
			driver.get("https://cs1632ex.herokuapp.com/hello/Emily+Hanna");
			WebElement elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("Hello CS1632, from Emily+Hanna"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Hello page test 3 - Access the hello page with a trailing value of "/Emily/Hanna"
	// this should display the message "Hello CS1632, from Emily/Hanna"
	@Test
	public void helloPageTest3() {
		try {
			driver.get("https://cs1632ex.herokuapp.com/Emily/Hanna");
			WebElement elem = driver.findElement(By.className("jumbotron"));
			String result = elem.getText();
			assertTrue(result.contains("Hello CS1632, from Emily/Hanna"));
		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}

	//Cathedral page test  - Ensure there are in fact a list of three images on the page
	@Test
	public void cathedralPageTest() {
		try {
			driver.get("https://cs1632ex.herokuapp.com/cathy");
			int size = driver.findElements(By.xpath("/html/body/div/main/div/ol/li/img")).size();
			assertTrue(size == 3);

		}
		catch(NoSuchElementException nsee) {
			fail();
		}

	}




	@After
	public void tearDown(){
		driver.quit();
	}

}
