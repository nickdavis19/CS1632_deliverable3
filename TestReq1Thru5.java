import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class TestReq1Thru5 {
	
		WebDriver driver = new HtmlUnitDriver();
		
		@Before
		public void setup(){
			driver.get("https://cs1632ex.herokuapp.com/");
		}
		
		//The homepage should display "Welcome, friend, to a land of pure calculation"
		@Test
		public void homepageTextTest1(){
			try{
				WebElement e = driver.findElement(By.className("lead"));
				String observed = e.getText();
				observed = observed.replaceAll("\\s+", "");
				String expected = "Welcome, friend, to a land of pure calculation";
				expected = expected.replaceAll("\\s+", "");
				assertTrue(observed.contains(expected));
			}catch(NoSuchElementException nseex){
				fail();
			}
		}
		
		//The hompage should display Used for CS1632 Software Quality Assurance, taught by Bill Laboon
		@Test
		public void homepageTextTest2(){
			try{
				WebElement e = driver.findElement(By.xpath("(//p[@class='lead'])[2]"));
				String observed = e.getText();
				observed = observed.replaceAll("\\s+", "");
				String expected = "Used for CS1632 Software Quality Assurance, taught by Bill Laboon";
				expected = expected.replaceAll("\\s+", "");
				assertTrue(observed.contains(expected));
			}catch(NoSuchElementException nseex){
				fail();
			}
		}

		//The hompage should have a link at the top "CS 1632 D3 Home" linked to "/"
		@Test
		public void homepageLinkTest1(){
			try{
				WebElement e = driver.findElement(By.xpath("//a[@href='/']"));
				String observed = e.getAttribute("href");
				observed = observed.replaceAll("\\s+", "");
				String expected = "/";
				expected = expected.replaceAll("\\s+", "");
				assertTrue(observed.contains(expected));
			}catch(NoSuchElementException nseex){
				System.out.println("Element not found 1");
				fail();
			}
		}
		
		//The homepage should have a link at the top "Factorial" linked to "/fact"
		@Test
		public void homepageLinkTest2(){
			try{
				WebElement e = driver.findElement(By.xpath("//a[@href='/fact']"));
				String observed = e.getAttribute("href");
				observed = observed.replaceAll("\\s+", "");
				String expected = "/fact";
				expected = expected.replaceAll("\\s+", "");
				assertTrue(observed.contains(expected));
			}catch(NoSuchElementException nseex){
				System.out.println("Element not found2");
				fail();
			}
		}
		
		//The hompage should have a link at the top "Fibonacci" linked to "/fib"
		@Test
		public void homepageLinkTest3(){
			try{
				WebElement e = driver.findElement(By.xpath("//a[@href='/fib']"));
				String observed = e.getAttribute("href");
				observed = observed.replaceAll("\\s+", "");
				String expected = "/fib";
				expected = expected.replaceAll("\\s+", "");
				assertTrue(observed.contains(expected));
			}catch(NoSuchElementException nseex){
				System.out.println("Element not found3");
				fail();
			}
		}
		
		//The homepage should have a link at the top "hello" linked to "/hello"
		@Test
		public void homepageLinkTest4(){
			try{
				WebElement e = driver.findElement(By.xpath("//a[@href='/hello']"));
				String observed = e.getAttribute("href");
				observed = observed.replaceAll("\\s+", "");
				String expected = "/hello";
				expected = expected.replaceAll("\\s+", "");
				assertTrue(observed.contains(expected));
			}catch(NoSuchElementException nseex){
				System.out.println("Element not found4");
				fail();
			}
		}
		
		//The homepage should have a link at the top "Cathedral Pics" linked to "/cathy"
		@Test
		public void homepageLinkTest5(){
			try{
				WebElement e = driver.findElement(By.xpath("//a[@href='/cathy']"));
				String observed = e.getAttribute("href");
				observed = observed.replaceAll("\\s+", "");
				String expected = "/cathy";
				expected = expected.replaceAll("\\s+", "");
				assertTrue(observed.contains(expected));
			}catch(NoSuchElementException nseex){
				System.out.println("Element not found5");
				fail();
			}
		}
		
		//The factorial page should return the factorial of any value 1-100
		//Tests the happy value of 12
		@Test
		public void factorialTestValue12(){
			WebElement e = driver.findElement(By.linkText("Factorial"));
			e.click();
			e = driver.findElement(By.name("value"));
			e.sendKeys("12");
			e.submit();
			e = driver.findElement(By.className("jumbotron"));
			String observed = e.getText();
			assertTrue(observed.contains("479001600"));
		}
		
		//The factorial page should return the factorial of any value 1-100
		//Tests the edge value of 100
		@Test
		public void factorialTestValue100(){
			WebElement e = driver.findElement(By.linkText("Factorial"));
			e.click();
			e = driver.findElement(By.name("value"));
			e.sendKeys("100");
			e.submit();
			e = driver.findElement(By.className("jumbotron"));
			String observed = e.getText();
			assertTrue(observed.contains("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"));
		}
		
		//The factorial page should return the factorial of any value 1-100
		//Tests the invalid value of 0
		@Test
		public void factorialTestValue0(){
			WebElement e = driver.findElement(By.linkText("Factorial"));
			e.click();
			e = driver.findElement(By.name("value"));
			e.sendKeys("0");
			e.submit();
			e = driver.findElement(By.className("jumbotron"));
			String observed = e.getText();
			assertTrue(observed.contains("1"));
		}
		
		//The fibonacci page should return the fibonacii of any value 1-100
		//Tests the happy path value of 35
		//This test fails because of a defect in the fibonacci calculator
		@Test
		public void fibonacciTestValue35(){
			WebElement e = driver.findElement(By.linkText("Fibonacci"));
			e.click();
			e = driver.findElement(By.name("value"));
			e.sendKeys("35");
			e.submit();
			e = driver.findElement(By.className("jumbotron"));
			String observed = e.getText();
			assertTrue(observed.contains("9227465"));
		}
		
		//The fibonacci page should return the fibonacii of any value 1-100
		//Tests the edge path value of 1
		@Test
		public void fibonacciTestValue1(){
			WebElement e = driver.findElement(By.linkText("Fibonacci"));
			e.click();
			e = driver.findElement(By.name("value"));
			e.sendKeys("1");
			e.submit();
			e = driver.findElement(By.className("jumbotron"));
			String observed = e.getText();
			assertTrue(observed.contains("1"));
		}
		
		//The fibonacci page should return the fibonacii of any value 1-100
		//Tests the edge path value of 1
		@Test
		public void fibonacciTestValue0(){
			WebElement e = driver.findElement(By.linkText("Fibonacci"));
			e.click();
			e = driver.findElement(By.name("value"));
			e.sendKeys("0");
			e.submit();
			e = driver.findElement(By.className("jumbotron"));
			String observed = e.getText();
			assertTrue(observed.contains("1"));
		}
		
		@After
		public void tearDown(){
			driver.quit();
		}

}


