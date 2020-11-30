package Jenkins_Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstDemo {
	public static WebDriver dr;
	public static String url;	
	@Test
	public void demo() throws InterruptedException{
		
		url ="https://www.snowsoftware.com/";
	    System.out.println(System.getProperty("user.dir"));

		//1.lunch driver.                                                            
	    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\BroweseEXE\\chromedriver.exe");
		
		//2.open crome driver.
	    dr =  new ChromeDriver();	
	    dr.get(url);
	    dr.manage().window().maximize();
	    dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    Thread.sleep(3000);
	    dr.quit();
		
		System.out.println("Jenkins12345");
		//Test for Github.
		//Test for Github once again commit.
	}

}
