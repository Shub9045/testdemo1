package testinggitdemo;


	

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class testinggitdemo {
		static String username;
		static String password;
		public static void main(String args[]) throws InterruptedException
		{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shubham88368\\Desktop\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//headless execution
			/*ChromeOptions ch = new ChromeOptions();
			ch.addArguments("headless");
			WebDriver driver = new ChromeDriver(ch);
			*/
			
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
		//User name
			String[] username_arr = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText().split(":");
		
			String usr = username_arr[1].replaceAll("\n", ",");
			String [] usrarr = usr.split(",");
			username = usrarr[1];
		
		//Password
		String[] password_arr = driver.findElement(By.xpath("//div[@class='login_password']")).getText().split(":");
		
		{
				password = password_arr[1];
		}
		
		driver.findElement(By.xpath("//input[@placeholder ='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		 //System.out.println("Testcase execute successfully");
		 
		 List <WebElement> itemlist = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		 List<WebElement> addtocart = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
		 	for(int i = 0; i<itemlist.size(); i++)
		 	{
		 		if(itemlist.get(i).getText().equals("Sauce Labs Bike Light")) 
		 		{
		 			addtocart.get(i).click();
		 		}
		 		if(itemlist.get(i).getText().equals("Sauce Labs Backpack"))
		 		{
		 			addtocart.get(i).click();
		 		}
		 	}
		 	// Cart link
		 	driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		 	
		 	//Checkout
		 	driver.findElement(By.xpath("//button[@id='checkout']")).click();
		 	driver.findElement(By.xpath("//input[@placeholder = 'First Name']")).sendKeys("Shubham");
		 	driver.findElement(By.xpath("//input[@placeholder = 'Last Name']")).sendKeys("Bansal");
		 	driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("443023");
		 	
		 	JavascriptExecutor js = (JavascriptExecutor)driver;
		 	js.executeScript("window.scrollBy(0,250)");
		 	driver.findElement(By.xpath("//input[@id='continue']")).click();
		 	driver.findElement(By.xpath("//button[@id='finish']")).click();
		 	String ordermsg = driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")).getText();
		 		if(ordermsg.equals("THANK YOU FOR YOUR ORDER"))
		 				{
		 			System.out.println("End 2 End flow execute successfully");
		 				}
		driver.quit();

	}
	}

